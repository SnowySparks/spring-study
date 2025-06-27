package study.restapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import study.restapi.model.BookQueryParam;

@RestController
@Slf4j
@RequestMapping("/api")
public class RestApiController {

    @GetMapping("/hello")
    public String hello() {
        return "<html><body><h1>Hello</h1></body></html>";
    }

    @GetMapping(path = "/echo/{message}/age/{age}/is-man/{isMan}")
    public String echo(@PathVariable("message") String message,
    @PathVariable("age") int age,
    @PathVariable("isMan") boolean isMan
    ) {
        System.out.println("echo message :" + message);
        System.out.println("age :" + age);
        System.out.println("isMan :" + isMan);
        return message;
    }

    @GetMapping("/book")
    public String queryParam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam String issued_day

    ) {
        System.out.println("issued_day : " + issued_day);
        System.out.println("query param issued-month : " + issuedMonth);
        System.out.println("query param issued-year : " + issuedYear);
        System.out.println("category : " + category);

        return category + " " + issuedYear + " " + issuedMonth + " " + issued_day;
    }

    @GetMapping("/book2")
    public String queryParam2(
        BookQueryParam bookQueryParam

    ) {
        System.out.println("query param issued-month : " + bookQueryParam);
        return bookQueryParam.getIssuedMonth();
    }

    @DeleteMapping(path = {"user/{userName}/delete",
            "user/{userName}/del"}
    )
    public void delete(
            @PathVariable String userName
    ) {
        log.info("del userName - {}", userName);
    }
}


