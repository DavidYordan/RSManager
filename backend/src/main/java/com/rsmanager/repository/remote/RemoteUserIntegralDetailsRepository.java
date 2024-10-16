package com.rsmanager.repository.remote;

import com.rsmanager.model.UserIntegralDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 远程数据库的 UserIntegralDetails Repository
 */
@Repository
public interface RemoteUserIntegralDetailsRepository extends JpaRepository<UserIntegralDetails, Integer> {

    /**
     * 查询远程数据库中所有 id 大于指定值的记录
     *
     * @param id 指定的最小 id
     * @return 符合条件的 UserIntegralDetails 列表
     */
    List<UserIntegralDetails> findByIdGreaterThan(Integer id);
}
