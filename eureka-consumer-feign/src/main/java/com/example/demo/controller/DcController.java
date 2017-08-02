package com.example.demo.controller;

import com.example.demo.domain.User;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * Created by jiaozhiguang on 2017/7/17.
 */
@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
        return dcClient.consumer();
    }

    @GetMapping("/consumeruser")
    public User getuser(Long id, String username) {

        return dcClient.get(id, username);
    }

    @GetMapping("/consumerbymap")
    public User getbymap() {
        HashMap<String, Object> map = Maps.newHashMap();
        map.put("id", "1");
        map.put("username", "张三");
        return dcClient.getbymap(map);
    }

    @PostMapping("/consumerpost")
    public User post() {
        User user = new User(2L, "666666");
        return dcClient.post(user);
    }

}
