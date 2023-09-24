package three.seminar.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//rest controller를 사용하면 responsebody를 사용하지 않아도 web에 문자열을 보여줄 수 있다
//없다면 view로 보내서 해석한다음에 보여줘야 하는데, restController를 사용해서 그럴 필요 없다
public class LogTestController {
    @RequestMapping("/log-test")

    public String logtest(){
        String name = "Juhyun";
        System.out.println("name : "+ name);
        log.info("info log = {}" , name);
        log.trace("info log = {}" , name);
        log.debug("info log = {}" , name);
        log.warn("info log = {}" , name);
        log.error("info log = {}" , name);
        log.info("info log = {}" , name);
//        +도 메모리를 잡아 먹어서 log info를 할 때 ,를 사용해서 메모리 사용을 최소화 한다
        return name;
    }
}
