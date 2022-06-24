package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderManagementData{
    @JsonProperty("GrantedEntitlementKeys")
    public ArrayList<Object> grantedEntitlementKeys;
    @JsonProperty("PIFilter") 
    public PIFilter pIFilter;
    @JsonProperty("Price") 
    public Price price;
    @JsonProperty("OrderManagementPolicyIdOverride") 
    public String orderManagementPolicyIdOverride;
    @JsonProperty("GeofencingPolicyId") 
    public String geofencingPolicyId;
}
