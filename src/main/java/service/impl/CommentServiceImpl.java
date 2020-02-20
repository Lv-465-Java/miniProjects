package service.impl;

import dao.impl.CommentDaoImpl;
import entity.Comment;
import exception.Message;
import exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import service.CommentService;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService, Message {

    private final CommentDaoImpl commentDao;

    public CommentServiceImpl() {
        commentDao=new CommentDaoImpl();
    }

    @Override
    public Comment getById(Long id) {

        return commentDao.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(COMMENT_NOT_FOUND_EXCEPTION_MESSAGE,id)));
    }

    @Override
    public Comment getByField(String text) {

         return commentDao.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(EMPTY_LIST_BY_FIELD_EXCEPTION_MESSAGE,text)));

    }

    @Override
    public List<Comment> getAll() {
        List<Comment> list=commentDao.getAll();

        if (list.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public List<Comment> getAllLimit() {
        List<Comment> list=commentDao.getAllLimit();

        if (list.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public List<Comment> getByUserId(Long userId) {
        List<Comment> list=commentDao.getByUserId(userId);

        if (list.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return list;
    }

    @Override
    public boolean insert(Comment comment) {
        if(commentDao.insert(comment)){
            return true;
        } else {
            throw new NotFoundException(CREATE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Comment comment) {
        if (commentDao.updateByEntity(comment)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByField(String text, String textCondition) {
        if(commentDao.updateByField(text, textCondition)){
            return true;
        }  else {
            throw new NotFoundException(UPDATE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(commentDao.deleteById(id)){
            return true;
        } else {
            throw new NotFoundException(DELETE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean delete(Comment comment) {
        if(commentDao.delete(comment)){
    return true;
        } else {
            throw new NotFoundException(DELETE_COMMENT_EXCEPTION_MESSAGE);
        }
    }
}
