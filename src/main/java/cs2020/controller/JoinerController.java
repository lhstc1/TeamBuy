package cs2020.controller;

import cs2020.entity.Joiner;
import cs2020.service.JoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/joiners")
public class JoinerController {
    @Autowired
    private JoinerService joinerService;

    @PostMapping
    public Result save(@RequestBody Joiner joiner) {
        boolean flag = joinerService.save(joiner);
        return new Result(flag ? Code.SAVE_OK : Code.SAVE_ERR, flag);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        boolean flag = joinerService.delete(id);
        return new Result(flag ? Code.DELETE_OK : Code.DELETE_ERR, flag);
    }

    @GetMapping
    public List<Joiner> getAll() {
        List<Joiner> joinerList = joinerService.getAll();
        Integer code = joinerList != null ? Code.GET_OK : Code.GET_ERR;
        String msg = joinerList != null ? "" : "数据查询失败，请重试！";
        return joinerList;
    }
}
