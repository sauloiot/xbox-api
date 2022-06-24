package com.ghost.xboxapi.repository;

import com.ghost.xboxapi.models.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    Jogo findByProductId(String productId);

    @Query("select j.productId from Jogo j")
    List<String> findAllProductId();
}
