package com.yu.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yu.mapper.GradeMapper;
import com.yu.mapper.TeacherMapper;
import com.yu.pojo.Classes;
import com.yu.pojo.Grade;
import com.yu.pojo.Student;
import com.yu.pojo.StudentView;
import com.yu.pojo.Teacher;
import com.yu.service.ClassesService;
import com.yu.service.TeacherService;

/**
 */
@Service
public class TeacherServiceImpl implements TeacherService{

	 //自动装配
    @Resource
    TeacherMapper teacherMapper;
    @Resource
    GradeMapper gradeMapper;

	@Override
	public int deletes(int[] ids) {
		int rows=0;
        for (int id : ids) {
            rows+=delete(id);
        }
     return rows;
	}

	/*
	 * @see com.offcn.service.TeacherService#getTeacherPager(int, int)
	 */
	@Override
	public List<Teacher> getTeacherPager(int pageNO, int size) {
		int skip=(pageNO-1)*size;
		return teacherMapper.getTeacherPager(skip, size);
	}

	/*
	 * @see com.offcn.service.TeacherService#getTeacherId(int)
	 */
	@Override
	public Teacher getTeacherId(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.getTeacherId(id);
	}

	/*
	 * @see com.offcn.service.TeacherService#getTeacherCount()
	 */
	@Override
	public int getTeacherCount() {
		// TODO Auto-generated method stub
		return teacherMapper.getTeacherCount();
	}

	/*
	 * @see com.offcn.service.TeacherService#insert(com.offcn.pojo.Teacher)
	 */
	@Override
	public int insert(Teacher entity) {
		// TODO Auto-generated method stub
		return teacherMapper.insert(entity);
	}

	/*
	 * @see com.offcn.service.TeacherService#delete(int)
	 */
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return teacherMapper.delete(id);
	}

	/*
	 * @see com.offcn.service.TeacherService#update(com.offcn.pojo.Teacher)
	 */
	@Override
	public int update(Teacher entity) {
		// TODO Auto-generated method stub
		return teacherMapper.update(entity);
	}

	/*
	 * @see com.offcn.service.TeacherService#getAllTeache()
	 */
	@Override
	public List<Teacher> getAllTeacher() {
		// TODO Auto-generated method stub
		return teacherMapper.getAllTeacher();
	}


	/*
	 * @see com.offcn.service.TeacherService#loginTea(com.offcn.pojo.Teacher)
	 */
	@Override
	public Teacher loginTea(Teacher tea) {
		// TODO Auto-generated method stub
		return teacherMapper.tealogin(tea);
	}

	@Override
	public int getMyStuCount(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<StudentView> getMystus(int tid) {
		// TODO Auto-generated method stub
		List<StudentView> xxslist=teacherMapper.getxxStudent(tid);
		List<StudentView> bxslist=teacherMapper.getbxStudent(tid);
		List<StudentView> slist=new ArrayList<StudentView>();
		slist.addAll(xxslist);
		slist.addAll(bxslist);
		return slist;
	}

	@Override
	public int insertGrade(Grade grade) {
		// TODO Auto-generated method stub
		return gradeMapper.insertGrade(grade);
	}

	@Override
	public List<Map<String, Object>> getCouById(Integer id) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> coulist=teacherMapper.getCouById(id);
		return coulist;
	}

	@Override
	public int selectById(int id) {
		// TODO Auto-generated method stub
		return gradeMapper.selectById(id);
	}

	
    
   
}
