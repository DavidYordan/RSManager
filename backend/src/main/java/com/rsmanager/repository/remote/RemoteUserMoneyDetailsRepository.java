package com.rsmanager.repository.remote;

import com.rsmanager.model.UserMoneyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemoteUserMoneyDetailsRepository extends JpaRepository<UserMoneyDetails, Integer> {

    // 查询远程数据库中所有在指定时间之后更新的记录
    List<UserMoneyDetails> findByCreateTimeAfter(String createTime);
}
