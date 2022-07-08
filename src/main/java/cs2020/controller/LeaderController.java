package cs2020.controller;

import cs2020.entity.Leader;
import cs2020.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

@RestController
@RequestMapping("/leader")
public class LeaderController {
    @Autowired
    private LeaderService leaderService;

    @PostMapping
    public Result save(@RequestBody Leader leader) {
        String leadername = leader.getLeadername();
        String password = leader.getPassword();
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest  = md5.digest(password.getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        Leader leader1 = new Leader(leadername,md5Str);
        boolean flag = leaderService.save(leader1);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @RequestMapping("/getByLeaderName")
    public Result getByLeaderName(@RequestBody Leader login_leader, HttpSession session) {
        byte[] digest = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            digest = md5.digest(login_leader.getPassword().getBytes("utf-8"));
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //16是表示转换为16进制数
        String md5Str = new BigInteger(1, digest).toString(16);
        Leader leader = leaderService.getByLeaderName(login_leader.getLeadername());
        Integer code;
        String msg;
        if (leader != null) {
            if (Objects.equals(md5Str, leader.getPassword())) {
                code = Code.LOGIN_OK;
                msg = "登录成功！";
                // 登录成功，将用户信息保存到session对象中
                session.setAttribute("leader", leader.getLeadername());
            } else {
                code = Code.LOGIN_ERR;
                msg = "密码错误！";
            }
        } else {
            code = Code.GET_ERR;
            msg = "登录失败！";
        }
        return new Result(code, leader, msg);
    }
}
