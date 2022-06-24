package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SkuDisplayRank{
    @JsonProperty("Dimension")
    public String dimension;
    @JsonProperty("Rank") 
    public int rank;
}
