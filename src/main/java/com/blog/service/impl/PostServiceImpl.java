package com.blog.service.impl;

import com.blog.constant.Message;
import com.blog.constant.Parameter;
import com.blog.dao.CategoryDao;
import com.blog.dao.PostDao;
import com.blog.dto.CategoryDto;
import com.blog.dto.LoginDto;
import com.blog.dto.PostDto;
import com.blog.dto.UserDto;
import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exeption.NotDeleteExeption;
import com.blog.exeption.NotFoundExeption;
import com.blog.exeption.NotSavedExeption;
import com.blog.exeption.NotUpdateExeption;
import com.blog.service.PostService;
import com.blog.service.UserService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostServiceImpl implements PostService {

    private PostDao postDao;
    private UserService userService;
    private CategoryDao categoryDao;

    public PostServiceImpl() {
        this.postDao = new PostDao();
        this.userService = new UserServiceImpl();
        this.categoryDao = new CategoryDao();
    }

    @Override
    public void save(PostDto postDto, String username) {
        UserDto user = userService.findUserByUsername(username);
        Post post = new Post(
                postDto.getTitle(),
                postDto.getContent(),
                postDto.getImgPath(),
                LocalDateTime.now(),
                LocalDateTime.now(),
                user.getId(),
                postDto.getCategoryId()
        );
        try {
            postDao.insert(post);
        }catch (RuntimeException e){
            throw new NotSavedExeption(Message.POST_NOT_SAVED);
        }
    }

    @Override
    public PostDto getById(Long id) {
        try {
            Post post = postDao.getById(id);
            UserDto user = userService.getById(post.getUserId());
            Category category = categoryDao.getById(post.getCategotyId());
            PostDto postDto = new PostDto(
                    post.getId(),
                    post.getTitle(),
                    post.getContent(),
                    post.getImgPath(),
                    post.getCreatedDateTime().toString(),
                    post.getUpdatedDateTime().toString(),
                    post.getUserId(),
                    post.getCategotyId(),
                    user.getUsername(),
                    category.getName()
            );
            return postDto;
        }catch (RuntimeException e){
            throw new NotFoundExeption(Message.POST_NOT_FOUND);
        }

    }

    @Override
    public List<PostDto> getAll() {
        List<PostDto> postDtoList = new ArrayList<>();
        try {
            for (Post post: postDao.getAll()){
                PostDto postDto = new PostDto(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getImgPath(),
                        post.getCreatedDateTime().toString(),
                        post.getUpdatedDateTime().toString(),
                        post.getUserId(),
                        post.getCategotyId()
                );
                postDtoList.add(postDto);
            }
        }catch (RuntimeException e){
            throw new NotFoundExeption(Message.POST_NOT_FOUND);
        }

        return postDtoList;
    }

    @Override
    public List<PostDto> findByUser(String username) {
        UserDto userDto = userService.findUserByUsername(username);
        List<PostDto> postDtoList = new ArrayList<>();
        try {
            for (Post post: postDao.getByFieldName(Parameter.USER_ID, userDto.getId().toString())){
                PostDto postDto = new PostDto(
                        post.getId(),
                        post.getTitle(),
                        post.getContent(),
                        post.getImgPath(),
                        post.getCreatedDateTime().toString(),
                        post.getUpdatedDateTime().toString(),
                        post.getUserId(),
                        post.getCategotyId()
                );
                postDtoList.add(postDto);
            }
        }catch (RuntimeException e){
            throw new NotFoundExeption(Message.POST_NOT_FOUND);
        }
        return postDtoList;
    }

    @Override
    public List<PostDto> findByCategory(Long id) {
        List<PostDto> result =  new ArrayList<>();
        try {
            for (Post post: postDao.getByFieldName(Parameter.CATEGORY_ID, id.toString())){
                PostDto postDto = new PostDto();
                postDto.setId(post.getId());
                postDto.setTitle(post.getTitle());
                postDto.setImgPath(post.getImgPath());

                result.add(postDto);
            }
        } catch (RuntimeException e){
            throw new NotFoundExeption(Message.POST_NOT_FOUND);
        }

        return result;
    }

    @Override
    public List<PostDto> findByTitle(String text) {
        List<PostDto> result =  new ArrayList<>();
            try {
                for (Post post: postDao.getByFieldNameLike(Parameter.TITLE, "%" +text +"%")) {
                    PostDto postDto = new PostDto();
                    postDto.setId(post.getId());
                    postDto.setTitle(post.getTitle());
                    postDto.setImgPath(post.getImgPath());

                    result.add(postDto);
                }
            }catch (RuntimeException e){
                throw new NotFoundExeption(Message.POST_NOT_FOUND);
            }
        return result;
    }

    @Override
    public void update(PostDto postDto) {
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImgPath(postDto.getImgPath());
        post.setUpdatedDateTime(LocalDateTime.now());
        post.setCategotyId(postDto.getCategoryId());
        try {
            postDao.updateByEntity(post);
        }catch (RuntimeException e){
            throw new NotUpdateExeption(Message.POST_NOT_UPDATED);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            postDao.deleteById(id);
        }catch (RuntimeException e){
            throw  new NotDeleteExeption(Message.POST_NOT_DELETED);
        }
    }
}
