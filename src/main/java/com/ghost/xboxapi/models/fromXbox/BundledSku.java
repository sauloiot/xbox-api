package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BundledSku{
    @JsonProperty("BigId")
    public String bigId;
    @JsonProperty("DisplayRank") 
    public int displayRank;
    @JsonProperty("IsPrimary") 
    public boolean isPrimary;
    @JsonProperty("FulfillmentType") 
    public Object fulfillmentType;
}
