package com.leo.mapper;

import com.leo.domain.Person;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wangliying on 2017/4/12.
 * Description:mybatis way (xml)
 */

public interface PersonMapper {
    //    @Select("SELECT * FROM person")
    List<Person> findAllPersons();

}
