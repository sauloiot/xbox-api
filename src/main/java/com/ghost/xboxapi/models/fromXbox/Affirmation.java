package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Affirmation{
    @JsonProperty("AffirmationId")
    public String affirmationId;
    @JsonProperty("AffirmationProductId") 
    public String affirmationProductId;
    @JsonProperty("Description") 
    public String description;
}
