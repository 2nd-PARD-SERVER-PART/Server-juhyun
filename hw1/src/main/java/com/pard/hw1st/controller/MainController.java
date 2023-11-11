package com.pard.hw1st.controller;


import com.pard.hw1st.dto.MyInfoDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

// TODO: MainController를 만들어주세요.
@Controller
public class MainController {

//    local:8080으로 들어갔을 떄
    @GetMapping("/")
    public String startPage() {
        return "start";
    }

//  url에 /submitInfo추가했을 때 아래 메소드 수행
    @GetMapping("/submitInfo")
    public String showForm() {

        return "submitInfo";
    }

    @PostMapping("/showInfo")
    public String newInfoForm(Model model, MyInfoDto myInfoDto) {
        model.addAttribute("major", myInfoDto.getMajor());
        model.addAttribute("grade", myInfoDto.getGrade());
        model.addAttribute("age", myInfoDto.getAge());
        model.addAttribute("hobby", myInfoDto.getHobby());
        model.addAttribute("name", myInfoDto.getName());
        model.addAttribute("hometown", myInfoDto.getHometown());
        model.addAttribute("introduction", myInfoDto.getIntroduction());
        return "showInfo";
    }

}
