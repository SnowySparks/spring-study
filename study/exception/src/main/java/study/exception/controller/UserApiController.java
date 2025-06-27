package study.exception.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.exception.model.Api;
import study.exception.model.UserResponse;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    //임시 DB역할
    private static List<UserResponse> userList  = List.of(
            UserResponse.builder()
                    .id("1")
                    .age(10)
                    .name("홍길동")
                    .build(),

            UserResponse.builder()
                    .id("2")
                    .age(20)
                    .name("둘리")
                    .build()
    );

    @GetMapping("/id/{userId}")
    public Api<UserResponse> getUser(
            @PathVariable String userId
    ) {
        var user = userList.stream().filter(u -> u.getId().equals(userId)).findFirst().get();

        return Api.<UserResponse>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user)
                .build();
    }
}
