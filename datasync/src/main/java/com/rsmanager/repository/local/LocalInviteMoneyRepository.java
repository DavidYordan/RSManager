package com.rsmanager.repository.local;

import com.rsmanager.model.InviteMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalInviteMoneyRepository extends JpaRepository<InviteMoney, Long> {
    // 标准的 CRUD 操作由 JpaRepository 提供
}
