package com.server.assignment4.service;

import com.server.assignment4.dto.notice.NoticeRequest;
import com.server.assignment4.dto.notice.NoticeResponse;
import com.server.assignment4.entity.Notice;
import com.server.assignment4.entity.PartLeader;
import com.server.assignment4.repository.LeaderRepository;
import com.server.assignment4.repository.NoticeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;
    private final LeaderRepository leaderRepository;

    public Notice createNotice(Long leaderId, NoticeRequest noticeRequest){
        PartLeader partLeader = leaderRepository.findById(leaderId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 리더입니다"));

        Notice notice = Notice.builder()
                .title(noticeRequest.getTitle())
                .contents(noticeRequest.getContent())
                .build();

        notice = noticeRepository.save(notice);
        partLeader.getNotices().add(notice);
        return notice;
    }

    public NoticeResponse findNotice(Long noticeId){
        Optional<Notice> notice = noticeRepository.findById(noticeId);
        Notice foundNotice = notice.get();
        return NoticeResponse.builder()
                .title(foundNotice.getTitle())
                .content(foundNotice.getContents())
                .uploadTime(foundNotice.getUploadTime())
                .build();
    }

    public List<NoticeResponse> findAll(Long leaderId){
        PartLeader partLeader = leaderRepository.findById(leaderId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 리더입니다"));

        List<NoticeResponse> notices = getNoticeRepository().findAll()
                .stream().map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .content(notice.getContents())
                        .uploadTime(notice.getUploadTime())
                        .build()).toList();
        return notices;
    }

    @Transactional
    public Notice updateNotice(Long noticeId, NoticeRequest noticeRequest){
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지입니다"));

        notice.setTitle(noticeRequest.getTitle());
        notice.setContents(noticeRequest.getContent());

        return notice;
    }

    @Transactional
    public void deleteNotice(Long noticeId){
        Notice notice = noticeRepository.findById(noticeId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 공지입니다"));

        noticeRepository.deleteNoticeById(noticeId);
    }
}
