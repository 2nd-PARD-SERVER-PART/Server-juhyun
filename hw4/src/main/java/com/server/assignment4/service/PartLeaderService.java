package com.server.assignment4.service;

import com.server.assignment4.dto.notice.NoticeRequest;
import com.server.assignment4.dto.notice.NoticeResponse;
import com.server.assignment4.dto.partLeader.PartLeaderRequest;
import com.server.assignment4.dto.partLeader.PartLeaderResponse;
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
public class PartLeaderService {
    private  final NoticeRepository noticeRepository;
    private final LeaderRepository leaderRepository;

    public PartLeader createLeader(PartLeaderRequest partLeaderRequest){
        PartLeader partLeader = PartLeader.builder()
                .name(partLeaderRequest.getName())
                .age(partLeaderRequest.getAge())
                .build();
        leaderRepository.save(partLeader);

        return partLeader;
    }
}
