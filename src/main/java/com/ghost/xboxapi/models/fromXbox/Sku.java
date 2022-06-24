package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sku{
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LocalizedProperties") 
    public ArrayList<LocalizedProperty> localizedProperties;
    @JsonProperty("MarketProperties") 
    public ArrayList<MarketProperty> marketProperties;
    @JsonProperty("ProductId") 
    public String productId;
    @JsonProperty("Properties") 
    public Properties properties;
    @JsonProperty("SkuASchema") 
    public String skuASchema;
    @JsonProperty("SkuBSchema") 
    public String skuBSchema;
    @JsonProperty("SkuId") 
    public String skuId;
    @JsonProperty("SkuType") 
    public String skuType;
    @JsonProperty("RecurrencePolicy") 
    public Object recurrencePolicy;
    @JsonProperty("SubscriptionPolicyId") 
    public Object subscriptionPolicyId;
}
