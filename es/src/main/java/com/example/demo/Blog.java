package com.example.demo;

import lombok.Data;

/**
 * Created by jiaozhiguang on 2017/8/12.
 */
@Data
public class Blog {

    private Integer id;
    private String title;
    private String posttime;
    private String content;

    public Blog() {
    }

    public Blog(Integer id, String title, String posttime, String content) {
        this.id = id;
        this.title = title;
        this.posttime = posttime;
        this.content = content;
    }

}
