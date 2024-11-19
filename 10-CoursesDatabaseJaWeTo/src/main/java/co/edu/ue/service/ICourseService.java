package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Curse;

public interface ICourseService {
	List<Curse> listAllCourses();
	List<Curse> listAllCoursesIVA();
	Curse searchByIdCourse(int id);
	boolean postByCurse(Curse course);
	
}
