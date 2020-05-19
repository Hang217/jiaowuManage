package com.yu.service;

import java.util.List;
import java.util.Map;

import com.yu.pojo.CourseExt;
import com.yu.pojo.Grade;
import com.yu.pojo.Sc;
import com.yu.pojo.Student;
import com.yu.pojo.StudentExt;

public interface StudentService {
	List<Student> getStudentPager(int pageNO, int size);
	int getCount();
	int deleteByPrimaryKey(Integer id);//删除
	int multiDelete(int[] ids);
	int insert(Student record);
	Student selectByPrimaryKey(Integer id);
	int updateByPrimaryKey(Student record);
	public List<StudentExt> getStuByCid(int id);
	
	public Student stulogin(Student student);
	
	List<CourseExt> getXuxiu(int classid); 
	
	int inserBatch(List<Sc> sclist);
	 
	List<CourseExt> getMycourses(int classid,int stuid);
	List<Map<String, Object>> getStuGrade(Integer id);
	
	/*public Student getMyInfo(int id);
    //public void updatePwd(Login login);
    public int getMyCoursesCount(int id);
    public List<Student> getMyCourses(int id,int pageNum,int size,String type);
    public List<Grade> getGrade(int id);*/
	
}
