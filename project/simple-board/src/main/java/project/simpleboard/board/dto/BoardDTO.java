package project.simpleboard.board.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import project.simpleboard.post.db.PostEntity;
import project.simpleboard.post.dto.PostDTO;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDTO {

    private long id;

    private String boardName;

    private String status;

    private List<PostDTO> postList;
}
