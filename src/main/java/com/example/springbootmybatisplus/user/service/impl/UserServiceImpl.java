package com.example.springbootmybatisplus.user.service.impl;

import com.example.springbootmybatisplus.user.vo.UserVO;
import com.example.springbootmybatisplus.user.dao.UserDao;
import com.example.springbootmybatisplus.user.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 6464
 * @since 2022-04-18
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserVO> implements IUserService {

}
