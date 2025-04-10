package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Action;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.ElementPortefeuille;
import tn.esprit.spring.entities.Protefeuille;
import tn.esprit.spring.repository.ActionRepository;
import tn.esprit.spring.repository.BoutiqueRepository;
import tn.esprit.spring.repository.ElementRepository;
import tn.esprit.spring.repository.ProtefeuilleRepository;
import tn.esprit.spring.serviceInterface.IBoutiqueSrvice;

import java.util.List;

@Service
public class BoutiqueServiceImpl implements IBoutiqueSrvice {

    @Autowired
    BoutiqueRepository boutiqueRepository;

    @Autowired
    ActionRepository actionRepository;

    @Autowired
    ElementRepository elementRepository;


    @Autowired
    ProtefeuilleRepository protefeuilleRepository;

    @Override
    public void ajouterEtAffecterlisteBoutiques(List<Boutique> lb, Long idCentre) {
    for (Boutique b : lb)
    {

    }
    boutiqueRepository.saveAll(lb);
    }

    @Override
    public List<Action> addActions(List<Action> actionList) {
        return actionRepository.saveAll(actionList);
    }

    @Override
    public Protefeuille addPortefeuille(Protefeuille p) {
        Protefeuille savedProtefeuille = protefeuilleRepository.save(p);

        for (ElementPortefeuille e : savedProtefeuille.getElementPortefeuilles()) {
            e.setProtefeuille(savedProtefeuille);
        }

        elementRepository.saveAll(savedProtefeuille.getElementPortefeuilles());

        return savedProtefeuille;
    }}