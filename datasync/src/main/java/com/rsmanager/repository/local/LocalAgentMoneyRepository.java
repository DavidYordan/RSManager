package com.rsmanager.repository.local;

import com.rsmanager.model.AgentMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface LocalAgentMoneyRepository extends JpaRepository<AgentMoney, Long> {

    /**
     * 查询本地数据库中最新的 createTime
     *
     * @return 最新的 createTime
     */
    @Query("SELECT MAX(a.createTime) FROM AgentMoney a")
    LocalDateTime findMaxCreateTime();
}
