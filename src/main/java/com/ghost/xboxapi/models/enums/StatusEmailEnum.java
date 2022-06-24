package com.ghost.xboxapi.models.enums;

public enum StatusEmailEnum {
    WAITING(1, "WAITING"),
    PROCESSING(2,"PROCESSING"),
    SENT(3,"SENT"),
    ERROR(4,"ERROR");

    private final Integer id;
    private final String status;

    private StatusEmailEnum(Integer id, String status) {
        this.id = id;
        this.status = status;
    }
    public Integer getId() {
        return id;
    }

    public String getstatus() {
        return status;
    }
}
