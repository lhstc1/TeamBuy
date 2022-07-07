package cs2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cs2020.entity.User;
import cs2020.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result save(@RequestBody User user) {
        boolean flag = userService.save(user);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @RequestMapping("/getByUserName")
    public Result getByUserName(@RequestBody User login_user, HttpSession session) {
        User user = userService.getByUserName(login_user.getUsername());
        Integer code;
        String msg;
        if (user != null) {
            if (Objects.equals(login_user.getPassword(), user.getPassword())) {
                code = Code.LOGIN_OK;
                msg = "登录成功！";
                // 登录成功，将用户信息保存到session对象中
                session.setAttribute("user", user.getUsername());
            } else {
                code = Code.LOGIN_ERR;
                msg = "密码错误！";
            }
        } else {
            code = Code.GET_ERR;
            msg = "该用户未注册！";
        }
        return new Result(code, user, msg);
    }
}
