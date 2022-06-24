package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AllowedPlatform{
    @JsonProperty("MaxVersion")
    public Object maxVersion;
    @JsonProperty("MinVersion") 
    public int minVersion;
    @JsonProperty("PlatformName") 
    public String platformName;
}
