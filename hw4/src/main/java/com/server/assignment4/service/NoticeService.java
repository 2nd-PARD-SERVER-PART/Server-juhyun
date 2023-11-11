package com.server.assignment4.service;

import com.server.assignment4.dto.notice.NoticeRequest;
import com.server.assignment4.dto.notice.NoticeResponse;
import com.server.assignment4.entity.Notice;
import com.server.assignment4.entity.PartLeader;
import com.server.assignment4.repository.LeaderRepository;
import com.server.assignment4.repository.NoticeRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public List<NoticeResponse> findAll(){
        List<NoticeResponse> notices = getNoticeRepository().findAll()
                .stream().map(notice -> NoticeResponse.builder()
                        .title(notice.getTitle())
                        .content(notice.getContents())
                        .uploadTime(notice.getUploadTime())
                        .build()).toList();
        return notices;
    }

    public Notice updateNotice(Long noticeId, NoticeRequest noticeRequest){
        Optional<Notice> notice = noticeRepository.findById(noticeId);

        notice.get().setTitle(noticeRequest.getTitle());
        notice.get().setContents(noticeRequest.getContent());

        Notice updateNotice = notice.get();

        return updateNotice;
    }

    public ResponseEntity<?> deleteNotice(Long noticeId){
        noticeRepository.deleteNoticeById(noticeId);
        return null;
    }
}
