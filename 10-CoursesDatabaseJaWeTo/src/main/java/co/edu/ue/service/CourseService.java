package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.ICourseDao;
import co.edu.ue.entity.Curse;

@Service
public class CourseService implements ICourseService {
	
	@Autowired
	ICourseDao dao;
	
	final float IVA_19=19;
	
	
	@Override
	public List<Curse> listAllCourses() {
		return dao.listCourses();
	}

	/*@Override
	public List<Curse> listAllCoursesIVA() {
			return dao.listCourses().stream().map(
					c->{
						//Casteo de double a Long
						long value = (long)(c.getCouPrice() + (c.getCouPrice() * IVA_19));
						Course course = new Course(c.getName(), c.getDescription(),c.getDuration(),value);
						return course;
					}).collect(Collectors.toList());
		}
		return null;
	}*/

	@Override
	public Curse searchByIdCourse(int id) {
		return dao.searchById(id);
	}

	@Override
	public boolean postByCurse(Curse course) {
		return dao.postCurse(course);
	}

	@Override
	public List<Curse> listAllCoursesIVA() {
		// TODO Auto-generated method stub
		return null;
	}

}
