package cs2020.service;

import cs2020.entity.Leader;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface LeaderService {
    public boolean save(Leader leader);

    public Leader getByLeaderName(String leadername);
}
