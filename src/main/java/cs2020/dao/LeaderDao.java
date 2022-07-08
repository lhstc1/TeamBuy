package cs2020.dao;

import cs2020.entity.Leader;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface LeaderDao {
    @Insert("insert into leader (leadername, password) values(#{leadername}, #{password})")
    public void save(Leader leader);

    @Select("select * from leader where leadername = #{leadername}")
    public Leader getByLeaderName(String leadername);
}
