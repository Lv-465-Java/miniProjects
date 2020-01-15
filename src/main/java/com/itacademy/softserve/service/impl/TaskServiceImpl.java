package com.itacademy.softserve.service.impl;

import com.itacademy.softserve.constant.ErrorMessage;
import com.itacademy.softserve.constant.NumberOfRecordsPerPage;
import com.itacademy.softserve.constant.Statuses;
import com.itacademy.softserve.dao.StatusDao;
import com.itacademy.softserve.dao.TaskDao;
import com.itacademy.softserve.dao.UserDao;
import com.itacademy.softserve.dao.builder.StatusBuilder;
import com.itacademy.softserve.dao.builder.TaskBuilder;
import com.itacademy.softserve.dao.builder.UserBuilder;
import com.itacademy.softserve.dto.TaskDto;
import com.itacademy.softserve.dto.UserDto;
import com.itacademy.softserve.dto.mapper.TaskDtoMapper;
import com.itacademy.softserve.entity.Task;
import com.itacademy.softserve.exception.NotSaveException;
import com.itacademy.softserve.service.HistoryService;
import com.itacademy.softserve.service.TaskService;
import com.itacademy.softserve.util.AutoChangeOfStatus;
import com.itacademy.softserve.util.SessionManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class TaskServiceImpl implements TaskService {
    private List<Task> tasks;
    private TaskDao taskDao;
    private UserDao userDao;
    private UserBuilder userBuilder;
    private HistoryService historyService;

    /**
     * Default constructor.
     */
    public TaskServiceImpl() {
        taskDao = new TaskDao();
        userDao = new UserDao();
        userBuilder = new UserBuilder();
    }

    /**
     * Method for getting list of tasks
     * for one page.
     *
     * @param request HTTP request object
     * @param begin   index of task in general list
     * @return list of tasks
     */
    @Override
    public List<TaskDto> getPageSet(HttpServletRequest request, int begin) {
        HttpSession session = request.getSession(false);
        UserDto userDto = (UserDto) session.getAttribute("userDto");
        Long userId = userDao.getByFields(userBuilder, userDto.getName()).get(0).getId();
        tasks = (List<Task>) session.getAttribute("tasks");
        if (tasks == null) {
            tasks = taskDao.getAll(new TaskBuilder(), userId, userId);
            Collections.reverse(tasks);
            session.setAttribute("tasks", tasks);
        }
        new AutoChangeOfStatus().updateStatuses(tasks);
        return getSet(begin);
    }

    /**
     * Method for saving tasks.
     *
     * @param request HTTP request object
     * @param taskDto UserDto object
     * @return true if task is saved
     */
    @Override
    public boolean save(HttpServletRequest request, TaskDto taskDto) {
        UserDao userDao = new UserDao();
        Task task = new Task();
        task.setAssigneeID(userDao.getByFields(new UserBuilder(), taskDto.getAssignee()).get(0).getId());
        task.setOwnerID(userDao.getByFields(new UserBuilder(), taskDto.getOwner()).get(0).getId());
        if (taskDto.getDescription().isEmpty()) {
            throw new RuntimeException(ErrorMessage.EMPTY_DESCRIPTION.toString());
        }
        task.setDescription(taskDto.getDescription());
        task.setCreationDate(taskDto.getCreationDate());
        task.setDeadline(taskDto.getDeadline());
        task.setStatusID(new StatusDao().getByFields(new StatusBuilder(), taskDto.getStatus()).get(0).getId().intValue());
        try {
            taskDao.insert(task);
            tasks = taskDao.getAll(new TaskBuilder(), task.getOwnerID(), task.getOwnerID());
            Collections.reverse(tasks);
            HttpSession session = request.getSession(false);
            session.setAttribute("tasks", tasks);
            new HistoryServiceImpl().addRecord(taskDto);
        } catch (RuntimeException e) {
            throw new NotSaveException(ErrorMessage.SUCH_TASK_EXIST.toString());
        }
        return true;
    }

    /**
     * Method for calculating number of pages.
     *
     * @return number of pages
     */
    @Override
    public int getNumberOfPages() {
        if (tasks == null) {
            return 0;
        }
        return (int) Math.ceil(((double) tasks.size()) / NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE);
    }

    /**
     * Method changes status of task on done.
     *
     * @param request HTTP request object
     * @param taskId  id of current task
     * @return true if done status is set
     */
    @Override
    public boolean setDone(HttpServletRequest request, Long taskId) {
        historyService = new HistoryServiceImpl();
        boolean status = taskDao.updateByID(new StatusDao().getByFields(new StatusBuilder(), Statuses.DONE).get(0).getId(), taskId);
        Task task = taskDao.getByID(new TaskBuilder(), taskId);
        try {
            historyService.addRecord(new TaskDtoMapper().mapFromEntityToDto(task));
        } catch (RuntimeException ignored) {
        }
        HttpSession session = request.getSession(false);
        tasks = (List<Task>) session.getAttribute("tasks");
        for (Task findToChange : tasks) {
            if (findToChange.getId().equals(taskId)) {
                findToChange.setStatusID(new StatusDao().getByFields(new StatusBuilder(), Statuses.DONE).get(0).getId().intValue());
                break;
            }
        }
        return status;
    }

    /**
     * Method deletes tasks.
     *
     * @param request HTTP request object
     * @param taskId  id of current task
     * @return true if task is deleted
     */
    @Override
    public boolean setDelete(HttpServletRequest request, Long taskId) {
        historyService = new HistoryServiceImpl();
        Task task = taskDao.getByID(new TaskBuilder(), taskId);
        TaskDto taskDto = new TaskDtoMapper().mapFromEntityToDto(task);
        taskDto.setStatus(Statuses.DELETE);
        try {
            historyService.addRecord(taskDto);
        } catch (RuntimeException ignored) {
        }
        HttpSession session = request.getSession(false);
        tasks = (List<Task>) session.getAttribute("tasks");
        for (Task findToRemove : tasks) {
            if (findToRemove.getId().equals(taskId)) {
                tasks.remove(findToRemove);
                break;
            }
        }
        return taskDao.deleteByID(taskId);
    }

    /**
     * Method for editing tasks.
     *
     * @param request     HTTP request object
     * @param description
     * @return true if user has access to edit task
     */
    @Override
    public boolean edit(HttpServletRequest request, String description) {
        boolean result = false;
        if (SessionManager.isActiveSession(request)) {
            HttpSession session = request.getSession(false);
            Long assigneeId = determineAssignee(request);
            Long ownerId = determineOwner(session);
            Long taskId = Long.parseLong(request.getParameter("confirm"));
            String newDescription = request.getParameter("newDescription");
            if (newDescription.equals("")) {
                newDescription = description;
            }
            tasks = (List<Task>) session.getAttribute("tasks");
            for (Task edited : tasks) {
                if (edited.getDescription().equals(description)) {
                    if(!edited.getOwnerID().equals(ownerId)) {
                        throw new RuntimeException(ErrorMessage.NO_PERMISSION.toString());
                    }
                    edited.setAssigneeID(assigneeId);
                    edited.setDescription(newDescription);
                }
            }
            result = taskDao.updateByField(assigneeId, newDescription, taskId);
        }
        return result;

    }

    /**
     * Method for getting list of
     * filtered tasks for one page.
     *
     * @param userDto UserDto object
     * @param regex
     * @param begin   index of task in general list
     * @return list of tasks
     */
    @Override
    public List<TaskDto> getSearchSet(UserDto userDto, String regex, int begin) {
        Long userId = userDao.getByFields(new UserBuilder(), userDto.getName()).get(0).getId();
        tasks = taskDao.getByRegex(new TaskBuilder(), userId, regex);
        Collections.reverse(tasks);
        return getSet(begin);
    }

    /**
     * Method get certain part of list.
     *
     * @param begin index of task in general list
     * @return list of tasks
     */
    private List<TaskDto> getSet(int begin) {
        int end = begin + NumberOfRecordsPerPage.TASK_RECORD_PER_PAGE;
        if (end > tasks.size()) {
            end = tasks.size();
        }
        return new TaskDtoMapper().mapToDtoList(tasks.subList(begin, end));
    }

    /**
     * Method determine task assignee.
     *
     * @param request HTTP request object
     * @return assignee id
     */
    private Long determineAssignee(HttpServletRequest request) {
        String user = request.getParameter("users");
        if (user == null) {
            HttpSession session = request.getSession(false);
            UserDto userDto = (UserDto) session.getAttribute("userDto");
            return userDao.getByFields(userBuilder, userDto.getName()).get(0).getId();
        } else {
            return userDao.getByFields(userBuilder, user).get(0).getId();
        }
    }

    /**
     * Method determine task owner.
     *
     * @param session HTTP session object
     * @return owner id
     */
    private Long determineOwner(HttpSession session) {
        UserDao userDao = new UserDao();
        String name = ((UserDto) session.getAttribute("userDto")).getName();
        return userDao.getByFields(new UserBuilder(), name).get(0).getId();
    }
}
