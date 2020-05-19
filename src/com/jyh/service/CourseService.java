package com.yu.service;

import java.util.List;
import java.util.Map;

import com.yu.pojo.Course;
import com.yu.pojo.CtcKey;


public interface CourseService {

	public List<Course> getCoursePager(int pageNO, int size);

	public Course getCourseId(int id);

	public int getCourseCount();

	public int insert(Course entity);

	public int delete(int id);

	public int update(Course entity);

	int deletes(int[] ids);
	
	void  insertBatch(List<CtcKey> ctclist);

	public List<Map<String, Object>> getCouByName(String couName);

	public void setCoure(Course c);
	
	//public List<CourseExt> getMyCourse(int id);

}
