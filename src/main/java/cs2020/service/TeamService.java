package cs2020.service;

import cs2020.entity.Team;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface TeamService {
    public boolean save(Team team);

    public boolean update(Team team);

    public boolean delete(Integer id);

    public Team getById(Integer id);

    public List<Team> getAll();
}
