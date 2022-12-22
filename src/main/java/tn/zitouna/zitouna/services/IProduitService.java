package tn.zitouna.zitouna.services;

import tn.zitouna.zitouna.entites.Produit;

import java.util.List;

public interface IProduitService {
    Produit addProduit(Produit produit);
    Produit updateProduit(Produit produit);
    void deleteProduit(Long id);
    Produit getProduit(Long id);
    List<Produit> getProduits();
    float getMontantFinancement(float apportPropre,float prix);
    float getReboursementMensuel(int duree, float apportPropre, float prix);
    float getpourcentageReboursementMensuel(float revenu,float apportPropre, float prix,int duree);
    float getMontantFraisDossier(float apportPropre,float prix);

}
