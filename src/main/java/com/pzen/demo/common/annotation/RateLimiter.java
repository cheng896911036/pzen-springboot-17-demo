package com.pzen.demo.common.annotation;

import com.pzen.demo.common.constant.CacheConstants;
import com.pzen.demo.common.enums.LimitType;

import java.lang.annotation.*;

/**
 * 限流注解
 *
 * @author pzen
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RateLimiter
{
    /**
     * 限流key
     */
    public String key() default CacheConstants.RATE_LIMIT_KEY;

    /**
     * 限流时间区间,单位秒。即在60秒内访问此处超过100后进行限流
     */
    public int time() default 60;

    /**
     * 限流次数
     */
    public int count() default 100;

    /**
     * 限流类型
     */
    public LimitType limitType() default LimitType.DEFAULT;
}
