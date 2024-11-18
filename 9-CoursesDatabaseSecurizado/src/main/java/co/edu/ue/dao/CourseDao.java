package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Curse;
import co.edu.ue.jpa.ICourseJpa;

@Repository
public class CourseDao implements ICourseDao{
	@Autowired
	ICourseJpa jpa;

	@Override
	public List<Curse> listCourses() {
		return jpa.findAll();
	}

	@Override
	public Curse searchById(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public boolean postCurse(Curse course) {
		if (!jpa.save(course).equals(null))return true;
		return false;
	}

}
