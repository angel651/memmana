package com.example.memmana6.dao.mapper;
/*
 * 定义DAO接口，未写实现类（不同于Service层）
 * DAO层实现是由Mybatis框架自动建立接口方法与SQL id之间的映射完成的
 */
import java.util.List;


import com.example.memmana6.dao.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper   //映射器接口,因为Spring BOOT项目已经没有配置文件了
@Repository  //组件注解
public interface INewsMapper {
	
	@Select("select * from news") /* 查找所有新闻记录 */
	public List<News> queryAllNews();
}
