package study.filter_interface.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.web.bind.annotation.*;
import study.filter_interface.intercepter.OpenApi;
import study.filter_interface.model.UserRequestDTO;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    @OpenApi
    public UserRequestDTO register(
            @RequestBody UserRequestDTO userRequestDTO
    ) {
        log.info("controller : {}", userRequestDTO);
        return userRequestDTO;
    }

    @GetMapping("")
    public void hello() {
        log.info("hello");
    }
}
