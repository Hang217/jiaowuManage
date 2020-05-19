package com.yu.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yu.pojo.Gonggao;
import com.yu.pojo.Student;
import com.yu.pojo.Teacher;
import com.yu.pojo.User;
import com.yu.service.StudentService;
import com.yu.service.TeacherService;
import com.yu.service.UserService;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Resource
	UserService userService;
	
	@Resource
	StudentService studentService;
	
	@Resource
	TeacherService teacherService;
	
	@RequestMapping("/login")
	public String login(User user,Model model,HttpServletRequest req) {
		HttpSession session=req.getSession();
		int usertype=-1;
		if(user!=null){
		  usertype=user.getUsertype();
		  if(usertype==1){
			  //管理员
			 User loginuser= userService.userlogin(user);
			 if(loginuser!=null){
				 session.setAttribute("user", loginuser);
				 return "homepage/index";
			 }else{
				 model.addAttribute("msg", "请输入正确的用户名和密码");
				 return "/login";
			 }
		  }else if(usertype==2){
			  //学生
			  Student student=new Student();
			  student.setLoginname(user.getName());
			  student.setPassword(user.getPassword());
			  Student loginstu=studentService.stulogin(student);
			  if(loginstu!=null){
				  session.setAttribute("user", loginstu);
				  return "homepage/index";
			  }else{
				  model.addAttribute("msg", "请输入正确的用户名和密码");
				  return "/login";
			  }
			 
		  }else{
			 //老师 
			  Teacher tea=new Teacher();
			  tea.setLoginname(user.getName());
			  tea.setPassword(user.getPassword());
			  Teacher logintea=teacherService.loginTea(tea);
			  if(logintea!=null){
				  session.setAttribute("user", logintea);
				  return "homepage/index";
			  }else{
				  model.addAttribute("msg", "请输入正确的用户名和密码");
				  return "/login";
			  }
		  }
		  
		}
		return "homepage/index";
	}
	
	//退出
	@RequestMapping(value = "/logout", method = { RequestMethod.GET })
	public String logout(HttpServletRequest request,HttpServletResponse response, HttpSession session) throws Exception {
		session.invalidate();// 清除session
		return "login";
	}
	
	//获取用户信息
		@RequestMapping(value = "/getUserDetail", method = { RequestMethod.GET })
		public String getUserDetail(HttpServletRequest request,HttpServletResponse response, 
				HttpSession session,Integer id,Model model) throws Exception {
			User u = userService.getUserDetail(id);
			model.addAttribute("user", u);
			return "homepage/userDetail";
		}
		

		//获取公告信息
			@RequestMapping(value = "/getGonggao", method = { RequestMethod.GET })
			public String getGonggao(HttpServletRequest request,HttpServletResponse response, 
					HttpSession session,Model model) throws Exception {
//				User u = userService.getUserDetail(id);
				List<Gonggao> listgong=userService.getGonggao();
			
				System.out.println("==listgong=="+listgong.get(0));
				model.addAttribute("listgong", listgong);
				return "gonggao/list";
			}
			//添加公告信息
			@RequestMapping(value = "/addGonggao")
			public String addGonggao(HttpServletRequest request,HttpServletResponse response, 
					HttpSession session,Model model) throws Exception {
				return "gonggao/add";
			}
			//添加公告信息
			@RequestMapping(value = "/addSave")
			public String addSave(HttpServletRequest request,HttpServletResponse response, 
					HttpSession session,Model model,Gonggao gonggao,String date) throws Exception {
				System.out.println("--gonggao--"+gonggao.getName());
				System.out.println("--date--"+date);
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//				Date d = dateFormat.parse(date);
//				gonggao.setDate(d);
				userService.insert(gonggao);
	             return "redirect:/admin/getGonggao"; 
				
			}	
			
			/*
		     * 删除单个对象Action
		     */
		    @RequestMapping("/delete/{id}")
		    public String delete(Model model,@PathVariable int id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
		        if(userService.delete(id)>0)
		        {
		            redirectAttributes.addFlashAttribute("message", "删除成功！");
		        }else{
		            redirectAttributes.addFlashAttribute("message", "删除失败！");
		        }
		        return "redirect:/admin/getGonggao";
		    }
	
//		    @InitBinder
//		    public void initBinder(ServletRequestDataBinder binder) {
//		    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		    // dateFormat.setLenient(false);
//		    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//		    // binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
//		    }
}
