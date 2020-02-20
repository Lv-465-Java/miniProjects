package service;

import entity.Comment;

import java.util.List;

public interface CommentService {

    Comment getById(Long id);

    Comment getByField(String text);

    List<Comment> getAll();

    List<Comment> getAllLimit();

    List<Comment> getByUserId(Long userId);

    boolean insert(Comment comment);

    boolean updateByEntity(Comment comment);

    boolean updateByField(String text, String textCondition);

    boolean deleteById(Long id);

    boolean delete(Comment entity);
}
