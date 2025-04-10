package tn.esprit.spring.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Protefeuille implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPortfeuille;
    Integer reference;
    float solde;

    @OneToMany (mappedBy = "protefeuille")
    List<Ordre> ordres ;

    @OneToMany (mappedBy = "protefeuille")
    List<ElementPortefeuille> elementPortefeuilles;
}
