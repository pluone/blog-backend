package xyz.peilu.vblog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import xyz.peilu.vblog.common.Result;
import xyz.peilu.vblog.entity.User;
import xyz.peilu.vblog.service.UserService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author peilu
 * @since 2020-08-13
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/index")
    public Result index() {
        User user = userService.getById(1L);
        return Result.succ(user);
    }
}
