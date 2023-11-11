package com.server.assignment4.dto.partLeader;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.server.assignment4.entity.Notice;
import com.server.assignment4.entity.PartLeader;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PartLeaderRequest {
    private String name;
    private Integer age;
}
