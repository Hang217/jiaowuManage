package com.yu.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yu.pojo.CourseExt;
import com.yu.pojo.Grade;
import com.yu.pojo.Student;
import com.yu.pojo.StudentView;
import com.yu.pojo.Teacher;
import com.yu.service.CourseService;
import com.yu.service.TeacherService;

@Controller
@RequestMapping("/tea")
public class TeacherController {
	@Resource
    TeacherService teacherService;
	@Resource
	CourseService courseService;
	
	/*
	 * 教师查看课表功能
	 * */
	@RequestMapping("/getTeaCourse")
	public String getTeaCourse(Model model,HttpServletRequest req,Integer id){
//		HttpSession session=req.getSession();
//		Teacher teacher=(Teacher) session.getAttribute("user");
//		List<CourseExt> ctlist=teacherService.getMycourses( teacher.getId());
//		model.addAttribute("ctlist", ctlist);
		HttpSession session=req.getSession();
		Teacher teacher=(Teacher) session.getAttribute("user");
//		List<Map<String,Object>> coulist=courseService.getCouByName(couName);
		List<Map<String,Object>> coulist=teacherService.getCouById(id);
		model.addAttribute("coulist", coulist);
		return "student/cslist";
		
	}
	
	   @RequestMapping("/listCourse")
	    public String listCourse(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
	        int size=10;
	        model.addAttribute("size",size);
	        model.addAttribute("pageNO",pageNO);
	        model.addAttribute("count",courseService.getCourseCount());
	        
	        model.addAttribute("coulist", courseService.getCoursePager(pageNO, size));
	        return "teacher/listCourse";
	     }


	 /*
     * 学生列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=10;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",teacherService.getTeacherCount());
        
        model.addAttribute("tealist", teacherService.getTeacherPager(pageNO, size));
        return "teacher/list";
     }


    /*
     * 删除单个学生对象Action
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
       System.out.println("删除老师id："+id);
      int i= teacherService.selectById(id);
      System.out.println("查看有老师的成绩记录："+i);
      if(i==0){
    	  if(teacherService.delete(id)>0)
          {
              redirectAttributes.addFlashAttribute("message", "删除成功！");
          }else{
              redirectAttributes.addFlashAttribute("message", "删除失败！");
          }
      }
      redirectAttributes.addFlashAttribute("message", "不能删除！");
    	
        return "redirect:/tea/list?pageNO="+pageNO;
    }
    
    /*
     * 删除多个学生对象Action
     */
    @RequestMapping("/deletes")
    public String deletes(Model model,@RequestParam int[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
    	System.out.println("批量删除"+id.toString());
        int rows=teacherService.deletes(id);
        if(rows>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除"+rows+"行记录成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/tea/list?pageNO="+pageNO;
    }
    
    /*
     * 添加
     */
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("entity", new Teacher());
        return "teacher/add";
    }
    
    /*
     * 添加保存
     */
    @RequestMapping("/addSave")
    public String addSave(Model model,@ModelAttribute("entity") @Valid Teacher entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "teacher/add";
           
        }else{
        	
        	entity.setUsertype(3);
        	teacherService.insert(entity);
             return "redirect:/tea/list";    
             
        }
    }
    
    /*
     * 编辑个人信息
     */
    @RequestMapping("/editTeacher")
    public String editTeacher(Model model,Integer id){
        model.addAttribute("entity", teacherService.getTeacherId(id));
        return "teacher/editTeacher";
    }
    
    /*
     * 保存个人信息成功
     */
    @RequestMapping("/editTeacherSave")
    public String editTeacherSave(Model model,@ModelAttribute("entity") @Valid Teacher entity,BindingResult bindingResult){
        
    	
    	//如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/teacher/edit";
            
        }else{
        	//entity.setPassword("aaaaaa");
        	teacherService.update(entity);
            return "student/success";    
            
        }
       
    }
    
    /*
     * 编辑
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("entity", teacherService.getTeacherId(id));
        return "teacher/edit";
    }
    
    /*
     * 保存
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("entity") @Valid Teacher entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/teacher/edit";
            
        }else{
        	//entity.setPassword("aaaaaa");
        	System.out.println("--entity--"+entity.getLoginname());
        	System.out.println("--entity--"+entity.getId());
        	teacherService.update(entity);
            return "redirect:list";    
            
        }
       
    }
    
   //
    @RequestMapping("getMyStu")
    public String getMyStu(Model model,HttpServletRequest req){
    	HttpSession session=req.getSession();
    	Teacher teacher=(Teacher) session.getAttribute("user");
        List<StudentView> slist=teacherService.getMystus(teacher.getId());
        System.out.println("--teacher.getId()--"+teacher.getId());
        model.addAttribute("stulist", slist);
    	return "teacher/couOftea/stulist";
    }
    
    //
    @RequestMapping("setGrades/{sid}/{sname}/{cid}")
    public String setGrades(Model model,@PathVariable int sid,@PathVariable String sname,@PathVariable int cid){
    	Grade grade=new Grade();
    	grade.setSid(sid);
    	grade.setCid(cid);
    	model.addAttribute("entity", grade);
    	model.addAttribute("sname", sname);
    	return "teacher/couOftea/setgrade";
    }
    
    @RequestMapping("/saveGrade")
    public String setGrades(Model model,Grade entity,HttpServletRequest req,RedirectAttributes redirectAttributes){
    	HttpSession session=req.getSession();
    	Teacher teacher=(Teacher) session.getAttribute("user");
    	entity.setZgrade(entity.getPgrade()+entity.getKgrade());
    	entity.setTid(teacher.getId());
    	int rows=teacherService.insertGrade(entity);
    	if(rows>0){
    		redirectAttributes.addFlashAttribute("msg", "录入成功！");
    	}else{
    		redirectAttributes.addFlashAttribute("msg", "录入失败！");
    	}
    	return "redirect:getMyStu";
    }
    @RequestMapping("/getTeaDetail")
     public String getTeaDetail(Model model,Integer id){
    	Teacher teacher = teacherService.getTeacherId(id);
    	model.addAttribute("u", teacher);
    	 return "teacher/test";
     }
    
    
}
