package pard.thirdSeminar.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pard.thirdSeminar.dto.ResponseDto;
import pard.thirdSeminar.dto.SignInDto;
import pard.thirdSeminar.dto.SignUpDto;
import pard.thirdSeminar.entity.UserEntity;
import pard.thirdSeminar.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
//    자동으로 userRepository 넣어줘서 여기서 사용하는 userRepository는 우리가 만든 userRepository와 같다
    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public ResponseDto signUp(SignUpDto dto){
        UserEntity user = new UserEntity(dto);
        String userEmail = dto.getUserEmail();
        try {
            if (userRepository.existByUserEmail(userEmail)){
                return ResponseDto.setFailed("존재하는 ID입니다");
            }
            userRepository.save(user);
            return ResponseDto.setSuccess("축하해",user);
        } catch(Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }
    public ResponseDto<List<UserEntity>> findAll(){
        List<UserEntity> users;
        try {
            users = userRepository.findAll();
            return ResponseDto.setSuccess("find Success", users);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }
    public ResponseDto<UserEntity> findOne(Integer userNum){
        UserEntity user;
        try{
            user = userRepository.findById(userNum).get();
            return ResponseDto.setSuccess("find One", user);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB 오류");
        }
    }
    @Transactional //원래 save로 해줘야 하는데 이게 자동적으로 user의 변경을 감지하고 넣어줌
    public ResponseDto<UserEntity> updateOne(Integer userNum, SignUpDto dto){
        UserEntity user;
        try {
            user = userRepository.findById(userNum).get();
//            그냥 user.setUserEmail(dto.getUserEmail() 하면 0일때가 나와서 아래와 같이 null이 아닐때 해줘야함
            if (dto.getUserEmail() != null && !dto.getUserEmail().isEmpty()) user.setUserEmail(dto.getUserEmail());
            if (dto.getUserPassword() != null && !dto.getUserPassword().isEmpty())user.setUserPassword(dto.getUserPassword());
            return ResponseDto.setSuccess("update One", user);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }

//    ?는 뭐가 들어올지 모른다는 뜻

    public ResponseDto<?> deleteUser(Integer userNum){
        try {
//            userNum을 넣어서 있는지 확인하고 삭제
            if (userRepository.existsById(userNum)) {
                userRepository.deleteById(userNum);
                return ResponseDto.setSuccess("Board Delete Success!", null);
            } else {
                return ResponseDto.setFailed("존재하지 않는 ID");
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseDto.setFailed("DB오류");
        }
    }

    public ResponseDto<String> signIn(SignInDto dto){
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        boolean existed = userRepository.existByUserEmailAndUserPassword(dto.getUserEmail(), dto.getUserPassword);
        if(!existed) return ResponseDto.setFailed("존재하지 않아요!");
        return ResponseDto.setSuccess("로그인 축하드립니", userEmail);
    }
}
