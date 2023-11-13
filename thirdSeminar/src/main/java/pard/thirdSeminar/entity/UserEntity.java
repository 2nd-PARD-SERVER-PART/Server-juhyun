package pard.thirdSeminar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pard.thirdSeminar.dto.SignUpDto;

@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userNum;
    @Column(columnDefinition = "TEXT",nullable = false)
    private String userEmail; //대문자 자동적으로 user_email로 바꿔준다
    @Column(length = 20)
//    길이 조절할 수 있게 함
    private String userPassword;

    public UserEntity(SignUpDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
    }
}
