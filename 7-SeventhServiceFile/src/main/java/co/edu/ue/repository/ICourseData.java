package co.edu.ue.repository;

import java.util.List;
import co.edu.ue.model.Course;

public interface ICourseData {
	List<Course> getDataCourses();
	Course getCourseName(String name);
	List<Course> deleteCourses (String name);
	List<Course> postCourse (Course course);
}
