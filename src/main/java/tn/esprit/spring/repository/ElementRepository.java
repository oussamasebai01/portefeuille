package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.ElementPortefeuille;

public interface ElementRepository extends JpaRepository<ElementPortefeuille,Integer> {

}
