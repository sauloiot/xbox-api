package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SatisfyingEntitlementKey{
    @JsonProperty("EntitlementKeys")
    public ArrayList<String> entitlementKeys;
    @JsonProperty("LicensingKeyIds") 
    public ArrayList<String> licensingKeyIds;
}
