package three.seminar.deeping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import three.seminar.deeping.repository.UserRepository;
import three.seminar.deeping.user.User;

import java.util.List;

@RestController
@RequestMapping("/user")
public class Controller {
    private final UserRepository userRepository;
    @Autowired
    //위에 선언한거 스프링이 읽을 수 있게 불러오는것
    public Controller(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @PostMapping("/add")
    public String userAdd(@RequestParam Integer stuNum, @RequestParam String stuName){
        User user = new User();
        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "version 1";
    }
    @PostMapping("/add/{stuNum}/{stuName}")
    public String userAdd2(@PathVariable Integer stuNum, @PathVariable String stuName){
        User user = new User();
        user.setStuNum(stuNum);
        user.setStuName(stuName);
        userRepository.save(user);
        return "버전 2";
    }
    @PostMapping("/add3")
    public String UserAdd(@RequestBody User user){
        userRepository.save(user);
        return "버전3";
    }
    @GetMapping("/findAll")
    public List<User> userFind(){
        List<User> hguStudent = userRepository.findAll();
        return hguStudent;
    }
    @GetMapping("/findOne/{stuNum}")
    public User userFindOne(@PathVariable Integer stuNum){
        User user = userRepository.findById(stuNum);
        return user;
    }
    @PatchMapping("/update/{stuNum}")
    public String userUpdate(@PathVariable Integer stuNum, @RequestBody User user){
        userRepository.update(stuNum, user);
        return "교체완료";
    }
    @DeleteMapping("/delete/{stuNum}")
    public String UserDelete(@PathVariable Integer stuNum){
        userRepository.delete(stuNum);
        return "삭제완료";
    }

}
