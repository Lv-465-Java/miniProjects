package service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import dao.DaoCRUD;
import dao.impl.CommentDaoImpl;
import dto.CommentDto;
import entity.Comment;
import exception.NotFoundException;
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
import java.util.Optional;
import java.util.stream.Collectors;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(MockitoJUnitRunner.class)
public class CommentServiceImplTest {

    @Mock
    private CommentDaoImpl commentDao;

    @InjectMocks
    CommentService commentService=new CommentServiceImpl();

    @BeforeEach
    void init() {
        initMocks(this);
        //commentService = new CommentServiceImpl();
        commentDao=new CommentDaoImpl();
    }

    List<CommentDto> testList = new ArrayList<>(Arrays
                .asList(new CommentDto(1L,"text1", LocalDateTime.of(2019, 12, 3, 12, 12, 30), 1L, 3L),
                        new CommentDto(2L,"text3", LocalDateTime.of(2019, 8, 28, 16, 12, 0), 2L, 2L),
                        new CommentDto(3L,"text2", LocalDateTime.of(2019, 8, 4, 13, 10, 30), 3L, 4L),
                        new CommentDto(4L,"text4", LocalDateTime.of(2019, 11, 3, 12, 1, 30), 1L, 3L)
                ));
    List<Comment> testCommentList=testList.stream().map(CommentMapper::getCommentEntity).collect(Collectors.toList());
    List<Comment> emptyCommentList=new ArrayList<>();

    @Test
    public void getAllCommentsTest() {
//


        List<CommentDto> list = commentService.getAll();
        when(commentDao.getAll()).thenReturn(list.stream().map(CommentMapper::getCommentEntity).collect(Collectors.toList()));

        assertEquals(commentDao.getAll().size(), list.size());
        verify(commentDao, times(1)).getAll();
    }

    @Test
    public void getCommentByIdTest()
    {
        when(commentDao.getById(1L)).thenReturn(Optional.of(new Comment(2L, "cool", LocalDateTime.of(2020, 1, 3, 19, 29, 58), 1L, 3L)));

        CommentDto comment=commentService.getById(2L);

        assertEquals("cool", comment.getTextOfComment());
        assertEquals(LocalDateTime.of(2020, 1, 3, 19, 29, 58), comment.getDateOfComment());
       // assertEquals(1,comment.getPlaceId());
        //assertEquals(java.util.Optional.of(2L),comment.getUserId());
       // assertNull();
    }

    @Test
    public void getCommentByFieldTest(){
        when(commentDao.getByField(String.valueOf(LocalDateTime.of(2020, 1, 3, 19, 29, 58))))
                .thenReturn(Optional.of(new Comment(2L, "cool", LocalDateTime.of(2020, 1, 3, 19, 29, 58), 1L, 3L)));
        CommentDto commentDto=commentService.getByField(String.valueOf(LocalDateTime.of(2020, 1, 3, 19, 29, 58)));
        assertEquals("cool",commentDto.getTextOfComment());
        assertEquals(LocalDateTime.of(2020, 1, 3, 19, 29, 58), commentDto.getDateOfComment());

    }

    @Test
    public void createCommentTest()
    {
        Comment comment= new Comment("text", 1L,2L);

        commentService.insert(comment);

        verify(commentDao, times(1)).insert(comment);
    }

    @Test
    public void updateCommentTest(){
        Comment comment=new Comment();
        comment.setId(1L);
        comment.setTextOfComment("texttext");
        comment.setPlaceId(2L);
        comment.setUserId(1L);
        commentDao.updateByEntity(comment);
        when(commentDao.getById(1L)).thenReturn(Optional.of(comment));
      //  doThrow(new NotFoundException("test exception")).when(commentService).updateByEntity(comment);

        verify(commentDao).updateByEntity(comment);
        assertEquals("texttext",commentService.getById(1L).getTextOfComment());
        //assertEquals(Optional.of(2L),commentService.getById(1L).getPlaceId());
    }

    @Test
    public void updateCommentExceptionTest(){
        Comment comment=new Comment();
        comment.setId(1L);
        comment.setTextOfComment("texttext");
        comment.setPlaceId(2L);
        comment.setUserId(1L);
        //commentDao.updateByEntity(comment);

          doThrow(new NotFoundException("test exception")).when(commentDao).updateByEntity(comment);

    }
}
