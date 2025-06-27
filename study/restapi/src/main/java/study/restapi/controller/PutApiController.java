package study.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.restapi.model.UserRequest;

@Slf4j
@RestController
@RequestMapping("/api")
public class PutApiController {
    @PutMapping("/put")
    public UserRequest put(
            @RequestBody UserRequest userRequest
            ) {

        log.info("Request : {}", userRequest);
        return userRequest;
    }
}
