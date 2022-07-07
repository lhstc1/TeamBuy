package cs2020.service.impl;

import cs2020.dao.ActivityDao;
import cs2020.entity.Activity;
import cs2020.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public boolean save(Activity activity) {
        activityDao.save(activity);
        return true;
    }

    @Override
    public boolean update(Activity activity) {
        activityDao.update(activity);
        return true;
    }

    @Override
    public boolean delete(Integer id) {
        activityDao.delete(id);
        return true;
    }

    @Override
    public Activity getById(Integer id) {
        return activityDao.getById(id);
    }

    @Override
    public List<Activity> getAll() {
        return activityDao.getAll();
    }
}
