package cs2020.dao;

import cs2020.entity.Team;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeamDao {
    @Insert("insert into team (name, leader, fee, sum, pfee, tfee, elsefee) values(#{name}, #{leader}, #{fee}, #{sum}, #{pfee}, #{tfee}, #{elsefee})")
    public void save(Team team);

    @Update("update team set name = #{name}, leader=#{leader}, fee = #{fee}, sum = #{sum}, pfee = #{pfee}, tfee = #{tfee}, elsefee = #{elsefee} where id = #{id}")
    public void update(Team team);

    @Delete("delete from team where id = #{id}")
    public void delete(Integer id);

    @Select("select * from team where id = #{id}")
    public Team getById(Integer id);

    @Select("select * from team")
    public List<Team> getAll();
}
