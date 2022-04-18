package com.example.springbootmybatisplus.user.dao;

import com.example.springbootmybatisplus.user.vo.UserVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 6464
 * @since 2022-04-18
 */
@Repository
public interface UserDao extends BaseMapper<UserVO> {

}
