package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Ordre;

import java.util.List;

public interface OrdreRepository extends JpaRepository<Ordre,Integer> {
    List<Ordre> findByProtefeuilleReference(Integer ref);
}
