package com.example.memmana6.controller;
/*
 * 后台管理员的Ajax登录及管理员功能
 * 管理员的Ajax登录流程：主页底部的链接，请求控制器AdminController方法toAdminLogin()->转发至管理员登录页面adminLogin.jsp->
 * 						请求Ajax方法adminLogin()->返回键值对结果数据
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.example.memmana6.dao.entity.User;
import com.example.memmana6.service.AdminService;
import com.example.memmana6.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.memmana6.dao.entity.Admin;
import com.example.memmana6.dao.mapper.IUserMapper;
import com.example.memmana6.service.UserService;

@CrossOrigin
@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	private AdminService adminService;  //管理员登录时用
	@Autowired
	private UserService userService;  //会员列表时用
	@Autowired
	private IUserMapper userDao;  //用户分页时用

	
	@RequestMapping("/toAdminLogin")
	public String toAdminLogin() {
		return "admin/adminLogin";  //进入登录视图并请求Ajax登录方法adminLogin()
	}
	@RequestMapping("/adminLogin")
	@ResponseBody   //注解Ajax方法
	/*
	 * 这个注解表示该方法的返回结果直接写入HTTP response body中，一般在异步获取数据时使用。
	 * 在使用@RequestMapping后，返回值通常解析为跳转路径。加上@responsebody后，返回结果直接写入HTTP response body中，不会被解析为跳转路径。
	 * 比如异步请求，希望响应的结果是json数据，那么加上@responsebody后，就会直接返回json数据。
	 * ==================================================================================
	 * 处理管理员以异步提交方式的登录方法adminLogin()
	 * 方法返回结果为Map<String, Object>类型。其中，键名success表示登录是否成功；键名msg存放登录失败时的提示信息
	 * 管理员登录密码存放在表admin的字段名username取值为admin的记录的password字段里【使用md5加密，明码默认设置为admin】
	 * 流程：请求adminLogin.jsp->控制器AdminController方法adminLogin()——用于异步处理的Ajax方法->控制器方法adminIndex()，转发至后台主页adminIndex.jsp
	 */
	public Map<String, Object> adminLogin(String pw, HttpSession session)throws Exception {
		System.out.println(pw);  //测试异步提交的数据——密码
		Map<String, Object> result = new HashMap<String, Object>();
		Admin admin = adminService.queryAdminByUsername("admin");
		System.out.println(admin); //测试
		if(MD5Util.MD5(pw).equalsIgnoreCase(admin.getPassword())) { // 正确
			session.setAttribute("admin", admin.getUsername()); //管理员会话跟踪
			System.out.println("管理员会话信息："+(String) session.getAttribute("admin"));
			result.put("success", true);
		}else{
			result.put("msg", "密码错误!正确的密码存放在表admin，密码为admin。");
			result.put("success", false);
		}
		System.out.println(result); //测试
		return result; // 返回键值对数据
	}
	
	@RequestMapping("/adminIndex")
	public String adminIndex() {   //在管理员登录表单页面里的ajax()调用，用于登录成功后
		return "admin/adminIndex";  //转发至后台主页
	}

	@RequestMapping("/memInfo")
	public String memInfo(HttpServletRequest request, HttpSession session) throws Exception {  
		List<User> users = userDao.getAllUsers();
		request.setAttribute("userList", users);  
		return "admin/memInfo";
	}

	@RequestMapping("/memDelete")
	public String memDelete(HttpServletRequest request, String username, HttpSession session) throws Exception {
		//方法memDelete()比方法memInfo()多包含1个参数——欲删除的用户名
		System.out.println("管理员会话信息："+(String) session.getAttribute("admin"));
		if (username != null) {
			User user = new User();
			user.setUsername(username);  //删除记录
			userService.deleteUser(user);
		}
		List<User> users = userDao.getAllUsers(); 
		request.setAttribute("userList", users); 
		return "admin/memDelete";
	}
}
