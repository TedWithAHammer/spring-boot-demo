package com.leo.service;

import com.leo.repository.SpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wangliying on 2017/4/9.
 * Description:
 */
@Service
public class DataService {
    @Autowired
    private SpringDataRepository repository;

}
