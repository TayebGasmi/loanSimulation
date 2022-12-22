package tn.zitouna.zitouna.controllers;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.zitouna.zitouna.entites.Produit;
import tn.zitouna.zitouna.services.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
@CrossOrigin("*")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @PostMapping
    ResponseEntity<Produit> addProduit(@RequestBody Produit produit){
        try {
            Produit p=produitService.addProduit(produit);
            return new ResponseEntity<>(p, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping
    ResponseEntity<Produit> updateProduit(@RequestBody Produit produit){
        try {
            Produit p=produitService.updateProduit(produit);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Produit> deleteProduit(@PathVariable("id") Long id){
        try {
            produitService.deleteProduit(id);
            return new ResponseEntity<>(null, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/{id}")
    ResponseEntity<Produit> getProduit(@PathVariable("id") Long id){
        try {
            Produit p=produitService.getProduit(id);
            if(p==null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping
    ResponseEntity<List<Produit>> getProduits(){
        try {
            List<Produit> produits=produitService.getProduits();
            if(produits==null){
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(produits, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/montantFinancement/{apportPropre}/{prix}")
    ResponseEntity<Float> getMontantFinancement(@PathVariable("apportPropre") float apportPropre,@PathVariable("prix") float prix){
        try {
            float montantFinancement=produitService.getMontantFinancement(apportPropre,prix);
            return new ResponseEntity<>(montantFinancement, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/reboursementMensuel/{duree}/{apportPropre}/{prix}")
    ResponseEntity<Float> getReboursementMensuel(@PathVariable("duree") int duree,@PathVariable("apportPropre") float apportPropre,@PathVariable("prix") float prix){
        try {
            float reboursementMensuel=produitService.getReboursementMensuel(duree,apportPropre,prix);
            return new ResponseEntity<>(reboursementMensuel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/pourcentageReboursementMensuel/{revenu}/{apportPropre}/{prix}/{duree}")
    ResponseEntity<Float> getpourcentageReboursementMensuel(@PathVariable("revenu") float revenu,@PathVariable("apportPropre") float apportPropre,@PathVariable("prix") float prix,@PathVariable("duree") int duree){
        try {
            float pourcentageReboursementMensuel=produitService.getpourcentageReboursementMensuel(revenu,apportPropre,prix,duree);
            return new ResponseEntity<>(pourcentageReboursementMensuel, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/fraisDossier//{apportPropre}/{prix}/")
    ResponseEntity<Float> getFraisDossier(@PathVariable("apportPropre") float apportPropre,@PathVariable("prix") float prix){
        try {
            float fraisDossier=produitService.getMontantFraisDossier(apportPropre,prix);
            return new ResponseEntity<>(fraisDossier, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
