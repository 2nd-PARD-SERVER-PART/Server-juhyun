package com.server.assignment4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;
    String contents;

    @CreationTimestamp
    Timestamp uploadTime;
    @ManyToOne(fetch = FetchType.LAZY)
//    PartLeader에 있는 id값을 foreign key로 매핑
    @JoinColumn(name = "leader_id")
    private PartLeader leader;
}
