package com.ghost.xboxapi.models.enums;

public enum TemplateHtmlEnum {
    LISTA_JOGOS("lista-jogos.html");

    private final String arquivo;

    private TemplateHtmlEnum(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getArquivo() {
        return arquivo;
    }
}
