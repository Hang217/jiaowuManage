package com.yu.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yu.pojo.CourseExt;
import com.yu.pojo.Student;
import com.yu.pojo.StudentExt;

public interface StudentMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Student record);
    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Student record);
    int updateByPrimaryKey(Student record);
    List<Student> getStudentPager(@Param("skip") int skip,@Param("size") int size);
    int getCount();
    public List<Map<String, Object>> getStuGrade(Integer id);
    public List<StudentExt> getStuByCid(int id);
    public Student stulogin(Student student);
    List<CourseExt> getXuxiu(int classid);
    
    List<CourseExt> getBxCourse(Map m);
    List<CourseExt> getxxCourse(int stuid);
    
}