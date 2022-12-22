package tn.zitouna.zitouna.entites;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    private Float maxMontantFinancement;
    private Float minMontantFinancement;
    private int dureeMax;
    private int dureeMin;
    private Float minApportPropre;
    private Float tauxFrais;
    private Float MaxFraisDossier;
    private Float MinFraisDossier;
    @ManyToMany
    private List<Tarifs> tarifs;

}
