package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TripDto {

    private Long id;
    private LocalDate departureDay;
    private LocalDate dayOfArrival;
    private Long transportId;
    private int countOfPeople;
    private Long userId;

}
