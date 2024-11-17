package co.edu.ue.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.model.Course;

@Repository
public class CourseData implements ICourseData{
	List<Course> dataCourses;
	
	public CourseData() {
		this.dataCourses = new ArrayList<Course>(Arrays.asList(
					new Course("JAVA", "CURSO BÁSICO JAVA", 40.5, 20),
					new Course("PYTHON", "CURSO BÁSICO PYTHON", 30.5, 25),
					new Course("C++", "CURSO BÁSICO C++", 23.5, 21.5)));
	}
	@Override
	public List<Course> getDataCourses() {
		return dataCourses;
	}

	@Override
	public Course getCourseName (String name) {
		return this.dataCourses.stream().filter
				(i->i.getName().equals(name)).findFirst().orElseThrow();
	}
	
	@Override
	public List<Course> deleteCourses(String name){
		this.dataCourses.removeIf(c->c.getName().equals(name));
		return this.dataCourses;
	}
	
	@Override
	public List<Course> postCourse (Course course){
		if(!course.equals(null)) this.dataCourses.add(course);
		return this.dataCourses;
	}
	
}
