package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlternateId{
    @JsonProperty("IdType")
    public String idType;
    @JsonProperty("Value") 
    public String value;
}
