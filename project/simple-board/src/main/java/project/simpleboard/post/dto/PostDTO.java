package project.simpleboard.post.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import project.simpleboard.board.db.BoardEntity;
import project.simpleboard.post.db.PostEntity;
import project.simpleboard.reply.db.ReplyEntity;
import project.simpleboard.reply.dto.ReplyDTO;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDTO {

    private long id;

    private Long boardId;// system상 board_id가 된다

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    private String content;

    private LocalDateTime postedAt;

    private List<ReplyDTO> replyList = List.of();
}
