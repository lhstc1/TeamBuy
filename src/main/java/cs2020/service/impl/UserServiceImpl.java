package cs2020.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cs2020.dao.UserDao;
import cs2020.entity.User;
import cs2020.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        userDao.save(user);
        return true;
    }

    @Override
    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }
}
