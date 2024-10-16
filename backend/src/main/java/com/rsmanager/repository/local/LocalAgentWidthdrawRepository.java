package com.rsmanager.repository.local;

import com.rsmanager.model.AgentWidthdraw;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 本地数据库的 AgentWidthdraw Repository
 */
@Repository
public interface LocalAgentWidthdrawRepository extends JpaRepository<AgentWidthdraw, Long> {

    // 查询本地数据库中最新的 updateTime
    @Query("SELECT MAX(a.updateTime) FROM AgentWidthdraw a")
    LocalDateTime findMaxUpdateTime();
}
