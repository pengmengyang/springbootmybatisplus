package com.example.springbootmybatisplus.user.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootmybatisplus.user.service.IUserService;
import com.example.springbootmybatisplus.user.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 6464
 * @since 2022-04-18
 */
@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUser")
    public UserVO getUser() {
        UserVO userVO = userService.getById(1);
        log.info("----getUser----: {}", userVO.toString());
        return userVO;
    }

    @GetMapping("/getAllUser")
    public List<UserVO> getAllUser() {
        List<UserVO> list = userService.list();
        for (UserVO userVO : list) {
            log.info("---getAllUser----: {}", userVO.toString());
        }
        return list;
    }

    @GetMapping("/getUserByParam")
    public List<UserVO> getUserByParam(@RequestParam("age") String age, @RequestParam("name") String name) {
        QueryWrapper<UserVO> queryWrapper = new QueryWrapper();
        queryWrapper.ge("age", age);
        queryWrapper.eq("name", name);
        List<UserVO> list = userService.list(queryWrapper);
        for (UserVO userVO : list) {
            log.info("---getUserByParam----: {}", userVO.toString());
        }
        return list;
    }

    @GetMapping("/getPageUser/{size}/{current}")
    public Page<UserVO> getPageUser(@PathVariable("current") Integer current, @PathVariable("size") Integer size) {
        Page<UserVO> page = new Page<>(current, size);
        Page<UserVO> userVOPage = userService.page(page);
        return userVOPage;
    }

}
