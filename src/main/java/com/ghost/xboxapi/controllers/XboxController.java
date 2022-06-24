package com.ghost.xboxapi.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ghost.xboxapi.models.dtos.JogoResumoDTO;
import com.ghost.xboxapi.models.fromXbox.Root;
import com.ghost.xboxapi.services.XboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/xbox")
public class XboxController {
    @Autowired
    private XboxService xboxService;

    @GetMapping(value = "/jogos/{id}")
    public ResponseEntity<Root> findById(@PathVariable String id) throws JsonProcessingException {
        Root obj = xboxService.getGames(id);
        return ResponseEntity.ok(obj);
    }

    @PutMapping(value = "/atualizar")
    public ResponseEntity<Void> atualizarLista() {
        xboxService.verificarJogosPreco();
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<List<JogoResumoDTO>> salvarIds(@RequestBody String productIds) {
        return ResponseEntity.ok(xboxService.saveJogosPorIdsProduto(productIds));
    }
}
