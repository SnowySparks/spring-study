package study.filter_interface.intercepter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class OpenApiInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("preHandle");
        var handlerMethod = (HandlerMethod)handler;

        var methodLevel = handlerMethod.getMethod().getAnnotation(OpenApi.class);
        if (methodLevel != null) {
            log.info("methodLevel");
            return true;
        }

        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class);
        if (classLevel != null) {
            log.info("classLevel");
            return true;
        }
        log.error("not open api : {}", request.getRequestURI());
        return false;

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");

        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");

        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
