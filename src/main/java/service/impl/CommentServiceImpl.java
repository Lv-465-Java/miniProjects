package service.impl;

import dao.impl.CommentDaoImpl;
import dao.DaoCRUD;
import dto.CommentDto;
import entity.Comment;
import exception.Message;
import exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import mapper.CommentMapper;
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
    public CommentDto getById(Long id) {

        Comment comment=commentDao.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(COMMENT_NOT_FOUND_EXCEPTION_MESSAGE,id)));

        return CommentMapper.getCommentDto(comment);
    }

    @Override
    public CommentDto getByField(String text) {

         Comment comment = commentDao.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(EMPTY_LIST_BY_FIELD_EXCEPTION_MESSAGE,text)));

        return CommentMapper.getCommentDto(comment);
    }

    @Override
    public List<CommentDto> getAll() {
        List<Comment> list=commentDao.getAll();

        List<CommentDto>dtoList= list.stream()
                .map(CommentMapper::getCommentDto)
                .collect(Collectors.toList());


        if (dtoList.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public List<CommentDto> getAllLimit() {
        List<Comment> list=commentDao.getAllLimit();

        List<CommentDto>dtoList= list.stream()
                .map(CommentMapper::getCommentDto)
                .collect(Collectors.toList());

        if (dtoList.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public List<CommentDto> getByUserId(Long userId) {
        List<Comment> list=commentDao.getByUserId(userId);

        List<CommentDto>dtoList= list.stream()
                .map(CommentMapper::getCommentDto)
                .collect(Collectors.toList());

        if (dtoList.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
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

//    @Override
//    public boolean deleteByFieldName(String textCondition) {
//        return iDaoCRUD.deleteByFieldName(textCondition);
//    }

    @Override
    public boolean delete(Comment comment) {
        if(commentDao.delete(comment)){
    return true;
        } else {
            throw new NotFoundException(DELETE_COMMENT_EXCEPTION_MESSAGE);
        }
    }
}
