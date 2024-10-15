package com.rsmanager.repository.local;

import com.rsmanager.model.BackendUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendUserRepository extends JpaRepository<BackendUser, Long> {
    BackendUser findByUsername(String username);
}
