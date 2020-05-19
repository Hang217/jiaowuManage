package com.yu.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yu.mapper.CourseMapper;
import com.yu.mapper.CtcMapper;
import com.yu.pojo.Course;
import com.yu.pojo.CtcKey;
import com.yu.service.CourseService;
/**
 */
@Service
public class CourseServiceImpl implements CourseService{

	 //自动装配
    @Resource
    CourseMapper courseMapper;
    @Resource
    CtcMapper ctcMapper;

	/*
	 * @see com.offcn.service.ClassesService#deletes(int[])
	 */
	@Override
	public int deletes(int[] ids) {
		int rows=0;
        for (int id : ids) {
            rows+=delete(id);
        }
     return rows;
	}

	/*
	 * @see com.offcn.service.CourseService#getCoursePager(int, int)
	 */
	@Override
	public List<Course> getCoursePager(int pageNO, int size) {
		int skip=(pageNO-1)*size;
		return courseMapper.getCoursePager(skip, size);
	}

	/*
	 * @see com.offcn.service.CourseService#getCourseId(int)
	 */
	@Override
	public Course getCourseId(int id) {
		// TODO Auto-generated method stub
		return courseMapper.getCourseId(id);
	}

	/*
	 * @see com.offcn.service.CourseService#getCourseCount()
	 */
	@Override
	public int getCourseCount() {
		// TODO Auto-generated method stub
		return courseMapper.getCourseCount();
	}

	/*
	 * @see com.offcn.service.CourseService#insert(com.offcn.pojo.Course)
	 */
	@Override
	public int insert(Course entity) {
		// TODO Auto-generated method stub
		return courseMapper.insert(entity);
	}

	/*
	 * @see com.offcn.service.CourseService#delete(int)
	 */
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return courseMapper.delete(id);
	}

	/*
	 * @see com.offcn.service.CourseService#update(com.offcn.pojo.Course)
	 */
	@Override
	public int update(Course entity) {
		// TODO Auto-generated method stub
		return courseMapper.update(entity);
	}

	@Override
	public void insertBatch(List<CtcKey> ctclist) {
		// TODO Auto-generated method stub
		ctcMapper.insertBatch(ctclist);
	}

	@Override
	public List<Map<String, Object>> getCouByName(String couName) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> coulist=courseMapper.getCouByName(couName);
		return coulist;
	}

	@Override
	public void setCoure(Course c) {
		// TODO Auto-generated method stub
		courseMapper.setCoure(c);
	}

	/*
	 * @see com.offcn.service.CourseService#getMyCourse(int)
	 */
	/*@Override
	public List<CourseExt> getMyCourse(int id) {
		// TODO Auto-generated method stub
		return courseMapper.getMyCourse(id);
	}*/

    
   
}
