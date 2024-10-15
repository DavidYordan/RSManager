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

    // ... 其他字段 ...

    @ManyToOne
    @JoinColumn(name = "role_id")
    private BackendRole backendrole;

    // ... 其他字段 ...
}
