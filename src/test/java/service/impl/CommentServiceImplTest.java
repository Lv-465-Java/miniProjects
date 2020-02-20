//package service.impl;
//
//import dao.impl.CommentDaoImpl;
//import entity.Comment;
//import exception.NotFoundException;
//import org.junit.Test;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.*;
//import static org.mockito.MockitoAnnotations.initMocks;
//
//@RunWith(MockitoJUnitRunner.class)
//public class CommentServiceImplTest {
//
//    @Mock
//    private CommentDaoImpl commentDao;
//
//    @InjectMocks
//    CommentServiceImpl commentServiceImpl;
//
//    @BeforeEach
//    void init() {
//        initMocks(this);
//        commentDao=new CommentDaoImpl();
//    }
//
//    List<CommentDto> testList = new ArrayList<>(Arrays
//                .asList(new CommentDto(1L,"text1", LocalDateTime.of(2019, 12, 3, 12, 12, 30), 1L, 3L),
//                        new CommentDto(2L,"text3", LocalDateTime.of(2019, 8, 28, 16, 12, 0), 2L, 2L),
//                        new CommentDto(3L,"text2", LocalDateTime.of(2019, 8, 4, 13, 10, 30), 3L, 4L),
//                        new CommentDto(4L,"text4", LocalDateTime.of(2019, 11, 3, 12, 1, 30), 1L, 3L)
//                ));
//    List<Comment> testCommentList=testList.stream().map(CommentMapper::getCommentEntity).collect(Collectors.toList());
//    List<Comment> emptyCommentList=new ArrayList<>();
//
//    Comment testComment=new Comment(1L,"text1", LocalDateTime.of(2019, 12, 3, 12, 12, 30), 1L, 3L);
//
//    CommentDto testCommentDto = CommentMapper.getCommentDto(testComment);
//
//
//    @Test
//    public void getByIdTest() {
//
//        when(commentDao.getById(1L)).thenReturn(Optional.of(testComment));
//
//        CommentDto resultCommentDto = commentServiceImpl.getById(1L);
//
//        assertEquals(testCommentDto, resultCommentDto);
//
//        verify(commentDao, times(1)).getById(anyLong());
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void getByIdExceptionTest() {
//
//        when(commentDao.getById(anyLong())).thenReturn(Optional.empty());
//
//        commentServiceImpl.getById(anyLong());
//    }
//
//    @Test
//    public void getByFieldTest() {
//
//        when(commentDao.getByField("country1")).thenReturn(Optional.of(testComment));
//
//        CommentDto resultCommentDto = commentServiceImpl.getByField("country1");
//
//        assertEquals(testCommentDto, resultCommentDto);
//
//        verify(commentDao, times(1)).getByField(anyString());
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void getByFieldExceptionTest() {
//
//        when(commentDao.getByField(anyString())).thenReturn(Optional.empty());
//
//        commentServiceImpl.getByField(anyString());
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void getAllCommentsExceptionTest() {
//
//        when(commentDao.getAll()).thenReturn(emptyCommentList);
//
//        commentServiceImpl.getAll();
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void getAllLimitExceptionTest() {
//
//        when(commentDao.getAllLimit()).thenReturn(emptyCommentList);
//
//        commentServiceImpl.getAllLimit();
//    }
//
//
//    @Test
//    public void insertTest() {
//
//        when(commentDao.insert(testComment)).thenReturn(true);
//
//        boolean result = commentServiceImpl.insert(testComment);
//
//        assertTrue(result);
//
//        verify(commentDao, times(1)).insert(testComment);
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void insertExceptionTest() {
//
//        when(commentDao.insert(testComment)).thenReturn(false);
//
//        commentServiceImpl.insert(testComment);
//    }
//
//    @Test
//    public void updateByEntityTest() {
//
//        when(commentDao.updateByEntity(testComment)).thenReturn(true);
//
//        boolean result = commentServiceImpl.updateByEntity(testComment);
//
//        assertTrue(result);
//
//        verify(commentDao, times(1)).updateByEntity(testComment);
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void updateByEntityExceptionTest() {
//
//        when(commentDao.updateByEntity(testComment)).thenReturn(false);
//
//        commentServiceImpl.updateByEntity(testComment);
//    }
//
//    @Test
//    public void updateByFieldTest() {
//
//        when(commentDao.updateByField(anyString(), anyString())).thenReturn(true);
//
//        boolean result = commentServiceImpl.updateByField(anyString(), anyString());
//
//        assertTrue(result);
//
//        verify(commentDao, times(1)).updateByField(anyString(), anyString());
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void updateByFieldExceptionTest() {
//
//        when(commentDao.updateByField(anyString(), anyString())).thenReturn(false);
//
//        commentServiceImpl.updateByField(anyString(), anyString());
//    }
//
//    @Test
//    public void deleteByIdTest() {
//
//        when(commentDao.deleteById(anyLong())).thenReturn(true);
//
//        boolean result = commentServiceImpl.deleteById(anyLong());
//
//        assertTrue(result);
//
//        verify(commentDao, times(1)).deleteById(anyLong());
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void deleteByIdExceptionTest() {
//
//        when(commentDao.deleteById(anyLong())).thenReturn(false);
//
//        commentServiceImpl.deleteById(anyLong());
//    }
//
//    @Test
//    public void deleteTest() {
//
//        when(commentDao.delete(testComment)).thenReturn(true);
//
//        boolean result = commentServiceImpl.delete(testComment);
//
//        assertTrue(result);
//
//        verify(commentDao, times(1)).delete(testComment);
//    }
//
//    @Test(expected = NotFoundException.class)
//    public void deleteExceptionTest() {
//
//        when(commentDao.delete(testComment)).thenReturn(false);
//
//        commentServiceImpl.delete(testComment);
//    }
//}
