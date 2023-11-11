package com.server.assignment4.dto.partLeader;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartLeaderResponse {
    String name;
    int age;
}
