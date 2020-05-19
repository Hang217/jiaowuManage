package com.yu.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yu.pojo.Classes;
import com.yu.pojo.CourseExt;
import com.yu.pojo.Gonggao;
import com.yu.pojo.Sc;
import com.yu.pojo.Student;
import com.yu.service.ClassesService;
import com.yu.service.StudentService;
import com.yu.service.UserService;

@Controller
@RequestMapping("/stu")
public class StudentController {

	@Resource
	StudentService studentService;
	
	@Resource
	ClassesService classesService;
	@Resource
	UserService userService;
	//获取公告信息
	@RequestMapping(value = "/getGonggao", method = { RequestMethod.GET })
	public String getGonggao(HttpServletRequest request,HttpServletResponse response, 
			HttpSession session,Model model) throws Exception {
//		User u = userService.getUserDetail(id);
		List<Gonggao> listgong=userService.getGonggao();
		System.out.println("==listgong=="+listgong.get(0));
		model.addAttribute("listgong", listgong);
		return "gonggao/gonggaolist";
	}
	
	@RequestMapping("/list")
	public String getlist(@RequestParam(required=false,defaultValue="1") int pageNO,Model model) {
		int size=10;
	    List<Student> slist=studentService.getStudentPager(pageNO, size);
	    model.addAttribute("pageNO", pageNO);
	    model.addAttribute("size", size);
	    model.addAttribute("count", studentService.getCount());
	    model.addAttribute("slist", slist);
		return "student/list";
	}
	/*
	 * 学生自己修改个人信息
	 * */
	@RequestMapping("/editStudent")
	public String editStudent(Model model,Integer id){
		List<Classes> clist=classesService.getAllClasses();
		model.addAttribute("clist", clist);
		model.addAttribute("entity", studentService.selectByPrimaryKey(id));
		return "student/editStudent";
	}
	
	@RequestMapping("/editStudentSave")
	public String editStudentSave(Model model,Student student) {
		studentService.updateByPrimaryKey(student);
		return "student/success";
	}
	
	//重定向一定要写绝对路径eg:redirect:/stu/list
	@RequestMapping("/delete/{id}")
	public String  delete(@PathVariable int id,Model model) {
		studentService.deleteByPrimaryKey(id);
		return "redirect:/stu/list";
	}
	
	@RequestMapping("/deletes")
	public String  deletes(@RequestParam("id") int[] ids,Model model,RedirectAttributes redirectAttributes) {
		int rows=0;
		rows=studentService.multiDelete(ids);
		if(rows>0){
			redirectAttributes.addFlashAttribute("message", "成功删除！");
		}else{
			redirectAttributes.addFlashAttribute("message", "删除shibai！");
		}
		return "redirect:/stu/list";
	}
	
	//
	@RequestMapping("/add")
	public String add(Model model) {
		List<Classes> clist=classesService.getAllClasses();
		model.addAttribute("clist", clist);
		model.addAttribute("entity", new Student());
		return "student/add";
	}
	
	//
	@RequestMapping("/addSave")
	public String addSave(Model model,@ModelAttribute("entity") @Valid Student entity,BindingResult bindingResult,RedirectAttributes redirectAttributes) {
		if(bindingResult.hasErrors()){
			 model.addAttribute("entity", entity);
			 List<Classes> clist=classesService.getAllClasses();
			 model.addAttribute("clist", clist);
			 //redirectAttributes.addFlashAttribute("entity", arg1)
             return "student/add";
			 //return "redirect:/add";
		}else{
			List<Classes> clist=classesService.getAllClasses();
			model.addAttribute("clist", clist);
			model.addAttribute("entity", new Student());
			entity.setUsertype(2);
			studentService.insert(entity);
			return "redirect:/stu/list";
		}
		
	}
	
	//edit/${entity.id}
	@RequestMapping("/edit/{id}")
	public String add(Model model,@PathVariable int id) {
		List<Classes> clist=classesService.getAllClasses();
		model.addAttribute("clist", clist);
		model.addAttribute("entity", studentService.selectByPrimaryKey(id));
		return "student/edit";
	}
	
	//
	@RequestMapping("/editSave")
	public String editSave(Model model,Student student) {
		studentService.updateByPrimaryKey(student);
		return "redirect:/stu/list";
	}
	/*
	 * 选课功能
	 * */
	@RequestMapping("/getXuXiu")
	public String getXuXiu(Model model,HttpServletRequest req){
		HttpSession session=req.getSession();
		Student student=(Student) session.getAttribute("user");
		List<CourseExt> clist= studentService.getXuxiu(student.getClassid());
		model.addAttribute("colist", clist);
		return "student/colist";
	}
	/*
	 * 选课提交功能
	 * */
	@RequestMapping(value="/semycou",produces="text/html;charset=utf8")
	@ResponseBody
	public String semycou(@RequestParam("cou") String[] ct,HttpServletRequest req){
		System.out.println("String[] ct:"+ct);
		HttpSession session=req.getSession();
		Student student=(Student) session.getAttribute("user");
		List<Sc> sclist=new ArrayList<Sc>();
		for(int i=0;i<ct.length;i++){
			Sc sc=new Sc();
			String cteveryone=ct[i];
			String[] ctarray=cteveryone.split("_");
			sc.setCid(Integer.parseInt(ctarray[0]));
			sc.setTid(Integer.parseInt(ctarray[1]));
			sc.setSid(student.getId());
			sclist.add(sc);
		}
		String msg="";
		try{
			studentService.inserBatch(sclist);
			msg="选课成功！";
		}catch(Exception e){
			msg="选课可能有重复，请审核后重试！";
		}
		return msg;
	}
	
	/*
	 * 查看课表功能
	 * */
	@RequestMapping("/getStuCourse")
	public String getStuCourse(Model model,HttpServletRequest req){
		HttpSession session=req.getSession();
		Student student=(Student) session.getAttribute("user");
		int id=student.getClassid();
		int ids=student.getId();
		List<CourseExt> ctlist=studentService.getMycourses(id,ids );
		model.addAttribute("ctlist", ctlist);
		return "student/cslist";
	}
	@RequestMapping("/getStuDetail")
	public String getStuDetail(Model model,Integer id){
		Student student = studentService.selectByPrimaryKey(id);
		model.addAttribute("u", student);
		return "student/test";
		
	}
	
	/*
	 * 学生id从grade成绩表进行查询显示即可.
	 * */
	@RequestMapping("/getStuGrade")
	public String getStuGrade(Model model,HttpServletRequest req,Integer id){
		List<Map<String, Object>> listMap = studentService.getStuGrade(id);
		model.addAttribute("listMap", listMap);
		return "student/gradelist";
	}
	
	
}
