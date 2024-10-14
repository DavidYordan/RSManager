package com.rsmanager.repository.local;

import com.rsmanager.model.SysUser;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalSysUserRepository extends JpaRepository<SysUser, Long> {

    // 查询本地数据库中最新的 createTime
    @Query("SELECT MAX(s.createTime) FROM SysUser s")
    LocalDateTime findMaxCreateTime();
}
