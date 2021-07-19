package com.example.memmana6.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.memmana6.dao.entity.Admin;
import org.springframework.stereotype.Repository;


@Mapper   //映射器接口,因为Spring BOOT项目已经没有配置文件了
@Repository  //组件注解
public interface IAdminMapper {
	@Select("select * from admin where username=#{un}") 
	Admin queryAdminByUsername(String un);
}
