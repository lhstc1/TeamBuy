package cs2020.controller;

import cs2020.entity.Team;
import cs2020.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @PostMapping
    public Result save(@RequestBody Team team) {
        boolean flag = teamService.save(team);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @PutMapping
    public Result update(@RequestBody Team team) {
        boolean flag = teamService.update(team);
        return new Result(flag ? Code.UPDATE_OK : Code.UPDATE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = teamService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        Team team = teamService.getById(id);
        Integer code = team != null ? Code.GET_OK : Code.GET_ERR;
        String msg = team != null ? "" : "数据查询失败，请重试！";
        return new Result(code, team, msg);
    }

    @GetMapping
    public List<Team> getAll() {
        List<Team> teamList = teamService.getAll();
        Integer code = teamList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = teamList != null ? "" : "数据查询失败，请重试！";
        return teamList;
    }
}
