package com.tailgrass.application.common.data.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.tailgrass.application.common.data.entity.User;

@Mapper
public interface UserMapper {

	@Insert("insert into user(user_name,user_phone) values(#{userName},#{userPhone})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int insert(User user);
	
	@Update("update user set user_name=#{userName}, user_phone=#{userPhone} where id = #{id}")
	int update(User user);
	
	@Results(value = {
			@Result(column = "id", property = "id", id = true),
			@Result(column = "user_name", property = "userName"),
			@Result(column = "user_Phone", property = "userPhone"),
			@Result(column = "create_time", property = "createTime"),
			@Result(column = "update_time", property = "updateTime"),

	})
	@Select("select id, user_name, user_phone, create_time, update_time from user where id = #{id}")
	User findById(long id);
	
	@Delete("delete from user where id = #{id}")
	int deleteById(long id);
}
