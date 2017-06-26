package com.leo.controller;

import com.leo.domain.Person;
import com.leo.domain.ResultCallback;
import com.leo.service.DataService;
import com.leo.utils.RabbitMQSender;
import com.leo.utils.ResultHandleUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.callback.CallbackHandler;
import javax.validation.Valid;

/**
 * Created by wangliying on 2017/4/10.
 * Description:standard test for spring-boot
 */
@RestController
public class SpringStandardController {
    private static Logger logger = LoggerFactory.getLogger("SpringStandardController");
    @Autowired
    private DataService service;
    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/insertRecord")
    public ResultCallback insertRecord(@Valid Person person, BindingResult result) throws Exception {
        if (result.hasErrors())
            return ResultHandleUtil.handleError(100, result.getFieldError().getDefaultMessage(), null);
        return ResultHandleUtil.handleSuccess(service.insertRecord(person));
    }


    @PostMapping("/test")
    public ResultCallback test(@RequestParam("name") String name) {
        logger.info(name);
        return ResultHandleUtil.handleSuccess(name);
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
        return ResultHandleUtil.handleSuccess(service.findAllPersonInAnnotationWithMybatis());
    }

    @GetMapping("/mybatis/xml/findAll")
    public ResultCallback findAllWithXMLMybatis() {
        return ResultHandleUtil.handleSuccess(service.findAllPersonXMLWithMyBatis());
    }


    @PostMapping("/mybatis/xml/insertPerson")
    public ResultCallback insertPersonInXMLWithMybatis(Person person) {
        service.insertPersonInXMLWithMybatis(person);
        return ResultHandleUtil.handleSuccess(null);
    }

    @GetMapping("/rabbitmq/queue1/send")
    public ResultCallback rabbitmqSend2Queue1(@RequestParam("msg") String msg) {
        rabbitMQSender.send2Queue1(msg);
        return ResultHandleUtil.handleSuccess(null);
    }

    @GetMapping("/rabbitmq/queue2/send")
    public ResultCallback rabbitmqSend2Queue2(@RequestParam("msg") String msg) {
        rabbitMQSender.send2Queue2(msg);
        return ResultHandleUtil.handleSuccess(null);
    }

    @GetMapping("/rabbitmq/queue3/send")
    public ResultCallback rabbitmqSend2Queue3(@RequestParam("msg") String msg) {
        rabbitMQSender.send2Queue3(msg);
        return ResultHandleUtil.handleSuccess(null);
    }
}
