package tn.esprit.spring.serviceInterface;

import tn.esprit.spring.entities.Action;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Ordre;
import tn.esprit.spring.entities.Protefeuille;

import java.time.LocalDate;
import java.util.List;

public interface IBoutiqueSrvice {
    void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre);

    List<Action> addActions(List<Action> actionList);
    Protefeuille addPortefeuille(Protefeuille p);

    Ordre addOrderAndAffectToActionAndPortfeuille(Ordre ordre, String symbole , Integer reference);
    List<String>listSymbolesActionPar(Integer ref , LocalDate startdate, LocalDate endDate);
}
