package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketProperty{
    @JsonProperty("OriginalReleaseDate")
    public Date originalReleaseDate;
    @JsonProperty("MinimumUserAge") 
    public int minimumUserAge;
    @JsonProperty("ContentRatings") 
    public ArrayList<ContentRating> contentRatings;
    @JsonProperty("RelatedProducts") 
    public ArrayList<RelatedProduct> relatedProducts;
    @JsonProperty("UsageData") 
    public ArrayList<UsageDatum> usageData;
    @JsonProperty("BundleConfig") 
    public Object bundleConfig;
    @JsonProperty("Markets") 
    public ArrayList<String> markets;
    @JsonProperty("FirstAvailableDate") 
    public Date firstAvailableDate;
    @JsonProperty("SupportedLanguages") 
    public ArrayList<String> supportedLanguages;
    @JsonProperty("PackageIds") 
    public Object packageIds;
    @JsonProperty("PIFilter") 
    public Object pIFilter;
}
