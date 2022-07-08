package cs2020.controller;

import cs2020.entity.Leader;
import cs2020.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@RestController
@RequestMapping("/leader")
public class LeaderController {
    @Autowired
    private LeaderService leaderService;

    @PostMapping
    public Result save(@RequestBody Leader leader) {
        boolean flag = leaderService.save(leader);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @RequestMapping("/getByLeaderName")
    public Result getByLeaderName(@RequestBody Leader login_leader, HttpSession session) {
        Leader leader = leaderService.getByLeaderName(login_leader.getLeadername());
        Integer code;
        String msg;
        if (leader != null) {
            if (Objects.equals(login_leader.getPassword(), leader.getPassword())) {
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
