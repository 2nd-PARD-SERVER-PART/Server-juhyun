package pard.thirdSeminar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pard.thirdSeminar.entity.UserEntity;

//Integer는 primary key의 value값
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existByUserEmail(String userEmail);
    boolean existByUserEmailAndUserPassword(String userEmail, String userPassword);
}
