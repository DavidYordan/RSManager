package com.rsmanager.repository.remote;

import com.rsmanager.model.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteTbUserRepository extends JpaRepository<TbUser, Long> {

    // 查询远程数据库中所有在指定时间之后更新的用户
    List<TbUser> findByUpdateTimeAfter(String updateTime);
}
