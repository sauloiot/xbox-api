package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Attribute{
    @JsonProperty("Name")
    public String name;
    @JsonProperty("Minimum") 
    public int minimum;
    @JsonProperty("Maximum") 
    public int maximum;
    @JsonProperty("ApplicablePlatforms") 
    public ArrayList<String> applicablePlatforms;
    @JsonProperty("Group") 
    public Object group;
}
