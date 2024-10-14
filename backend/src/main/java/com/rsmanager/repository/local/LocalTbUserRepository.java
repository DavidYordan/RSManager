package com.rsmanager.repository.local;

import com.rsmanager.model.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalTbUserRepository extends JpaRepository<TbUser, Long> {

    // 查询本地数据库中最新的 updateTime
    @Query("SELECT MAX(u.updateTime) FROM TbUser u")
    String findMaxUpdateTime();
}
