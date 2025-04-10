package tn.esprit.spring.serviceInterface;

import tn.esprit.spring.entities.Action;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Protefeuille;

import java.util.List;

public interface IBoutiqueSrvice {
    void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre);

    List<Action> addActions(List<Action> actionList);
    Protefeuille addPortefeuille(Protefeuille p);
}
