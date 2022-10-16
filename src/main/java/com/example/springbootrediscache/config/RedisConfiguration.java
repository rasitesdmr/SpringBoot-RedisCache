package com.example.springbootrediscache.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

    @Bean
    public LettuceConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<?, ?> redisTemplate() {
        RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory());
        return redisTemplate;
    }

      /*
        @Bean
        public JedisConnectionFactory jedisConnectionFactory() {
            RedisStandaloneConfiguration redisStandaloneConfiguration =
                    new RedisStandaloneConfiguration("localhost", 6379);
            return new JedisConnectionFactory(redisStandaloneConfiguration);
        }
     */

}
