package cs2020.service.impl;

import cs2020.dao.LeaderDao;
import cs2020.entity.Leader;
import cs2020.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaderServiceImpl implements LeaderService {
    @Autowired
    private LeaderDao leaderDao;

    @Override
    public boolean save(Leader leader) {
        leaderDao.save(leader);
        return true;
    }

    @Override
    public Leader getByLeaderName(String leadername) {
        return leaderDao.getByLeaderName(leadername);
    }
}
