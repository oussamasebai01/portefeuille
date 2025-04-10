package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.spring.entities.Action;

public interface ActionRepository extends JpaRepository<Action,Integer> {
    Action findBySymbole(String symbole);
}
