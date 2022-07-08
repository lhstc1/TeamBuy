package cs2020.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import cs2020.entity.User;

public interface UserDao {
    @Insert("insert into users (username, password) values(#{username}, #{password})")
    public void save(User user);

    @Select("select * from users where username = #{username}")
    public User getByUserName(String username);

}
