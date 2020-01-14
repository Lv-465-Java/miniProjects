package service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import dao.DaoCRUD;
import dto.CommentDto;
import entity.Comment;
import mapper.CommentMapper;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import service.CommentService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {

    @Mock
    private DaoCRUD<Comment> daoCRUD;

    //@InjectMocks
    CommentService commentService;

    @BeforeEach
    void init() {
        initMocks(this);
        commentService = new CommentServiceImpl(daoCRUD);
    }

    @Test
    public void getAllCommentsTest() {
        List<CommentDto> testList = new ArrayList<>(Arrays
                .asList(new CommentDto("text1", LocalDateTime.of(2019, 12, 3, 12, 12, 30), 1L, 3L),
                        new CommentDto("text3", LocalDateTime.of(2019, 8, 28, 16, 12, 0), 2L, 2L),
                        new CommentDto("text2", LocalDateTime.of(2019, 8, 4, 13, 10, 30), 3L, 4L),
                        new CommentDto("text4", LocalDateTime.of(2019, 11, 3, 12, 1, 30), 1L, 3L)
                ));


        when(daoCRUD.getAll()).thenReturn(testList.stream().map(CommentMapper::getCommentEntity).collect(Collectors.toList()));
        List<CommentDto> list = commentService.getAll();
        assertEquals(4, list.size());
        verify(daoCRUD, times(1)).getAll();
    }

    @Test
    public void getCommentByIdTest()
    {
        when(daoCRUD.getById(1L)).thenReturn(java.util.Optional.of(new Comment(1L, "text", LocalDateTime.of(2020, 1, 4, 12, 30, 0), 1L, 2L)));

        CommentDto comment=commentService.getById(1L);

        assertEquals("text", comment.getTextOfComment());
        assertEquals(LocalDateTime.of(2020, 1, 4, 12, 30, 0), comment.getDateOfComment());
        //assertEquals(java.util.Optional.of(1L),comment.getPlaceId());
        //assertEquals(java.util.Optional.of(2L),comment.getUserId());
       // assertNull();
    }

    @Test
    public void createCommentTest()
    {
        Comment comment=new Comment( "text", LocalDateTime.of(2020, 1, 4, 12, 30, 0), 1L, 2L);

        commentService.insert(comment);

        verify(daoCRUD, times(1)).insert(comment);
    }
}
