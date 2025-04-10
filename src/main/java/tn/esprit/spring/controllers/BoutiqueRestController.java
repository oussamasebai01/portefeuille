package tn.esprit.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Action;
import tn.esprit.spring.entities.Boutique;
import tn.esprit.spring.entities.Ordre;
import tn.esprit.spring.entities.Protefeuille;
import tn.esprit.spring.serviceInterface.IBoutiqueSrvice;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/boutique")
public class BoutiqueRestController {

    @Autowired
    IBoutiqueSrvice boutiqueSrvice;

    @PostMapping("/add/{idCentre}")
    void ajouterEtAffecterlisteBoutiques(@RequestBody List<Boutique> lb,@PathVariable Long idCentre)
    {
        boutiqueSrvice.ajouterEtAffecterlisteBoutiques(lb,idCentre);
    }

    @PostMapping("/addAction")
    public List<Action> addActions(@RequestBody List<Action> actionList){
        return boutiqueSrvice.addActions(actionList);
    }

    @PostMapping("/addPortfeuille")
    public Protefeuille addPortefeuille(@RequestBody Protefeuille p) {
        return boutiqueSrvice.addPortefeuille(p);
    }

    @PostMapping("/addOrdre/{symbole}/{reference}")
    public Ordre addOrderAndAffectToActionAndPortfeuille(@RequestBody Ordre ordre,@PathVariable String symbole,@PathVariable Integer reference) {
            return boutiqueSrvice.addOrderAndAffectToActionAndPortfeuille(ordre,symbole,reference);
    }
    @GetMapping("/getall/{ref}/{startdate}/{endDate}")
    public List<String> listSymbolesActionPar(@PathVariable Integer ref, @PathVariable LocalDate startdate, @PathVariable LocalDate endDate) {
        return boutiqueSrvice.listSymbolesActionPar(ref,startdate,endDate);
    }
}
