package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Availability{
    @JsonProperty("Actions")
    public ArrayList<String> actions;
    @JsonProperty("AvailabilityASchema") 
    public String availabilityASchema;
    @JsonProperty("AvailabilityBSchema") 
    public String availabilityBSchema;
    @JsonProperty("AvailabilityId") 
    public String availabilityId;
    @JsonProperty("Conditions") 
    public Conditions conditions;
    @JsonProperty("LastModifiedDate") 
    public Date lastModifiedDate;
    @JsonProperty("Markets") 
    public ArrayList<String> markets;
    @JsonProperty("OrderManagementData") 
    public OrderManagementData orderManagementData;
    @JsonProperty("Properties") 
    public Properties properties;
    @JsonProperty("SkuId") 
    public String skuId;
    @JsonProperty("DisplayRank") 
    public int displayRank;
    @JsonProperty("RemediationRequired") 
    public boolean remediationRequired;
    @JsonProperty("LicensingData") 
    public LicensingData licensingData;
    @JsonProperty("AlternateIds") 
    public ArrayList<AlternateId> alternateIds;
    @JsonProperty("Remediations") 
    public ArrayList<Remediation> remediations;
    @JsonProperty("AffirmationId") 
    public String affirmationId;
}
