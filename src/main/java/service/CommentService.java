package service;

import dto.CommentDto;
import entity.Comment;

import java.util.List;

public interface CommentService {

    CommentDto getById(Long id);

    CommentDto getByField(String text);

    List<CommentDto> getAll();

    List<CommentDto> getAllLimit();


    boolean insert(Comment entity);

    boolean updateByEntity(Comment entity);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

   // boolean deleteByFieldName(String textCondition);

    boolean delete(Comment entity);
}
