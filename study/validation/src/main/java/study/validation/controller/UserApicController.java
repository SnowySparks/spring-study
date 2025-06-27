package study.validation.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.validation.model.Api;
import study.validation.model.UserRegisterRequest;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApicController {
    @PostMapping("")
    public Api<UserRegisterRequest> register(
            @Valid @RequestBody Api<UserRegisterRequest> userRegisterRequest
    ) {
        log.info("init : {}", userRegisterRequest);

        var body = userRegisterRequest.getData();
        Api<UserRegisterRequest> response = Api.<UserRegisterRequest>builder()
                .data(body)
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .build();

        return response;
    }
}
