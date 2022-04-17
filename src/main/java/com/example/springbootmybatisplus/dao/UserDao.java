package com.example.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootmybatisplus.pojo.UserVO;
import org.springframework.stereotype.Repository;

/**
 * @author 64641
 */
@Repository
public interface UserDao extends BaseMapper<UserVO> {

}
