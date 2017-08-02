package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * Created by jiaozhiguang on 2017/7/16.
 */
@RestController
public class DcController {

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        //默认超市2000毫秒
        int sleepTime = new Random().nextInt(3000);
        System.out.println("sleepTime = " + sleepTime);
        Thread.sleep(sleepTime);

        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

    @GetMapping("/get")
    public User getUser(Long id, String username) {

//        User user = new User(1L, "aaa");
        User user = new User(id, username);
        return  user;

    }


    @PostMapping("/post")
    public User post(@RequestBody User user) {

        System.out.println(user);
        return user;
    }


}
