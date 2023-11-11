package com.server.assignment4.repository;

import com.server.assignment4.entity.PartLeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaderRepository extends JpaRepository<PartLeader,Long> {
}
