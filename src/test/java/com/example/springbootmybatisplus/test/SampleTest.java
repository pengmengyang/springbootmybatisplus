package com.example.springbootmybatisplus.test;

import com.example.springbootmybatisplus.dao.UserDao;
import com.example.springbootmybatisplus.pojo.UserVO;
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
        UserVO userVO = new UserVO();
        userVO.setName("李四");
        userVO.setAge(30);
        userVO.setEmail("125@qq.com");
        int insert = userDao.insert(userVO);
        if (insert > 0) {
            log.info("新增成功: {}", insert);
        } else {
            log.info("新增失败: {}", insert);
        }
    }

}
