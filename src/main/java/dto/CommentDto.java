package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {

    private String textOfComment;
    private LocalDateTime dateOfComment;
    private Long userId;
    private Long placeId;
}
