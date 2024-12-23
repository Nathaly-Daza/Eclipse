package co.edu.ue.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import co.edu.ue.model.Course;

public class CourseData {
	List<Course> dataCourses;
	
	public CourseData() {
		this.dataCourses = new ArrayList<Course>(Arrays.asList(
					new Course("JAVA", "CURSO BÁSICO JAVA", 40.5, 20),
					new Course("PYTHON", "CURSO BÁSICO PYTHON", 30.5, 25),
					new Course("C++", "CURSO BÁSICO C++", 23.5, 21.5)));
	}

	public List<Course> getDataCourses() {
		return dataCourses;
	}

	public Course getCourseName (String name) {
		return this.dataCourses.stream().filter
				(i->i.getName().equals(name)).findFirst().orElseThrow();
	}
	
	public List<Course> deleteCourses(String name){
		this.dataCourses.removeIf(c->c.getName().equals(name));
		return this.dataCourses;
	}
	
	public List<Course> postCourse (Course course){
		if(!course.equals(null)) this.dataCourses.add(course);
		return this.dataCourses;
	}
	
}
