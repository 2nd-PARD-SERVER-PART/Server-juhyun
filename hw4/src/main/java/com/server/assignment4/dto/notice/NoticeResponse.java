package com.server.assignment4.dto.notice;

import com.server.assignment4.entity.PartLeader;
import lombok.Builder;
import lombok.Data;

import java.sql.Timestamp;

@Data
@Builder
public class NoticeResponse {
    String title;
    String content;
    Timestamp uploadTime;
}
