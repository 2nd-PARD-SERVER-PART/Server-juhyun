package com.pard.hw3.repository;

import com.pard.hw3.dto.ResponseDto;
import com.pard.hw3.entity.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;



public interface ItemRepository extends JpaRepository<ItemEntity,Integer> {
//  이름 중복 확인
    Optional<ItemEntity> findByItemName(String ItemName );

    //  최신 등록순으로 보여주기
    List<ItemEntity> findAllByOrderByItemTimeDesc();
// 일정 가격 아래 상품들 리턴
    List<ItemEntity> findAllByItemPriceBefore(Integer price);
// 헤딩 키워드 관련된거 보여주기
    List<ItemEntity> findAllByItemNameContainingIgnoreCase(String Keyword);
}
