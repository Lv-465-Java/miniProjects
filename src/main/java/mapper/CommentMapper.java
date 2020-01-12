package mapper;

import dto.CommentDto;
import entity.Comment;

public class CommentMapper {

    public static CommentDto getCommentDto(Comment comment) {
        CommentDto commentDto=new CommentDto();

        commentDto.setTextOfComment(comment.getTextOfComment());
        commentDto.setDateOfComment(comment.getDateOfComment());
        commentDto.setUserId(comment.getUserId());
        commentDto.setPlaceId(comment.getPlaceId());

        return commentDto;
    }

    public static Comment getCommentEntity(CommentDto commentDto) {
       Comment comment=new Comment();
       comment.setTextOfComment(commentDto.getTextOfComment());
       comment.setDateOfComment(commentDto.getDateOfComment());
       comment.setPlaceId(commentDto.getPlaceId());
       comment.setUserId(commentDto.getUserId());

        return comment;
    }
}
