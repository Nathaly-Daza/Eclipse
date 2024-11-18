package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Course;

public interface ICourseDao {

	List<Course> listCourses();
	Course searchById(int id);
	
	boolean postCourse(Course course);
	//terminar los demas metodos, actualizar y eliminar pero sin eliminar, agregar una columna de estado para inhabilitarla
	
}
