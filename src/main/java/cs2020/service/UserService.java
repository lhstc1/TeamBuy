package cs2020.service;

import org.springframework.transaction.annotation.Transactional;
import cs2020.entity.User;

@Transactional
public interface UserService {
    public boolean save(User user);

    public User getByUserName(String username);
}
