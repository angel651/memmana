package com.example.memmana6.controller;
/*
 * 控制层控制器，调用服务层
 */
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.memmana6.dao.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.memmana6.service.UserService;

@Controller
@RequestMapping("/User")
public class UserController {
	@Autowired
	private UserService userService;  //注入服务层对象

	@RequestMapping("/mLogin")
	public String toLogin() {
		System.out.println("准备进入登录表单页面...");
		return "user/mLogin";
	}

	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session, Model model) throws Exception {
		//下面的方法参数username和password是表单元素名，即属性驱动——http请求传参（post和get方式相同）
		System.out.println("username=" + username + "" + "   password=" + password);  //测试接收
		User user = userService.queryUserByUserNameAndPassword(username, password);
		if (user != null) {  //创建会话对象
			session.setAttribute("username", username); // 前台用户会话属性设置
			System.out.println("前台用户会话 username:" + session.getAttribute("username"));
			return "redirect:/index";  //跳转至另一个控制器方法，使用“redirect:”识别
		} else {
			model.addAttribute("message", "用户名和密码错误!");
			return "public/message";  //转发至视图
		}
	}

	@RequestMapping("/mRegister")
	public String toRegister() {
		return "user/mRegister";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(User user, Model model) throws Exception {
		if ("".equals(user.getUsername()) || "".equals(user.getPassword())) { // 防止空提交
			model.addAttribute("message", "用户名和密码不能为空!");
			return "public/message";
		} else {
			User tempUser = userService.queryUserByUsername(user.getUsername());
			if (tempUser != null) { 
				model.addAttribute("message", "该用户名已经存在!");
				return "public/message";
			} else {
				userService.addUser(user);
				model.addAttribute("message", "注册成功！");
				return "public/message"; // 转向控制
			}
		}
	}

	@RequestMapping("/mUpdate")
	public String mUpdate(HttpSession session, Model model) throws Exception{
		String un=(String)session.getAttribute("username"); //会话信息
    	if(null==un){
    		model.addAttribute("message", "未登录!");
    		return "public/message";  //消息处理公共页
    	}else{
    		User user = userService.queryUserByUsername(un);
			model.addAttribute(user);
    	}
		return "user/mUpdate";  //转发至修改表单页
	}
	// 更新会员信息，参数为一个实体
	@RequestMapping("/updateMem")
	public String updateMem(User user, HttpServletRequest request, HttpServletResponse resp){
		try {
			String username = (String)request.getSession().getAttribute("username");
			user.setUsername(username);
			System.out.println(user);//测试
			userService.updateUser(user);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return "redirect:/index";
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)  //其中第2个参数可去！
	public String logout(HttpSession session) throws Exception{
		session.invalidate();  //让会话信息失效就是登出
		return "redirect:/index";  //重定向
	}
}
