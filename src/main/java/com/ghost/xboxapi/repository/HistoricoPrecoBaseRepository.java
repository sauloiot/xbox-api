package com.ghost.xboxapi.repository;

import com.ghost.xboxapi.models.HistoricoPrecoBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoPrecoBaseRepository extends JpaRepository<HistoricoPrecoBase, Long> {
    
}
