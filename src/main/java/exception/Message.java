package exception;

public interface Message {

    String USER_NOT_FOUND_EXCEPTION_MESSAGE = "User with id '%s' not found";

    String USERNAME_EXIST_EXCEPTION_MESSAGE = "User with username '%s' is already exist";

    String USERNAME_NOT_FOUND_EXCEPTION_MESSAGE = "User with username '%s' not found";

    String TRANSPORT_NOT_FOUND_EXCEPTION_MESSAGE = "Transport with id '%s' not found";

    String TRIP_NOT_FOUND_EXCEPTION_MESSAGE = "Trip with id '%s' not found";

    String TRIP_PLACE_NOT_FOUND_EXCEPTION_MESSAGE = "Trip with id '%s' and place with id '%d' not found";

    String TRIP_NOT_FOUND_PLACES_EXCEPTION_MESSAGE = "Trip with id '%s' does't have any places";

    String TRIP_DATE_NOT_FOUND_EXCEPTION_MESSAGE = "Trip with departure day '%s' not found";

    String COMMENT_NOT_FOUND_EXCEPTION_MESSAGE = "Comment with id '%s' not found";

    String EMPTY_LIST_BY_FIELD_EXCEPTION_MESSAGE = "Empty user list by field '%s'";

    String EMPTY_USER_LIST_EXCEPTION_MESSAGE = "Empty user list";

    String EMPTY_TRIP_LIST_EXCEPTION_MESSAGE = "Empty trip list";

    String EMPTY_TRIP_PLACE_LIST_EXCEPTION_MESSAGE = "Empty tripPlace list";

    String EMPTY_TRANSPORT_LIST_EXCEPTION_MESSAGE = "Empty transport list";

    String EMPTY_RATE_LIST_EXCEPTION_MESSAGE = "Empty rate list";

    String EMPTY_PLACE_LIST_EXCEPTION_MESSAGE = "Empty place list";

    String EMPTY_COMMENT_LIST_EXCEPTION_MESSAGE = "Empty comment list";

    String CREATE_USER_EXCEPTION_MESSAGE = "User not saved in table";

    String CREATE_TRIP_EXCEPTION_MESSAGE = "Trip not saved in table";

    String CREATE_TRIP_PLACE_EXCEPTION_MESSAGE = "Place didn't add to trip";

    String CREATE_TRANSPORT_EXCEPTION_MESSAGE = "Transport not saved in table";

    String CREATE_RATE_EXCEPTION_MESSAGE = "Rate not saved in table";

    String CREATE_PLACE_EXCEPTION_MESSAGE = "Place not saved in table";

    String CREATE_COMMENT_EXCEPTION_MESSAGE = "Comment not saved in table";

    String UPDATE_USER_EXCEPTION_MESSAGE = "User didn't update in table";

    String UPDATE_TRIP_EXCEPTION_MESSAGE = "Trip didn't update in table";

    String UPDATE_TRIP_PLACE_EXCEPTION_MESSAGE = "TripPlace didn't update in table";

    String UPDATE_TRANSPORT_EXCEPTION_MESSAGE = "Transport didn't update in table";

    String UPDATE_RATE_EXCEPTION_MESSAGE = "Rate didn't update in table";

    String UPDATE_PLACE_EXCEPTION_MESSAGE = "Place didn't update in table";

    String UPDATE_COMMENT_EXCEPTION_MESSAGE = "Comment didn't update in table";

    String DELETE_USER_EXCEPTION_MESSAGE = "User didn't delete from the table";

    String DELETE_TRIP_EXCEPTION_MESSAGE = "Trip didn't delete from the table";

    String DELETE_TRIP_PLACE_EXCEPTION_MESSAGE = "Place didn't delete from the trip";

    String DELETE_TRANSPORT_EXCEPTION_MESSAGE = "Transport didn't delete from the table";

    String DELETE_RATE_EXCEPTION_MESSAGE = "Rate didn't delete from the table";

    String DELETE_PLACE_EXCEPTION_MESSAGE = "Place didn't delete from the table";

    String DELETE_COMMENT_EXCEPTION_MESSAGE = "Comment didn't delete from the table";

    String PLACE_NOT_FOUND_EXCEPTION_MESSAGE = "Place with id '%s' not found";

    String PLACENAME_NOT_FOUND_EXCEPTION_MESSAGE = "Place with name '%s' not found";

}
