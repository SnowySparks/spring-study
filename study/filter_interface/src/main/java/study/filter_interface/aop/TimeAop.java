package study.filter_interface.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import study.filter_interface.model.UserRequestDTO;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Aspect
@Component
public class TimeAop {

    @Pointcut(value = "within(study.filter_interface.controller.UserApiController)")
    public void timePointCut() {}
    

    @Around(value = "timePointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("실제 메서드 실행하기 전");

        Arrays.stream(joinPoint.getArgs()).forEach(arg -> {
            if (arg instanceof UserRequestDTO) {
                var tempUser =  (UserRequestDTO) arg;
                var phoneNumber = tempUser.getPhoneNumber().replace("-", "");
                tempUser.setPhoneNumber(phoneNumber);
            }
        });

        var newObject = Arrays.asList(
                UserRequestDTO.builder().name("changed!").build()
        );

        var result = joinPoint.proceed(newObject.toArray()); //여기서 예외 발생가능성 -> throws Throwable

        System.out.println("실제 메서드 실행하고 난 후");

        return result;
    }

}
