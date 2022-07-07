package cs2020.dao;

import cs2020.entity.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ActivityDao {
    @Insert("insert into activity (name, date, span, fee, introduction, leader, tfee) values(#{name}, #{date}, #{span}, #{fee}, #{introduction}, #{leader}, #{tfee})")
    public void save(Activity activity);

    @Update("update activity set name = #{name}, date = #{date}, span = #{span}, fee = #{fee}, introduction = #{introduction}, leader=#{leader}, tfee=#{tfee} where id = #{id}")
    public void update(Activity activity);

    @Delete("delete from activity where id = #{id}")
    public void delete(Integer id);

    @Select("select * from activity where id = #{id}")
    public Activity getById(Integer id);

    @Select("select * from activity")
    public List<Activity> getAll();
}
