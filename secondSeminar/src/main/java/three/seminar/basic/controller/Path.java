package three.seminar.basic.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import three.seminar.basic.dto.HelloDto;

@Slf4j
@RestController
public class Path {
    @GetMapping("mapping/{userId}")
    public String mappingPath(@PathVariable String userId){
//        여러개 적어도 인식한다
        log.info("mapping userId = {}",userId);
        return "userId = " + userId;
    }
//    required는 없어도 된다~ 라고 말해주는 것 default값은 true
//    하지만 int를 적으면 안되는데 이유가 int는 null값 허용 안해준다 -> Integer이용해야 함
//    requestParam -> ?를 사용해서 key value값 mapping해준다
    @GetMapping("mapping/{userId}/age/{age}")
    public String mappingPath(@PathVariable String userId, @PathVariable(required = false) int age){
        return "userId = " + userId + " age = "+ age;
    }
//    url에 ?뒤에 오는 것들 = requestParam
    @GetMapping("requestParam/users")
    public String mappingPath(@RequestParam(defaultValue = "주현") String name, @RequestParam(required = false) Integer age){
        return "name = " + name + " age = " + age;
    }
//    requestBody는 json으로 받는다느 것
    @PostMapping("requestBody") //default 200
    public String requestBody(@RequestBody HelloDto helloDto){
        log.info("RequestBody name = {}, age = {}", helloDto.getUserName(), helloDto.getAge());
        return "name = "+ helloDto.getUserName() + "age = " + helloDto.getAge();
    }
}
