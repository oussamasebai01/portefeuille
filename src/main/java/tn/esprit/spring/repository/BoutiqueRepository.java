package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Boutique;

@Repository
public interface BoutiqueRepository extends JpaRepository<Boutique,Long> {
}
