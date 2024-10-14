package com.rsmanager.repository.local;

import com.rsmanager.model.UserMoneyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalUserMoneyDetailsRepository extends JpaRepository<UserMoneyDetails, Integer> {

    // 查询本地数据库中最新的 createTime
    @Query("SELECT MAX(u.createTime) FROM UserMoneyDetails u")
    String findMaxCreateTime();
}
