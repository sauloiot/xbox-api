package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EligibilityProperties{
    @JsonProperty("Remediations")
    public ArrayList<Remediation> remediations;
    @JsonProperty("Affirmations") 
    public ArrayList<Affirmation> affirmations;
}
