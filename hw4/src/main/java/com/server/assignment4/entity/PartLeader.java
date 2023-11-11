package com.server.assignment4.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "part_leader")
public class PartLeader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;
    String name;
    Integer age;
    @OneToMany(mappedBy = "leader",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Notice> notices;
}
