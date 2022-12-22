package tn.zitouna.zitouna.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.zitouna.zitouna.Repositories.ProduitRepository;
import tn.zitouna.zitouna.entites.Produit;

import java.util.List;

@Service
public class ProduitService implements IProduitService {
    @Autowired
    private ProduitRepository produitRepository;
    @Override
    public Produit addProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id).get();
    }

    @Override
    public List<Produit> getProduits() {
        return produitRepository.findAll();
    }

    @Override
    public float getMontantFinancement( float apportPropre, float prix) {
        float montantFinancement = prix - apportPropre;
        return montantFinancement;
    }

    @Override
    public float getReboursementMensuel( int duree, float apportPropre, float prix) {
        float montantFinancement = prix - apportPropre;
        return montantFinancement / (duree*12);

    }

    @Override
    public float getpourcentageReboursementMensuel( float revenu,float apportPropre, float prix,int duree) {
        float montantFinancement = prix - apportPropre;
        float remboursementMensuel = montantFinancement / (duree*12);
        return (remboursementMensuel / revenu) * 100;
    }

    @Override
    public float getMontantFraisDossier(float apportPropre,float prix) {
        float montantFinancement = prix - apportPropre;
        return montantFinancement * 0.01f;
    }
}
