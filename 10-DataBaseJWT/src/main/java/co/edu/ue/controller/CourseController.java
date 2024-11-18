package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Course;
import co.edu.ue.service.ICourseService;

@RestController
@RequestMapping("api-courses")
public class CourseController {

	@Autowired
	ICourseService service;
	
	@GetMapping(value="courses-all")
	public ResponseEntity<List<Course>> getAllCourses(){
		List<Course> list = service.listAllCourses();
		//1.Agregar al header nuevos datos
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		toString();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		//2.Armamos la respuesta de tipo ResponsiveEntity
		return new ResponseEntity<List<Course>>(list, headers,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value="course-id")
	public ResponseEntity<Course> getByIdCourse(@RequestParam("id") int id) {
		return new ResponseEntity<Course>(service.searchByIdCourse(id),HttpStatus.OK) ;
	}
	
	@PostMapping(value="course", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> postCourse(@RequestBody Course course) {
		if(service.postByCourse(course)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT) ;
	}
	
	
}
