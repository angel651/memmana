package com.example.memmana6.service;
/*
 * 查询所有新闻
 * 本类方法供Home控制器调用 
 */
import java.util.List;

import com.example.memmana6.dao.entity.News;

public interface NewsService{

	List<News> queryAllNews();
}
