package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Price{
    @JsonProperty("CurrencyCode")
    public String currencyCode;
    @JsonProperty("IsPIRequired") 
    public boolean isPIRequired;
    @JsonProperty("ListPrice") 
    public double listPrice;
    @JsonProperty("MSRP") 
    public double mSRP;
    @JsonProperty("TaxType") 
    public String taxType;
    @JsonProperty("WholesaleCurrencyCode") 
    public String wholesaleCurrencyCode;
    @JsonProperty("WholesalePrice") 
    public double wholesalePrice;
}
