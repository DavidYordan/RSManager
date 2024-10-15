package com.rsmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "backend_role")
@Getter
@Setter
public class BackendRole {

    @Id
    @Column(name = "id")
    private Integer id; // 角色 ID，1 到 6

    @Column(name = "name")
    private String name; // 角色名称
}
