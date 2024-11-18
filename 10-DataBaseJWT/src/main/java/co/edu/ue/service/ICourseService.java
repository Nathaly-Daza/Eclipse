package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Course;

public interface ICourseService {

	
	List<Course> listAllCourses();
	Course searchByIdCourse(int id);
	
	boolean postByCourse(Course course);
	//List<Course> listAllCoursesIVA();
}
