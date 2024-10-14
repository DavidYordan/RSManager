// LocalCashOutRepository.java
package com.rsmanager.repository.local;

import com.rsmanager.model.CashOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalCashOutRepository extends JpaRepository<CashOut, Long> {

    // 查询本地数据库中最新的 createAt
    @Query("SELECT MAX(c.createAt) FROM CashOut c")
    String findMaxCreateAt();
}
