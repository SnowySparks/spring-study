package project.simpleboard.reply.dto;


import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CreateReplyDTO {

    @Min(1)
    private Long postId;

    @NotBlank
    private String userName;

    @NotBlank
    @Size(min = 4, max = 4)
    private String password;


    @NotBlank
    private String title;

    @NotBlank
    private String content;
}
