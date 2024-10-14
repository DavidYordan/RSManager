package com.rsmanager.repository.remote;

import com.rsmanager.model.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteInviteRepository extends JpaRepository<Invite, Integer> {

    // 查询远程数据库中所有在指定时间之后更新的记录
    List<Invite> findByCreateTimeAfter(String createTime);
}
