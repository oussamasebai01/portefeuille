package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.*;
import tn.esprit.spring.repository.*;
import tn.esprit.spring.serviceInterface.IBoutiqueSrvice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    OrdreRepository ordreRepository;

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
    }

    @Override
    public Ordre addOrderAndAffectToActionAndPortfeuille(Ordre ordre, String symbole, Integer reference) {
        ordre.setStatus(Status.EN_ATTENTE);
        ordre.setDateCreation(LocalDate.now());
        if(ordre.getTypeOrdre()== Type.ACHAT)
            ordre.setMontant(actionRepository.findBySymbole(symbole).getPrixAchatActuel()*ordre.getVolume());
        else
            ordre.setMontant(actionRepository.findBySymbole(symbole).getPrixVenteActuel()*ordre.getVolume());

        ordre.setProtefeuille(protefeuilleRepository.findProtefeuilleByReference(reference));
        ordre.setAction(actionRepository.findBySymbole(symbole));
        return ordreRepository.save(ordre);
    }

    @Override
    public List<String> listSymbolesActionPar(Integer ref, LocalDate startdate, LocalDate endDate) {
        List<String> symbols= new ArrayList<>();
        List<Ordre> ordre = ordreRepository.findByProtefeuilleReference(ref);
        List<Action>action = new ArrayList<>();
        for (Ordre o : ordre ){
            if(o.getAction().getDateEmission().isAfter(startdate)&& o.getAction().getDateEmission().isBefore(endDate)){
                action.add(o.getAction());
            }
        }
        for (Action a : action ){
            symbols.add(a.getSymbole());
        }
        return symbols;
    }
}