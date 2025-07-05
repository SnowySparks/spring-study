package study.filter_interface.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;

//@Component
@Slf4j
public class LoggerFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        log.info("진입 >>>>>>> ");

        var req = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        var res = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);



        filterChain.doFilter(req, res);


        var reqJson = new String(req.getContentAsByteArray());
        var resJson = new String(res.getContentAsByteArray());


        log.info("req : {}", reqJson);
        log.info("res : {}", resJson);

        log.info("리턴 <<<<<<< ");

        res.copyBodyToResponse();
    }
}
