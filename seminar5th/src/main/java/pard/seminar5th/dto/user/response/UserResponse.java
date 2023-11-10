package pard.seminar5th.dto.user.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import pard.seminar5th.entity.user.User;

@Data
@NoArgsConstructor
public class UserResponse {
    private long id;
    private String name;
    private Integer age;

    public UserResponse(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.age = user.getAge();
    }

//  public UserResponse(long id, User user) {
//    this.id = id;
//    this.name = user.getName();
//    this.age = user.getAge();
//  }
}