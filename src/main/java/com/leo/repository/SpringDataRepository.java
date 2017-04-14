package com.leo.repository;

import com.leo.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by wangliying on 2017/4/9.
 * Description:spring way
 */
public interface SpringDataRepository extends JpaRepository<Person, Integer> {
    List<Person> findByName(String name);
}
