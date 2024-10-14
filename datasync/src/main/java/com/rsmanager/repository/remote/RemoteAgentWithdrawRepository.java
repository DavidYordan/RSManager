package com.rsmanager.repository.remote;

import com.rsmanager.model.AgentWithdraw;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RemoteAgentWithdrawRepository extends JpaRepository<AgentWithdraw, Long> {

    // 查询远程数据库中所有在指定时间之后更新的记录
    List<AgentWithdraw> findByUpdateTimeAfter(LocalDateTime updateTime);
}
