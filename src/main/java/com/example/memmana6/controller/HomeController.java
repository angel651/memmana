package com.example.memmana6.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.memmana6.dao.entity.News;
import com.example.memmana6.service.NewsService;

@Controller
@RequestMapping({"/Home", "/", "" })
public class HomeController {
	@Autowired
	private NewsService newsService;  //注解注入服务层对象
	@Autowired
	News u;  //下面的控制台测试代码里，使用了本实体类对象

	@RequestMapping({"", "/", "/index" })
	public String index(Model model) {  //方法
		List<News> news = newsService.queryAllNews();
		for(News u:news) System.out.println(u);  //Console输出测试，必须先注入实体类对象
		model.addAttribute("newsList", news);
		return "home/index";  //视图
	}
}

