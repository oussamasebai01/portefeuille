package tn.esprit.spring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Ordre implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idOrdre;
    Integer volume;
    LocalDate dateCreation;
    LocalDate dateExecution;
    float montant;
    Status status;
    Type typeOrdre;

    @ManyToOne(cascade = CascadeType.PERSIST)
            @JsonIgnore
    Protefeuille protefeuille;

    @ManyToOne
            @JsonIgnore
    Action action;
}
