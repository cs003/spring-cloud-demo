package com.example.demo.controller;

import com.example.demo.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by jiaozhiguang on 2017/7/21.
 */

@FeignClient("eureka-client")
public interface DcClient {

    @GetMapping("/dc")
    String consumer();

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User get(@RequestParam("id") Long id, @RequestParam("username") String username);

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public User getbymap(@RequestParam Map<String, Object> map);

    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public User post(@RequestBody User user);

}
