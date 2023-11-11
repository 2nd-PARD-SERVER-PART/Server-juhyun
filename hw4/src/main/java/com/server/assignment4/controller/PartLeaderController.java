package com.server.assignment4.controller;

import com.server.assignment4.dto.notice.NoticeRequest;
import com.server.assignment4.dto.partLeader.PartLeaderRequest;
import com.server.assignment4.dto.partLeader.PartLeaderResponse;
import com.server.assignment4.entity.Notice;
import com.server.assignment4.entity.PartLeader;
import com.server.assignment4.service.NoticeService;
import com.server.assignment4.service.PartLeaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PartLeaderController {
    private final PartLeaderService partLeaderService;

    @PostMapping("/createLeader")
    public ResponseEntity<PartLeader> createLeader(@RequestBody PartLeaderRequest partLeaderRequest){
        PartLeader createPartLeader = partLeaderService.createLeader(partLeaderRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createPartLeader);
    }
}
