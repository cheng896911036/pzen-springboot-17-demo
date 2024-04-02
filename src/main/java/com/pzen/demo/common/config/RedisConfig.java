package com.pzen.demo.common.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Redis配置
 *
 * @author pzen
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {
    @Bean
    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);

        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);

        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);

        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);

        template.afterPropertiesSet();
        return template;
    }

    @Bean
    public DefaultRedisScript<Long> limitScript() {
        DefaultRedisScript<Long> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptText(limitScriptText());
        redisScript.setResultType(Long.class);
        return redisScript;
    }


    /**
     * 限流脚本
     * Lua脚本：实现基于Redis的限流器
     * 功能：根据给定的键（key）、访问计数（count）和过期时间（time），限制访问次数
     * 参数：
     * - KEYS[1]：待限制访问次数的键名
     * - ARGV[1]：允许的访问计数
     * - ARGV[2]：键的过期时间（秒）
     * 返回值：当前访问计数
     *
     * @return
     */
    private String limitScriptText() {
        return "local key = KEYS[1]\n" +
                "local count = tonumber(ARGV[1])\n" +
                "local time = tonumber(ARGV[2])\n" +
                "-- 检查输入参数的合法性\n" +
                "if not key or not count or not time or count <= 0 or time <= 0 then\n" +
                "    error('Invalid arguments: key, count and time must be non-empty and positive')\n" +
                "end\n" +
                "local current = redis.call('get', key);\n" +
                "if current and tonumber(current) > count then\n" +
                "    return tonumber(current);\n" +
                "end\n" +
                "current = redis.call('incr', key)\n" +
                "if tonumber(current) == 1 then\n" +
                "    redis.call('expire', key, time)\n" +
                "end\n" +
                "return tonumber(current);";
    }


    /**
     * 原限流脚本
     */
//    private String limitScriptText() {
//        return "local key = KEYS[1]\n" +
//                "local count = tonumber(ARGV[1])\n" +
//                "local time = tonumber(ARGV[2])\n" +
//                "local current = redis.call('get', key);\n" +
//                "if current and tonumber(current) > count then\n" +
//                "    return tonumber(current);\n" +
//                "end\n" +
//                "current = redis.call('incr', key)\n" +
//                "if tonumber(current) == 1 then\n" +
//                "    redis.call('expire', key, time)\n" +
//                "end\n" +
//                "return tonumber(current);";
//    }




}
