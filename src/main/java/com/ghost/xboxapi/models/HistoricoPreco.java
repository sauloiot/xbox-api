package com.ghost.xboxapi.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "historico_preco")
public class HistoricoPreco implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double preco;
    private Date data;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private Jogo jogo;

}