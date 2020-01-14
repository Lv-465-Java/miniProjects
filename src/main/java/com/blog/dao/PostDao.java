package com.blog.dao;

import com.blog.entity.Post;

import com.blog.entity.SqlQueries;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class PostDao extends ADaoCRUD<Post> {

    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern ( "yyyy-MM-dd HH:mm:ss" );

    public PostDao(){
        super();
        init();
    }

    @Override
    protected String[] getFields(Post entity) {
        String[] fields = new String[7];
        fields[0] = entity.getTitle();
        fields[1] = entity.getContent();
        fields[2] = entity.getImgPath();
        fields[3] = String.valueOf(entity.getCreatedDateTime());
        fields[4] = String.valueOf(entity.getUpdatedDateTime());
        fields[5] = entity.getUserId().toString();
        fields[6] = entity.getCategotyId().toString();
        return fields;
    }

    @Override
    protected String[] getUpdateFields(Post entity) {
        String[] result = new String[6];
        result[0] = entity.getTitle();
        result[1] = entity.getContent();
        result[2] = entity.getImgPath();
        result[3] = String.valueOf(entity.getUpdatedDateTime());
        result[4] = entity.getCategotyId().toString();
        result[5] = entity.getId().toString();
        return result;
    }

    @Override
    protected Post createInstance(String[] args) {
        return new Post(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2],
                args[3] == null ? new String() : args[3],
                args[4] == null ? LocalDateTime.now() : LocalDateTime.parse(args[4], dateTimeFormatter),
                args[5] == null ? LocalDateTime.now() : LocalDateTime.parse(args[5], dateTimeFormatter),
                Long.parseLong(args[6] == null ? "0" : args[6]),
                Long.parseLong(args[7] == null ? "0" : args[7])
        );
    }

    @Override
    protected void init() {
        for (Post.PostEntityQueries postEntityQueries: Post.PostEntityQueries.values()){
            sqlQueries.put(postEntityQueries.getSqlQuery(), postEntityQueries);
        }
    }
}
