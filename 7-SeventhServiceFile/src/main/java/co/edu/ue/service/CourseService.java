package co.edu.ue.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import co.edu.ue.model.Course;
import co.edu.ue.repository.CourseData;
import co.edu.ue.repository.ICourseData;

@Service
public class CourseService implements ICourseService {
	
//Traer la Data por instanciacion
	//private CourseData data = new CourseData();
	
	//Inyeccion por interface
	@Autowired
	ICourseData data;
	
	
	/*private final double IVA_19 = 0.19;
	private final double DESCUENTO = 1.5;*/

	@Value("${iva}")
	double IVA_19;
	@Value("${descuento}")
	double DESCUENTO;
	
	@Override
	public List<Course> getCourseDataNoIva() {
		return data.getDataCourses();
	}

	@Override
	public List<Course> getCourseDataIva19() {
		return data.getDataCourses().stream().map(
				c->{
					//Casteo de double a Long
					long value = (long)(c.getCost() + (c.getCost() * IVA_19));
					Course course = new Course(c.getName(), c.getDescription(),c.getDuration(),value);
					return course;
				}).collect(Collectors.toList());
	}

	@Override
	public List<Course> getCourseDataPromo() {
		return data.getDataCourses().stream().map(
				c->{
					//Casteo de double a Long
					long value = (long)(c.getCost() + (c.getCost() * IVA_19)- DESCUENTO);
					Course course = new Course(c.getName(), c.getDescription(),c.getDuration(),value);
					return course;
				}).collect(Collectors.toList());
	}

	@Override
	public Course getCourseName(String name) {
		// TODO Auto-generated method stub
		return data.getCourseName(name);
	}

	@Override
	public List<Course> postCourseData(Course course) {
		return data.postCourse(course);
	}

	@Override
	public List<Course> deleteCourseData(String name) {
		return data.deleteCourses(name);
	}

	
}
