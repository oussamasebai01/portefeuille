package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Protefeuille;

public interface ProtefeuilleRepository extends JpaRepository<Protefeuille,Integer> {
}
