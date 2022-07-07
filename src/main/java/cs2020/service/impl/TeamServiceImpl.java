package cs2020.service.impl;

import cs2020.dao.TeamDao;
import cs2020.entity.Team;
import cs2020.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {
    @Autowired
    private TeamDao teamDao;

    @Override
    public boolean save(Team team) {
        teamDao.save(team);
        return true;
    }

    @Override
    public boolean update(Team team) {
        teamDao.update(team);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        teamDao.delete(id);
        return true;
    }

    @Override
    public Team getById(Integer id) {
        return teamDao.getById(id);
    }

    @Override
    public List<Team> getAll() {
        return teamDao.getAll();
    }
}
