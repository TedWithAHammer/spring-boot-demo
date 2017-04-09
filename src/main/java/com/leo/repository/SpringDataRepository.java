package com.leo.repository;

import com.leo.domain.BaseBean;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by wangliying on 2017/4/9.
 * Description:
 */
public interface SpringDataRepository extends JpaRepository<BaseBean, Integer> {
}
