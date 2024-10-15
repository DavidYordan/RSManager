package com.rsmanager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "backend_user")
@Getter
@Setter
public class BackendUser {

    @Id
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    // 其他字段

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private BackendRole role;

    // Lombok 的 @Getter 和 @Setter 注解会自动生成 getRole() 方法
}
