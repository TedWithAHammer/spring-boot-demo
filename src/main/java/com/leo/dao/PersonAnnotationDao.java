package com.leo.dao;

import com.leo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangliying on 2017/4/14.
 * Description:mybatis way(annotation)
 */
@Component
@Mapper
public interface PersonAnnotationDao {
    @Select("SELECT * FROM person")
    List<Person> findAll();
}
