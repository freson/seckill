package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.seckill.entity.User;

public interface UserDao {
	 @Select("SELECT * FROM users WHERE id = #{userId}")
	 User getUser(@Param("userId")String userId);
}
