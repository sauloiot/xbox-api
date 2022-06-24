package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Conditions{
    @JsonProperty("ClientConditions")
    public ClientConditions clientConditions;
    @JsonProperty("EndDate") 
    public Date endDate;
    @JsonProperty("ResourceSetIds") 
    public ArrayList<String> resourceSetIds;
    @JsonProperty("StartDate") 
    public Date startDate;
}
