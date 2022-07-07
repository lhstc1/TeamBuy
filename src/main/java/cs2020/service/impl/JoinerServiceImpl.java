package cs2020.service.impl;

import cs2020.dao.JoinerDao;
import cs2020.entity.Joiner;
import cs2020.service.JoinerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JoinerServiceImpl implements JoinerService {
    @Autowired
    private JoinerDao joinerDao;

    @Override
    public boolean save(Joiner joiner) {
        joinerDao.save(joiner);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        joinerDao.delete(id);
        return true;
    }

    @Override
    public List<Joiner> getAll() {
        return joinerDao.getAll();
    }
}
