package com.leo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangliying on 2017/4/6.
 */
@RestController
public class DbTestController {
    @GetMapping("/test/getAllRecords")
    public String getAllRecords() {
        return "";
    }

    @GetMapping("/test/getRecord/{id}")
    public String getRecord(@PathVariable("id") String id) {
        return "";
    }

}
