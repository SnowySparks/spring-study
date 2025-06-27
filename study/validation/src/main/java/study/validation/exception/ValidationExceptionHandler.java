package study.validation.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import study.validation.model.Api;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Api> validationException(MethodArgumentNotValidException e) {
        log.error(e.getMessage());

        String format = "%s : { %s } 은 %s";
        List<String> errorMessages;
        errorMessages = e.getFieldErrors().stream()
                .map(fieldError -> String.format(format, fieldError.getField(), fieldError.getRejectedValue() , fieldError.getDefaultMessage()))
                .toList();
        // 필드명 : 입력하려는 값 , 에러 이유

        var errors = Api.Error.builder()
                .errorMessage(errorMessages)
                .build();

        var errorResponse = Api.builder()
                .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .error(errors)
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
