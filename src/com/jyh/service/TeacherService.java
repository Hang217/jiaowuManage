package com.yu.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yu.pojo.Classes;
import com.yu.pojo.Grade;
import com.yu.pojo.Student;
import com.yu.pojo.StudentView;
import com.yu.pojo.Teacher;


public interface TeacherService {

	public List<Teacher> getTeacherPager(int pageNO, int size);

	public Teacher getTeacherId(int id);

	public int getTeacherCount();

	public int insert(Teacher entity);

	public int delete(int id);

	public int update(Teacher entity);

	int deletes(int[] ids);
	
	public List<Teacher> getAllTeacher();

	public int getMyStuCount(int id);
	
	public Teacher loginTea(Teacher tea);
	
	public List<StudentView> getMystus(int tid);
	
	int insertGrade(Grade grade);

	public List<Map<String, Object>> getCouById(Integer id);

	public int selectById(int id);
	
}
