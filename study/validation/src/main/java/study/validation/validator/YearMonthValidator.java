package study.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import study.validation.annotation.YearMonth;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class YearMonthValidator implements ConstraintValidator<YearMonth, String> {
    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        // Year-Month만 입력에 대한 처리
        String revalue = value + "01";
        String rePattern =  pattern + "dd";


        try {
            LocalDate date = LocalDate.parse(revalue, DateTimeFormatter.ofPattern(rePattern));
            System.out.println(date);

            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
