package com.rsmanager.repository.local;

import com.rsmanager.model.BackendRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BackendRoleRepository extends JpaRepository<BackendRole, Integer> {
}
