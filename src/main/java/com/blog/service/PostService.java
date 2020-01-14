package com.blog.service;

import com.blog.dto.LoginDto;
import com.blog.dto.PostDto;
import com.blog.entity.Post;

import java.util.List;

public interface PostService {

    void save(PostDto postDto, String username);
    PostDto getById(Long id);
    List<PostDto> getAll();
    List<PostDto> findByUser(String username);
    List<PostDto> findByCategory(Long id);
    List<PostDto> findByTitle(String text);
    void update(PostDto postDto);
    void deleteById(Long id);
}
