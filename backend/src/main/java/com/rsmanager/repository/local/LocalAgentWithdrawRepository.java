package com.rsmanager.repository.local;

import com.rsmanager.model.AgentWithdraw;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalAgentWithdrawRepository extends JpaRepository<AgentWithdraw, Long> {

    // 查询本地数据库中最新的 updateTime
    @Query("SELECT MAX(a.updateTime) FROM AgentWithdraw a")
    LocalDateTime findMaxUpdateTime();
}
