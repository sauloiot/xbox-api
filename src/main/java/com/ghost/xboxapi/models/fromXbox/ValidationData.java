package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidationData{
    @JsonProperty("PassedValidation")
    public boolean passedValidation;
    @JsonProperty("RevisionId") 
    public String revisionId;
    @JsonProperty("ValidationResultUri") 
    public Object validationResultUri;
}
