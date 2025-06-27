package study.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import study.validation.validator.PhoneNumberValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = PhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneNumber {
    String message() default "핸드폰 번호 양식에 맞지 않습니다";
    String regex() default "^\\d{2,3}-\\d{3,4}-\\d{4}$";

    //기본적으로 필요적으로 들어가야 하는 것
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
