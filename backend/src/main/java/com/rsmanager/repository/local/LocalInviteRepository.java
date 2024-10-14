package com.rsmanager.repository.local;

import com.rsmanager.model.Invite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalInviteRepository extends JpaRepository<Invite, Integer> {

    // 查询本地数据库中最新的 createTime
    @Query("SELECT MAX(i.createTime) FROM Invite i")
    String findMaxCreateTime();
}
