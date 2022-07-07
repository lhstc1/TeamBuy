package cs2020.dao;

import cs2020.entity.Joiner;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface JoinerDao {
    @Insert("insert into joiners (name, leader, fee, tfee, people) values(#{name}, #{leader}, #{fee}, #{tfee}, #{people})")
    public void save(Joiner joiner);

    @Delete("delete from joiners where id = #{id}")
    public void delete(Integer id);

    @Select("select * from joiners")
    public List<Joiner> getAll();
}
