package co.edu.ue.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ICourseDao;
import co.edu.ue.entity.Course;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	ICourseDao dao;
	
	//final int IVA_19= 19;

	@Override
	public List<Course> listAllCourses() {		
		return dao.listCourses();
	}

	@Override
	public List<Course> listAllCoursesIVA() {
		/*return dao.listCourses().stream().map(
				c->{
					//casteo de double a long
					
					int value = (c.getCouPrice()+ (Math.multiplyExact(c.getCouPrice()) * 19));
					Course course = new Course(c.getName(), c.getDescripcion(), 
							c.getDuration(), value);
					return course;
				}).collect(Collectors.toList());*/
		return null;
	}

	@Override
	public Course searchByIdCourse(int id) {		
		return dao.searchById(id);
	}

	@Override
	public boolean postByCourse(Course course) {		
		return dao.postCourse(course);
	}

}
