package com.example.memmana6.service.serviceImp;
/*
 * 服务层实现类，使用了组件注解，会被扫描到（见Spring MVC配置文件之组件扫描）
 */
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.memmana6.dao.entity.News;
import com.example.memmana6.dao.mapper.INewsMapper;
import com.example.memmana6.service.NewsService;

@Service
public class NewsServiceImp implements NewsService {
	
	@Autowired
	private INewsMapper newsDao; // 注入了数据访问层的对象
	
	//@Override
	public List<News> queryAllNews() {
		return newsDao.queryAllNews();
	}
}
