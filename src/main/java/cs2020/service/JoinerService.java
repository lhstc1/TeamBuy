package cs2020.service;

import cs2020.entity.Joiner;

import java.util.List;

public interface JoinerService {
    public boolean save(Joiner joiner);

    public boolean delete(Integer id);

    public List<Joiner> getAll();
}
