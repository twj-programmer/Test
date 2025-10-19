package me.hmhb.test.mapper;

import me.hmhb.test.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into db_user (name, sex, age) values (#{name}, #{sex}, #{age})")
    int insertUser(User user);
}
