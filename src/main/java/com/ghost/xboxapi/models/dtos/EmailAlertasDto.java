package com.ghost.xboxapi.models.dtos;

import com.ghost.xboxapi.models.Alerta;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class EmailAlertasDto {

    private String ownerRef;

    private String emailTo;

    private List<Alerta> alertas = new ArrayList<>();

    private Date data;
}
