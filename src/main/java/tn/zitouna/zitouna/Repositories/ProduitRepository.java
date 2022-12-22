package tn.zitouna.zitouna.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.zitouna.zitouna.entites.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}

