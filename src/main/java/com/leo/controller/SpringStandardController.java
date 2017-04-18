package com.leo.controller;

import com.leo.domain.ResultCallback;
import com.leo.domain.Person;
import com.leo.service.DataService;
import com.leo.utils.ResultHandleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by wangliying on 2017/4/10.
 * Description:standard test for spring-boot
 */
@RestController
public class SpringStandardController {
    @Autowired
    private DataService service;

    @PostMapping("/insertRecord")
    public ResultCallback insertRecord(@Valid Person person, BindingResult result) throws Exception {
        if (result.hasErrors())
            return ResultHandleUtil.handleError(100, result.getFieldError().getDefaultMessage(), null);
        return ResultHandleUtil.handleSuccess(service.insertRecord(person));
    }


    @GetMapping("/findAll")
    public ResultCallback findAll() {
        return ResultHandleUtil.handleSuccess(service.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResultCallback findById(@PathVariable("id") int id) {
        return ResultHandleUtil.handleSuccess(service.findById(id));
    }

    @GetMapping("/findByName/{name}")
    public ResultCallback findByName(@PathVariable("name") String name) {
        return ResultHandleUtil.handleSuccess(service.findByName(name));
    }

    @PostMapping("/update")
    public ResultCallback update(Person person) {
        return ResultHandleUtil.handleSuccess(service.updatePerson(person));
    }

    @GetMapping("/mybatis/annotation/findAll")
    public ResultCallback findAllWithAnnotationMybatis() {
        return ResultHandleUtil.handleSuccess(service.findAllPersonInAnnotationWithMyBatis());
    }

    @GetMapping("/mybatis/xml/findAll")
    public ResultCallback findAllWithXMLMybatis() {
        return ResultHandleUtil.handleSuccess(service.findAllPersonXMLWithMyBatis());
    }


}
