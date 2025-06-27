package study.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/b")
public class RestApiBController {

    @GetMapping("/hello")
    public String hello() {
        throw new NumberFormatException("NumberFormatException");
    }

//
//    @ExceptionHandler(value = {NumberFormatException.class})
//    public ResponseEntity numberFormatExceptionHandler(NumberFormatException e) {
//        log.error("RestApiBController : ", e);
//        return ResponseEntity.status(204).build();
//    }
}
