package dto;

import dao.impl.*;
import entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.PlaceService;
import service.impl.PlaceServiceImpl;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private Role userRole;

     public static void main(String[] args) {
        // User user=new  User("name4","last4","username4","email5","password6");
         UserDaoImpl userDao=new UserDaoImpl();
//         System.out.println(userDao.insert(user));
        // System.out.println(userDao.deleteById(3L));
         //System.out.println(userDao.updateByEntity(user));
         //System.out.println(userDao.deleteById(5L));
        // System.out.println(userDao.updateByField("333@ukr.net","username3"));




         System.out.println();

         CommentDaoImpl commentDao=new CommentDaoImpl();
       // Comment comment=Comment.builder().textOfComment("yesyes").placeId(2L).userId(1L).build();
       // Comment comment=new Comment(4L,"yesyes",2L,1L);
        // System.out.println(commentDao.insert(comment));
        // System.out.println(commentDao.getByField("2020-01-03 19:29:36"));
        // System.out.println(commentDao.updateByEntity(comment));
//         System.out.println();
    //     System.out.println(commentDao.deleteById(3L));
        // System.out.println(commentDao.updateByField("bebebe",String.valueOf(2L)));

         PlaceDaoImpl placeDao=new PlaceDaoImpl();
         PlaceService placeService=new PlaceServiceImpl();
         //Place place=Place.builder().id(4L).country("Poland").town("Warsaw").name("name").description("desc").photo("photo").build();
       //  System.out.println(placeDao.insert(place));
        // System.out.println(placeDao.getByField("Italia"));
         //System.out.println(placeDao.updateByEntity(place));
        // System.out.println(placeDao.deleteById(3L));
        // System.out.println(placeDao.updateByField("decsrip",String.valueOf(1L)));
         //System.out.println(placeService.getByTemplate("ff"));

         TripDaoImpl tripDao=new TripDaoImpl();
//         Trip trip=Trip.builder().id(5L).departureDay(LocalDate.of(2020,7,1))
//                .dayOfArrival(LocalDate.of(2020,7,30))
//                .access(true).countOfPeople(1).transportId(2L).userId(1L).build();
         //System.out.println(tripDao.insert(trip));
        // System.out.println(tripDao.getByField("2020-07-01"));
        // System.out.println(tripDao.updateByEntity(trip));
        // System.out.println(tripDao.deleteById(2L));
        // System.out.println(tripDao.deleteByFieldName("2020-12-23"));
       //  System.out.println(tripDao.updateByField("2020-12-29",String.valueOf(4L)));


         TransportDaoImpl transportDao=new TransportDaoImpl();
       // Transport transport= Transport.builder().id(5L).transportName(TransportName.valueOf("SHIP")).build();
         //System.out.println(transportDao.insert(transport));
        // System.out.println(transportDao.updateByEntity(transport));
        // System.out.println(transportDao.deleteById(4L));

         RateDaoImpl rateDao=new RateDaoImpl();
        //Rate rate=Rate.builder().id(4L).value(7).userId(2L).placeId(1L).build();
         //System.out.println(rateDao.insert(rate));
        // System.out.println(rateDao.updateByEntity(rate));
         //System.out.println(rateDao.deleteById(2L));
         System.out.println(rateDao.getByFieldName(7L));

//
    }
}
