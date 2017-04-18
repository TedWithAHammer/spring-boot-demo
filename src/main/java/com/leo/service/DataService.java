package com.leo.service;

import com.leo.dao.PersonAnnotationDao;
import com.leo.domain.Person;
import com.leo.mapper.PersonMapper;
import com.leo.repository.SpringDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wangliying on 2017/4/9.
 * Description:
 */
@Service
public class DataService {

    @Autowired
    private SpringDataRepository repository;

    @Autowired
    private PersonMapper personMapper;

    @Autowired
    private PersonAnnotationDao personAnnotationDao;


    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person insertRecord(Person person) {
        return repository.save(person);
    }

    public Person findById(int id) {
        return repository.findOne(id);
    }

    public List<Person> findByName(String name) {
        return repository.findByName(name);
    }

    public Person updatePerson(Person person) {
        return repository.save(person);
    }


    public List<Person> findAllPersonXMLWithMyBatis() {
        return personMapper.findAllPersons();
    }

    public List<Person> findAllPersonInAnnotationWithMyBatis() {
        return personAnnotationDao.findAllPersons();
    }


}
