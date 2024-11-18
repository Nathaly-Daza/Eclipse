package co.edu.ue.service;

//import java.math.BigDecimal;
import java.util.List;
//import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ICourseDao;
import co.edu.ue.entity.Course;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	ICourseDao dao; 
	final float IVA_19 = 19;

	@Override
	public List<Course> listAllCourses() {
		// TODO Auto-generated method stub
		return dao.listCourses();
	}

	@Override
	public Course searchByIdCourse(int id) {
		// TODO Auto-generated method stub
		return dao.searchById(id);
	}

	@Override
	public boolean postByCourse(Course course) {
		// TODO Auto-generated method stub
		return dao.postCourse(course);
	}

	//@Override
	/*public List<Course> listAllCoursesIVA() {
		return dao.listCourses().stream().map(
				c->{
					BigDecimal value = (c.getCou_price() + (c.getCou_price() *  19)); 
					Course course = new Course(c.getId(), c.getName(), value);
					return course;
				}
				).collect(Collectors.toList());
	}
	*/ //Tarea para resolver

}
