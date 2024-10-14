package com.rsmanager.repository.remote;

import com.rsmanager.model.AgentMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RemoteAgentMoneyRepository extends JpaRepository<AgentMoney, Long> {

    // 查询远程数据库中所有在指定时间之后更新的记录
    List<AgentMoney> findByCreateTimeAfter(LocalDateTime createTime);
}
