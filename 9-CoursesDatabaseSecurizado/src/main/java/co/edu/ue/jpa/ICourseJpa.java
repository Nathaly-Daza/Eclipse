package co.edu.ue.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ue.entity.Curse;

public interface ICourseJpa extends JpaRepository<Curse, Integer> {

}
