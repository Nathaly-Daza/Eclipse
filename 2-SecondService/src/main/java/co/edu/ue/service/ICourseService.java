package co.edu.ue.service;

import java.util.List;

import co.edu.ue.model.Course;

public interface ICourseService {
	List<Course> getCourseDataNoIva();
	List<Course> getCourseDataIva19();
	List<Course> getCourseDataPromo();
	Course getCourseName (String name);
	List<Course> postCourseData(Course course);
	List<Course> deleteCourseData(String name);

}
