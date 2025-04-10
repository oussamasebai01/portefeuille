package tn.esprit.spring.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Action implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idAction;
    float prixAchatActuel;
    float prixVenteActuel;
    Integer volume;
    LocalDate dateEmission;
    String symbole;

    @OneToMany(mappedBy = "action")
    List<Ordre> ordres;
}
