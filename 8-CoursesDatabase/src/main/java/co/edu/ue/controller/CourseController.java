package co.edu.ue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.service.ICourseService;

@RestController
public class CourseController {
	@Autowired
	ICourseService service;
	
	//37:46

}
