package com.rsmanager.controller;

import com.rsmanager.model.AgentMoney;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/agentmoney")  // 为所有用户相关接口设定基路径
public class UserController {

    private List<AgentMoney> users = new ArrayList<>();

    // 获取所有用户信息 (GET请求)
    @GetMapping
    public List<AgentMoney> getAllUsers() {
        return users;
    }

    // 获取特定用户信息 (GET请求)
    @GetMapping("/{id}")
    public AgentMoney getUserById(@PathVariable("id") Long id) {
        return users.stream()
            .filter(user -> user.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    // 创建新用户 (POST请求)
    @PostMapping
    public AgentMoney createUser(@RequestBody AgentMoney user) {
        users.add(user);
        return user;
    }

    // 更新用户信息 (PUT请求)
    @PutMapping("/{id}")
    public AgentMoney updateUser(@PathVariable("id") Long id, @RequestBody AgentMoney updatedUser) {
        for (AgentMoney user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    // 删除用户 (DELETE请求)
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        users.removeIf(user -> user.getId().equals(id));
    }
}
