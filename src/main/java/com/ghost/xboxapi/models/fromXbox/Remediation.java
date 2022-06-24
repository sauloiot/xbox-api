package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Remediation{
    @JsonProperty("RemediationId")
    public String remediationId;
    @JsonProperty("Description") 
    public String description;
    @JsonProperty("Type") 
    public String type;
    @JsonProperty("BigId") 
    public String bigId;
}
