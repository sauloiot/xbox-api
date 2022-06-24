package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplaySkuAvailability{
    @JsonProperty("Sku")
    public Sku sku;
    @JsonProperty("Availabilities") 
    public ArrayList<Availability> availabilities;
}
