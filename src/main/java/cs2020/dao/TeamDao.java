package cs2020.dao;

import cs2020.entity.Team;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface TeamDao {
    @Insert("insert into teams (tname, tfee, needs, been, leader) values(#{tname}, #{tfee}, #{needs}, #{been}, #{leader})")
    public void save(Team team);

    @Update("update teams set tname = #{tname}, tfee = #{tfee}, needs = #{needs}, been = #{been}+1, leader=#{leader} where id = #{id}")
    public void update(Team team);

    @Delete("delete from teams where id = #{id}")
    public void delete(Integer id);

    @Select("select * from teams where id = #{id}")
    public Team getById(Integer id);

    @Select("select * from teams")
    public List<Team> getAll();
}
