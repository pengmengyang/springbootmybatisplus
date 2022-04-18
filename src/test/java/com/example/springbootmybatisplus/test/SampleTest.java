package com.example.springbootmybatisplus.test;

import com.example.springbootmybatisplus.user.dao.UserDao;
import com.example.springbootmybatisplus.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
public class SampleTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void testSelect() {
        log.info("----- selectAll method test ------");
        List<UserVO> userVOS = userDao.selectList(null);
        for (UserVO userVO : userVOS) {
            log.info("获取的用户: {}", userVO.toString());
        }
    }

    @Test
    public void testInsert() {
        log.info("----- insert method test ------");

    }

}
