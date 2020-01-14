package dao.impl;

import entity.Comment;
import entity.Comment.CommentQueries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CommentDaoImpl extends DaoCRUDAbsImpl<Comment> {

    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        public CommentDaoImpl() {
            super();
            init();
        }

        protected void init() {
            for (CommentQueries commentQueries : CommentQueries.values()) {
                sqlQueries.put(commentQueries.getSqlQuery(), commentQueries);
            }
        }

        protected Comment createInstance(String[] args) {
            return new Comment(
                    Long.parseLong(args[0] == null ? "0" : args[0]),
                    args[1] == null ? "" : args[1],
                    LocalDateTime.parse(args[2] == null ? LocalDateTime.now().toString() : args[2], formatter),
                    Long.parseLong(args[3]==null ? "0" : args[3]),
                    Long.parseLong(args[4]==null ? "0" : args[4])
            );
        }

        protected String[] getUpdateFields(Comment comment) {
            String[] result = new String[3];
            String[] allFields = getFields(comment);
            result[0] = allFields[0]; // text_of_comment
            result[1] = allFields[1]; // place_id
            //result[2] = allFields[2];
            result[2] = comment.getId().toString(); // id
            return result;
        }

        protected String[] getFields(Comment comment) {

            String[] fields = new String[3];

            fields[0] = comment.getTextOfComment();
            fields[1] = comment.getPlaceId().toString();
            fields[2] = comment.getUserId().toString();

            return fields;
        }
}
