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

    private final DaoCRUD<Comment> daoCRUD;

    public CommentServiceImpl() {
        daoCRUD=new CommentDaoImpl();
    }

    @Override
    public CommentDto getById(Long id) {

        Comment comment=daoCRUD.getById(id)
                .orElseThrow(()->new NotFoundException(String.format(COMMENT_NOT_FOUND_EXCEPTION_MESSAGE,id)));

        return CommentMapper.getCommentDto(comment);
    }

    @Override
    public CommentDto getByField(String text) {

         Comment comment = daoCRUD.getByField(text)
                .orElseThrow(()-> new NotFoundException(String.format(EMPTY_LIST_BY_FIELD_EXCEPTION_MESSAGE,text)));

        return CommentMapper.getCommentDto(comment);
    }

    @Override
    public List<CommentDto> getAll() {
        List<Comment> list=daoCRUD.getAll();

        List<CommentDto>dtoList= list.stream()
                .map(CommentMapper::getCommentDto)
                .collect(Collectors.toList());


        if (dtoList.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public List<CommentDto> getAllLimit() {
        List<Comment> list=daoCRUD.getAllLimit();

        List<CommentDto>dtoList= list.stream()
                .map(CommentMapper::getCommentDto)
                .collect(Collectors.toList());

        if (dtoList.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public List<CommentDto> getByUserId(Long userId) {
        List<Comment> list=daoCRUD.getByUserId(userId);

        List<CommentDto>dtoList= list.stream()
                .map(CommentMapper::getCommentDto)
                .collect(Collectors.toList());

        if (dtoList.isEmpty()){
            throw  new NotFoundException(EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE);
        } return dtoList;
    }

    @Override
    public boolean insert(Comment comment) {
        if(daoCRUD.insert(comment)){
            return true;
        } else {
            throw new NotFoundException(CREATE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByEntity(Comment comment) {
        if (daoCRUD.updateByEntity(comment)){
            return true;
        } else {
            throw new NotFoundException(UPDATE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean updateByField(String text, String textCondition) {
        if(daoCRUD.updateByField(text, textCondition)){
            return true;
        }  else {
            throw new NotFoundException(UPDATE_COMMENT_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean deleteById(Long id) {
        if(daoCRUD.deleteById(id)){
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
        if(daoCRUD.delete(comment)){
    return true;
        } else {
            throw new NotFoundException(DELETE_COMMENT_EXCEPTION_MESSAGE);
        }
    }
}
