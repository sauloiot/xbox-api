package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PIFilter{
    @JsonProperty("ExclusionProperties")
    public ArrayList<String> exclusionProperties;
    @JsonProperty("InclusionProperties") 
    public ArrayList<String> inclusionProperties;
}
