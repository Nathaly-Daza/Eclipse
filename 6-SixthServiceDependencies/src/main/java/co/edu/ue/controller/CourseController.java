
package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.model.Course;
import co.edu.ue.service.CourseService;
import co.edu.ue.service.ICourseService;

@RestController
@RequestMapping(value="api")
public class CourseController {
	//Atributos
	//private CourseService servicio = new CourseService();
	
	private CourseService servicio;
	//Inyección por constructor
	public CourseController(CourseService servicio) {
		
		this.servicio = servicio;
	}

	@GetMapping(value="courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getCourses(){
		return servicio.getCourseDataNoIva();
	}
	
	@GetMapping(value="coursespromo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getCoursesPromo(){
		return servicio.getCourseDataPromo();
	}
	
	@GetMapping(value="coursesiva", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> getCoursesIva(){
		return servicio.getCourseDataIva19();
	}
	
	// Método para agregar un curso nuevo
	@PostMapping(value="courses", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> postCourses(@RequestBody Course Course){
		return servicio.postCourseData(Course);
	}

	@GetMapping(value= "course-nombre", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Course getCourseName(@RequestParam String param) {
		return servicio.getCourseName(param);
	}
	
	
	// Método para eliminar un curso de la lista de cursos y retornar la lista de cursos
	@DeleteMapping(value= "course-nombre", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> delCourseName(@RequestParam String param) {
	    return servicio.deleteCourseData(param);
	}
}