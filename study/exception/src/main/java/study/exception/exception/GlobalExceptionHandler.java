package study.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.exception.model.Api;

@Slf4j
@RestControllerAdvice
@Order(value =1)
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Api> handleException(Exception e) {
        log.error(" : ", e);
        Api api = Api.builder().resultCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).resultMessage(e.getMessage()).build();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(api);
    }
}
