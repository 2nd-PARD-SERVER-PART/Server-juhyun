package three.seminar.basic.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//위 3개 추가해줘서 생성자들 getter, setter를 선언하지 않고 사용할 수 있다
public class HelloDto {
    private String userName;
    private Integer age;

}
