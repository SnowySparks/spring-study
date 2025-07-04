package study.validation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import study.validation.annotation.PhoneNumber;
import study.validation.annotation.YearMonth;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    private String name;
    private String nickName;

    @NotBlank
    @Size(min = 2, max = 20)
    private String password;

    @NotNull
    @Min(1)
    @Max(130)
    private Integer age;

    @YearMonth
    private String birthDayYearMonth;

    @Email
    private String email;

//    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호 양식에 맞지 않습니다")
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;


    @AssertTrue(message = "name or Nickname이 존재해야 합니다")
    public boolean isNameCheck() {
        if (Objects.nonNull(name) && !name.isBlank()) return true;
        if (Objects.nonNull(nickName) && !nickName.isBlank()) return true;
        return false;
    }

}
