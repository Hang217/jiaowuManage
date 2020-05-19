package com.yu.controller;

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

import com.yu.mapper.CtcMapper;
import com.yu.pojo.Classes;
import com.yu.pojo.Course;
import com.yu.pojo.CourseExt;
import com.yu.pojo.CtcKey;
import com.yu.pojo.Student;
import com.yu.pojo.Teacher;
import com.yu.service.ClassesService;
import com.yu.service.CourseService;
import com.yu.service.StudentService;
import com.yu.service.TeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 */
@Controller
@RequestMapping("/cou")
public class CourseController {
	@Resource
    CourseService courseService;
	@Resource
	TeacherService teacherService; 
	@Resource
	ClassesService classesService;
	
	
	
   /* @Resource
	CtcService ctcService;*/
    /* @Resource
     GradeService gradeService;*/
	/*
	 * 根据课程名查询课表
	 * */
	
	    @RequestMapping("/getCouByName")
	    public String getCouByName(Model model,String couName,HttpServletRequest req){
//	    	HttpSession session=req.getSession();
//			Student student=(Student) session.getAttribute("user");
			List<Map<String,Object>> coulist=courseService.getCouByName(couName);
			model.addAttribute("coulist", coulist);
			return "student/cslist";
	        
	     }
	    
	    /*
		 * 课程审核
		 * */
		
		    @RequestMapping("/setCoure")
		    public String setCoure(Model model,Integer id,Course c,HttpServletRequest req){
//		    	HttpSession session=req.getSession();
//				Student student=(Student) session.getAttribute("user");
				c.setId(id);
				c.setShenhe(1);
				courseService.setCoure(c);
			
				return "redirect:/cou/list";
		        
		     }
		    
	 /*
     * 列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=10;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",courseService.getCourseCount());
        
        model.addAttribute("coulist", courseService.getCoursePager(pageNO, size));
        return "course/list";
     }

    @RequestMapping("/listCourse")
    public String listCourse(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
    	System.out.println("--pageNO--"+pageNO);
        int size=10;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",courseService.getCourseCount());
        System.out.println("--count--"+courseService.getCourseCount());
        model.addAttribute("coulist", courseService.getCoursePager(pageNO, size));
        return "teacher/listCourse";
     }
    /*
     * 删除单个对象Action
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        if(courseService.delete(id)>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }
        return "redirect:/cou/list?pageNO="+pageNO;
    }
    
    /*
     * 删除多个对象Action
     */
    @RequestMapping("/deletes")
    public String deletes(Model model,@RequestParam int[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
    	System.out.println("批量删除"+id.toString());
        int rows=courseService.deletes(id);
        if(rows>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除"+rows+"行记录成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/cou/list?pageNO="+pageNO;
    }
    
    /*
     * 添加
     */
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("entity", new Course());
        return "course/add";
    }
    
    /*
     * 添加
     */
    @RequestMapping("/addCourse")
    public String addCourse(Model model){
        model.addAttribute("entity", new Course());
        return "teacher/addCourse";
    }
    
    /*
     * 添加保存
     */
    @RequestMapping("/addSave")
    public String addSave(Model model,@ModelAttribute("entity") @Valid Course entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "course/add";
           
        }else{
        	courseService.insert(entity);
             return "redirect:/cou/list";    
             
        }
    }

    /*
     * 添加保存
     */
    @RequestMapping("/addSaveCourse")
    public String addSaveCourse(Model model,@ModelAttribute("entity") @Valid Course entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "teacher/addCourse";
           
        }else{
        	courseService.insert(entity);
             return "redirect:/cou/listCourse";    
             
        }
    }

    /*
     * 编辑
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("entity", courseService.getCourseId(id));
        return "course/edit";
    }
    
    /*
     * 编辑
     */
    @RequestMapping("/editCourse/{id}")
    public String editCourse(Model model,@PathVariable int id){
        model.addAttribute("entity", courseService.getCourseId(id));
        return "teacher/editCourse";
    }
    
    /*
     * 编辑保存
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("entity") @Valid Course entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/course/edit";
            
        }else{
        	courseService.update(entity);
            
            return "redirect:list";    
            
        }
       
    }
    
    /*
     * 编辑保存
     */
    @RequestMapping("/editCourseSave")
    public String editCourseSave(Model model,@ModelAttribute("entity") @Valid Course entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/teacher/editCourse";
            
        }else{
        	courseService.update(entity);
            
            return "redirect:listCourse";    
            
        }
       
    }
    
    //排课
   @RequestMapping("/setTeacher/{id}")
    public String setTeacher(Model model,@PathVariable int id){
    	Course course=courseService.getCourseId(id);
    	model.addAttribute("entity",course);
    	List<Teacher> tlist=teacherService.getAllTeacher();
    	List<Classes> clist=classesService.getAllClasses();
    	model.addAttribute("tlist", tlist);
    	model.addAttribute("clist", clist);
    	return "course/setct";
    }
   /*
    * 管理员安排课程，教师，和班级
    * 排课功能
    * */
    @RequestMapping("editSavect")
    public String editSavect(Model model,@ModelAttribute("entity") Course entity,RedirectAttributes redirectAttributes){
    	//Course course=entity;
    	String classid=entity.getClasses();
    	String[] classids=classid.split(",");
    	List<CtcKey> ctclist=new ArrayList<CtcKey>();
    	for(int i=0;i<classids.length;i++){
    		CtcKey c=new CtcKey();
    		c.setCouid(entity.getId());
    		c.setClaid(Integer.parseInt(classids[i]));
    		c.setTid(entity.getTeacher().getId());
    		ctclist.add(c);
    	}
    	try{
    	  courseService.insertBatch(ctclist);
    	}catch(Exception e){
    		redirectAttributes.addFlashAttribute("msg", "排课存在冲突，请核对后重新选！");
    	}
    	return "redirect:/cou/list";
    }
    
}
