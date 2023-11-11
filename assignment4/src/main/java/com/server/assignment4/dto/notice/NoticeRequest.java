package com.server.assignment4.dto.notice;

import com.server.assignment4.entity.PartLeader;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoticeRequest {
    private String title;
    private String content;
}
