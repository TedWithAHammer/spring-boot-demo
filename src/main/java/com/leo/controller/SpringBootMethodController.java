package com.leo.controller;

import com.leo.domain.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wangliying on 2017/4/6.
 */
@RestController
public class SpringBootMethodController {

    @Value("compound")
    private String compound;

    @Autowired
    private Wrapper wrapper;

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public String method1() {
        return "basic get method";
    }

    @GetMapping("/2")
    public String method2() {
        return "equivalent get method";
    }

    /**
     * @param param
     * @return
     */
    @GetMapping("/3/{param}")
    public String method3(@PathVariable("param") String param) {
        return "request like www.xx.com/3/param with param =" + param;
    }

    /**
     * @return
     */
    @GetMapping("/4")
    public String method4(@RequestParam("param") String param) {
        return "request like www.xx.com/4?param=1 with param=" + param;
    }

    @GetMapping("/5")
    public String method5() {
        return "the wrapper object in application.yml is " + wrapper.toString();
    }

    @GetMapping("/6")
    public String method6() {
        return "the compound attribute is " + compound;
    }
}
