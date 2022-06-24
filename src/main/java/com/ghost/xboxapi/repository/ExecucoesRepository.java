package com.ghost.xboxapi.repository;

import com.ghost.xboxapi.models.Execucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExecucoesRepository extends JpaRepository<Execucao, Long> {
}