package com.leo;

import com.leo.dao.PersonAnnotationDao;
import com.leo.domain.Person;
import com.leo.mapper.PersonMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wangliying on 2017/4/12.
 * Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private PersonAnnotationDao personAnnotationDao;


    @Test
    public void testMyBatisFindAllPersons() {
        Assert.assertEquals(13, personMapper.findById(1).getAge());
    }

    @Test
    public void testAnnotationFindAllPersons() {
        Assert.assertEquals(1, personAnnotationDao.findAllPersons().size());
    }

    @Test
    public void testXmlInsert(){
        Person person=new Person();
        person.setAge(33);
        person.setName("kkgg");
        personMapper.insertPerson(33,"lkkkggg");
        Assert.assertEquals(5,personMapper.findAllPersons().size());
    }
}
