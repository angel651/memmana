package com.example.memmana6.dao.mapper;
/*
 * 映射接口文件处于DAO层
 */

import java.util.List;



import com.example.memmana6.dao.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper   //映射器接口（Spring BOOT项目可以不写配置文件，即使用默认配置）
@Repository  //组件注解
public interface IUserMapper {

	@Select("select * from user where username=#{un}") /* 根据用户名查找 */
	//public User getUserByUsername(String un); //仅仅一个参数时
	public User getUserByUsername(@Param("un") String un);  //标准些，便于扩展（多个参数）
	
	@Select("select * from user where username=#{un} and password=#{pwd}") 
	/* 根据用户名和密码2个参数查找时，参数必须在接口方法定义里注解 */
	public User getUserByUsernameAndPassword(@Param("un") String un, @Param("pwd") String pwd);

	@Select("select * from user order by password") /* 查找所有用户 */
	public List<User> getAllUsers();

	@Insert("insert ignore into user(username,password,age,realname,mobile) values(#{username},#{password},#{age},#{realname},#{mobile})")
	//关键字ignore：忽略主键重复
	public int addUser(User user);

	@Update("update user set password=#{password},realname=#{realname},mobile=#{mobile},age=#{age} where username=#{username}")
	public int updateUser(User user);

	@Delete("delete from user where username=#{un}")
	public int deleteUser(String username);
}
