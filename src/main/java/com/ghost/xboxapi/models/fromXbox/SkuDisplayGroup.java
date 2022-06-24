package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuDisplayGroup{
    @JsonProperty("Id")
    public String id;
    @JsonProperty("Treatment") 
    public String treatment;
}
