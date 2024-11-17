package co.edu.ue.dao;

import java.util.List;
import co.edu.ue.entity.Curse;

public interface ICourseDao {
	List<Curse> listCourses();
	Curse searchById(int id);
	
	boolean postCurse(Curse course);
	
}
