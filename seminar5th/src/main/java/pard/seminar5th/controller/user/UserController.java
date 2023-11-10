package pard.seminar5th.controller.user;

import org.springframework.web.bind.annotation.*;
import pard.seminar5th.dto.user.request.UserCreateRequest;
import pard.seminar5th.dto.user.request.UserUpdateRequest;
import pard.seminar5th.dto.user.response.UserResponse;
import pard.seminar5th.service.user.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request) {
        userService.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request) {
        userService.updateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name) {
        userService.deleteUser(name);
    }

}