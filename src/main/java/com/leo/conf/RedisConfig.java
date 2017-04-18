package com.leo.conf;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * Created by wangliying on 2017/4/18.
 * Description:
 */
@Configuration
@EnableCaching
public class RedisConfig  extends CachingConfigurerSupport {

}
