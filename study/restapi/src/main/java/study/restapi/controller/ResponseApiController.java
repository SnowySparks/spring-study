package study.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.restapi.model.UserRequest;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class ResponseApiController {
    @GetMapping("")
    public ResponseEntity<UserRequest> user() {
        var user = new UserRequest("유저이름",10,"user@test",true);
//        user.setUserAge(10);
//        user.setUsername("유저이름");
//        user.setEmail("user@gmail.com");
//        user.setIsKorean(true);

        log.info("user - {}", user);

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).header(
                "x-custom", "hi"
        ).body(user);
    }
}
