package com.example.imsbackend;

import com.example.imsbackend.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ImsBackendApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userMapper.selectById(1));
    }

}
