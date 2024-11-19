package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import co.edu.ue.entity.Curse;
import co.edu.ue.service.ICourseService;


@RestController
@RequestMapping("api-courses")
public class CourseController {
	@Autowired
	ICourseService service;
	/*@GetMapping(value="courses-all")
	public List<Curse> getAllCourses(@RequestParam String param) {
		return service.listAllCourses();
	}*/
	
	@GetMapping(value="courses-all")
	public ResponseEntity<List<Curse>>  getAllCourses() {
		List<Curse> list =service.listAllCourses();
		//1. Agregar al header nuevos datos
		int cantList = list.size();
		HttpHeaders headers = new HttpHeaders();
		headers.add("cant_elements", String.valueOf(cantList));
		headers.add("test", "hola");
		//2.Armamos la respuesta del tipo ResponseEntity 
		return new ResponseEntity<List<Curse>>(list, headers, HttpStatus.ACCEPTED) ;
	}
	
/*	@GetMapping (value="courses-id")
	public Curse getByIdCourse(@RequestParam("id") int id) {
		return service.searchByIdCourse(id);
	}*/
	
	@GetMapping (value="courses-id")
	public ResponseEntity<Curse>  getByIdCourse(@RequestParam("id") int id) {
		return new ResponseEntity<Curse>(service.searchByIdCourse(id),HttpStatus.OK);
	}
	
	
	/*@PostMapping (value="course")
	public Boolean postCourse(@RequestBody Curse course) {
		return service.postByCurse(course);
	}*/
	
	@PostMapping (value="course")
	public ResponseEntity<Void> postCourse(@RequestBody Curse course) {
		if (service.postByCurse(course)) {
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	}
	
	
}
