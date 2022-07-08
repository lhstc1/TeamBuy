package cs2020.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cs2020.entity.User;
import cs2020.service.UserService;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public Result save(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(password.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        User user1 = new User(username,md5Str);
        boolean flag = userService.save(user1);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @RequestMapping("/getByUserName")
    public Result getByUserName(@RequestBody User login_user, HttpSession session) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(login_user.getPassword().getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        User user = userService.getByUserName(login_user.getUsername());
        //System.out.print(user);
        Integer code;
        String msg;
        if (user != null) {
            if (Objects.equals(md5Str, user.getPassword())) {
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
