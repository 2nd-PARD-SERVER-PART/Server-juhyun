package com.server.assignment4.controller;

import com.server.assignment4.dto.notice.NoticeRequest;
import com.server.assignment4.dto.notice.NoticeResponse;
import com.server.assignment4.entity.Notice;
import com.server.assignment4.service.NoticeService;
import com.server.assignment4.service.PartLeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NoticeController {
    private final PartLeaderService partLeaderService;
    private final NoticeService noticeService;

    @PostMapping("/addNotice/{leaderId}")
    public ResponseEntity<Notice> createNotice(@PathVariable Long leaderId, @RequestBody NoticeRequest notice){
        Notice createdNotice = noticeService.createNotice(leaderId,notice);
        return ResponseEntity.ok(createdNotice);
    }

    @GetMapping("/findNotice/{noticeId}")
    public NoticeResponse findNotice(Long noticeId){
        NoticeResponse noticeResponse = noticeService.findNotice(noticeId);
        return noticeResponse;
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Notice>> findAll(){
        List<Notice> notices = partLeaderService.getNoticeRepository().findAll();
        return ResponseEntity.ok(notices);
    }

    @PatchMapping("/updateNotice/{noticeId}")
    public ResponseEntity<Notice> updateNotice(@PathVariable Long noticeId,@RequestBody NoticeRequest noticeRequest){
        Notice notice = noticeService.updateNotice(noticeId, noticeRequest);
        return ResponseEntity.ok(notice);
    }
    @DeleteMapping("/deleteNotice/{noticeId}")
    public void deleteNotice(@PathVariable Long noticeId){
        noticeService.deleteNotice(noticeId);
    }
}
