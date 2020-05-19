package com.yu.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yu.mapper.ScMapper;
import com.yu.mapper.StudentMapper;
import com.yu.pojo.CourseExt;
import com.yu.pojo.Grade;
import com.yu.pojo.Sc;
import com.yu.pojo.Student;
import com.yu.pojo.StudentExt;
import com.yu.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Resource
	 StudentMapper studentMapper;
	@Resource
	 ScMapper  scMapper;
	
	@Override
	public List<Student> getStudentPager(int pageNO, int size) {
		// TODO Auto-generated method stub
		int skip=(pageNO-1)*size;
		return studentMapper.getStudentPager(skip, size);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return studentMapper.getCount();
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int multiDelete(int[] ids) {
		// TODO Auto-generated method stub
		int rows=0;
		for(int id:ids){
			rows+=deleteByPrimaryKey(id);
		}
		return rows;
	}

	@Override
	public int insert(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.insert(record);
	}

	@Override
	public Student selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		// TODO Auto-generated method stub
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<StudentExt> getStuByCid(int id) {
		// TODO Auto-generated method stub
		return studentMapper.getStuByCid(id);
	}

	@Override
	public Student stulogin(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.stulogin(student);
	}

	@Override
	public List<CourseExt> getXuxiu(int classid) {
		// TODO Auto-generated method stub
		return studentMapper.getXuxiu(classid);
	}

	@Override
	public int inserBatch(List<Sc> sclist) {
		// TODO Auto-generated method stub
		return scMapper.inserBatch(sclist);
	}

	@Override
	public List<CourseExt> getMycourses(int classid, int stuid) {
		// TODO Auto-generated method stub
		Map m=new HashMap();
		m.put("id", classid);
		m.put("ids", stuid);
		List<CourseExt> bxlist=studentMapper.getBxCourse(m);
		List<CourseExt> xxlist=studentMapper.getxxCourse(stuid);
		List<CourseExt> ctlist=new ArrayList<CourseExt>();
		ctlist.addAll(bxlist);
		ctlist.addAll(xxlist);
		return ctlist;
	}

	@Override
	public List<Map<String, Object>> getStuGrade(Integer id) {
		// TODO Auto-generated method stub
		List<Map<String,Object>> stuGrade = studentMapper.getStuGrade(id);
		
		return stuGrade;
	}
	
	/*@Override
	public Student getMyInfo(int id) {
		Student student = studentMapper.getMyInfo(id);
		return student;
	}

	@Override
	public void updatePwd(Login login) {
		sMapper.updatePwd(login);
	}
	
	@Override
	public int getMyCoursesCount(int id) {
		int i=studentMapper.getMyCoursesCount(id);
		return i;
	}

	@Override
	public List<Student> getMyCourses(int id, int pageNum, int size,String type) {
		int skip=(pageNum-1)*size;
		List<Student> stulist = studentMapper.getMyCourses(id, skip, size,type);
		return stulist;
	}

	@Override
	public List<Grade> getGrade(int id) {
		return studentMapper.getGrade(id);
	}*/
 
}
