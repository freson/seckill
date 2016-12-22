package org.seckill.web;

import java.io.IOException;


import org.seckill.entity.User;
import org.seckill.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
public class TestVelocityController {
	@Autowired
	UserService userService;
	
	//http://localhost:8080/seckill_mvn/showUser?id=8
	 @RequestMapping(value = "/showUser",method = RequestMethod.GET)
	    public String showUser(@RequestParam("id") String id, Model model) throws IOException {
	       // response.getWriter().print("<h1>Hello SpringMVC</h1>");  response-->HttpServletResponse
	       //response.flushBuffer();
		 
		 	//1.调用BLL层的服务接口
		    User user = userService.getUserbyId(id);
	        //2.设置模型数据
		    model.addAttribute("user", user);
		   // model.put("user",user);	model--> ModelMap
	        //3.返回逻辑视图名称
	        return "showUser";
		 
	    }
}
