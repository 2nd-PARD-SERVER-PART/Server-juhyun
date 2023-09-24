package three.seminar.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class HelloWorld {
//    두개의 url 사용하고 싶으면 {}로 덮어줘야 한다. 어디서 들어오든 아래 있는거를 return한다
    @RequestMapping({"/hello-world", "hello"})
    public String helloWorld(){
        log.info("hello-world");
        return "hello world";
    }
}
