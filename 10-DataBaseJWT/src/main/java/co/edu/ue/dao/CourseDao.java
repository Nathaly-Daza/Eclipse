package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Course;
import co.edu.ue.jpa.ICourseJpa;

@Repository
public class CourseDao implements ICourseDao {
	
	@Autowired
	ICourseJpa jpa;

	@Override
	public List<Course> listCourses() {
		// TODO Auto-generated method stub
		return jpa.findAll();
	}

	@Override
	public Course searchById(int id) {
		// TODO Auto-generated method stub
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postCourse(Course course) {
		if(!jpa.save(course).equals(null)) return true;
		return false;
	}
	
	
	
}
