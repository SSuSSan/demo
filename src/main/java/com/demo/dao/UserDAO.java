package com.demo.dao;

import com.demo.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDAO {
    String TABLE_NAME = " user ";
    String INSERT_FIELDS = " name, password, salt, head_url ";
    String SELECT_FIELDS = " id, " + INSERT_FIELDS;

    @Insert({"insert into ", TABLE_NAME, "(", INSERT_FIELDS,
            ") values (#{name},#{password},#{salt},#{headUrl})"})
    int addUser(User user);

    User selectById(@Param("id") int id);

    //@Update({"update ", TABLE_NAME, " set password=#{password} where id=#{id}"})
    //void updatePassword(User user);
    //
    //@Delete({"delete from ", TABLE_NAME, " where id=#{id}"})
    //void deleteById(int id);
}

