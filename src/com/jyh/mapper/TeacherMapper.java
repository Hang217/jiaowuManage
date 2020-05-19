package com.yu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yu.pojo.StudentView;
import com.yu.pojo.Teacher;

public interface TeacherMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);


    Teacher selectByPrimaryKey(Integer id);


    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    
    public List<Teacher> getTeacherPager(@Param("skip") int skip, @Param("size") int size);

	public Teacher getTeacherId(int id);

	public int getTeacherCount();

	public int delete(int id);

	public int update(Teacher entity);
	
	public List<Teacher> getAllTeacher();
	
	public Teacher loginTea(Teacher tea);
	
	public Teacher tealogin(Teacher teacher);
	
	List<StudentView> getxxStudent(int tid);
	
	List<StudentView> getbxStudent(int tid);

	List<Map<String, Object>> getCouById(Integer id);
	
    
}