package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public final class Comment implements IEntity {

    public Comment(long parseLong, String s, LocalDateTime parse, long parseLong1) {
    }

    public static enum CommentQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO comments (text_of_comment, place_id, user_id) VALUES (?,?,?)"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT id, text_of_comment, date_of_comment, place_id, user_id FROM comments WHERE id = ?"),
        GET_BY_USER_ID(SqlQueries.GET_BY_USER_ID, "SELECT id, text_of_comment, date_of_comment, place_id FROM comments WHERE user_id = ?"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT id, text_of_comment, date_of_comment, place_id, user_id FROM comments WHERE date_of_comment = ?"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT id, text_of_comment, date_of_comment, place_id, user_id FROM comments;"),
        GET_ALL_LIMIT(SqlQueries.GET_ALL_LIMIT, "SELECT id, text_of_comment, date_of_comment, place_id, user_id FROM comments LIMIT 10;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE comments SET text_of_comment = ?, place_id= ? WHERE id = ?"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE comments SET text_of_comment = ? WHERE place_id = ?"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM comments WHERE id = ?");

        private SqlQueries sqlQuery;
        private String query;

        private CommentQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long id;
    private String textOfComment;
    private LocalDateTime dateOfComment;
    private Long placeId;
    private Long userId;

    public Comment(String textOfComment, Long placeId, Long userId) {
        this.textOfComment = textOfComment;
        this.placeId = placeId;
        this.userId = userId;
    }

    public Comment(String textOfComment, LocalDateTime dateOfComment, Long placeId, Long userId) {
        this.textOfComment = textOfComment;
        this.dateOfComment = dateOfComment;
        this.placeId = placeId;
        this.userId = userId;
    }

    public Comment(Long id, String textOfComment, Long placeId, Long userId) {
        this.id = id;
        this.textOfComment = textOfComment;
        this.placeId = placeId;
        this.userId = userId;
    }

    public Comment(Long id,  LocalDateTime dateOfComment, Long placeId, Long userId) {
        this.id = id;
        this.dateOfComment = dateOfComment;
        this.placeId = placeId;
        this.userId = userId;
    }
}
