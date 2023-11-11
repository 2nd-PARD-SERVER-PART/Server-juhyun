package com.server.assignment4.repository;

import com.server.assignment4.entity.Notice;
import com.server.assignment4.entity.PartLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    List<Notice> findAllById(Long leaderId);
    void deleteNoticeById(Long noticeId);
}
