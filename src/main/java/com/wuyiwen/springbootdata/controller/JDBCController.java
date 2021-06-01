package com.wuyiwen.springbootdata.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class JDBCController {

    @Autowired
    JdbcTemplate jdbcTemplate;


    @GetMapping("/user/list")
    public List<Map<String, Object>> userList(){
        String sql = "select * from user";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @GetMapping("/adduser")
    public String addUser(){
        String sql = "insert into user(name,password,address,phone) values('大分',133,'大分三大',12442535)";
        jdbcTemplate.update(sql);
        return "update-OK";
    }

}
