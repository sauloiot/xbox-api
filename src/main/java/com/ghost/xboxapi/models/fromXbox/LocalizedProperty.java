package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LocalizedProperty{
    @JsonProperty("DeveloperName")
    public String developerName;
    @JsonProperty("PublisherName") 
    public String publisherName;
    @JsonProperty("PublisherWebsiteUri") 
    public String publisherWebsiteUri;
    @JsonProperty("SupportUri") 
    public String supportUri;
    @JsonProperty("EligibilityProperties") 
    public EligibilityProperties eligibilityProperties;
    @JsonProperty("Franchises") 
    public ArrayList<Object> franchises;
    @JsonProperty("Images") 
    public ArrayList<Image> images;
    @JsonProperty("Videos") 
    public ArrayList<Video> videos;
    @JsonProperty("ProductDescription") 
    public String productDescription;
    @JsonProperty("ProductTitle") 
    public String productTitle;
    @JsonProperty("ShortTitle") 
    public String shortTitle;
    @JsonProperty("SortTitle") 
    public String sortTitle;
    @JsonProperty("FriendlyTitle") 
    public Object friendlyTitle;
    @JsonProperty("ShortDescription") 
    public String shortDescription;
    @JsonProperty("SearchTitles") 
    public ArrayList<Object> searchTitles;
    @JsonProperty("VoiceTitle") 
    public String voiceTitle;
    @JsonProperty("RenderGroupDetails") 
    public Object renderGroupDetails;
    @JsonProperty("ProductDisplayRanks") 
    public ArrayList<Object> productDisplayRanks;
    @JsonProperty("InteractiveModelConfig") 
    public Object interactiveModelConfig;
    @JsonProperty("Interactive3DEnabled") 
    public boolean interactive3DEnabled;
    @JsonProperty("Language") 
    public String language;
    @JsonProperty("Markets") 
    public ArrayList<String> markets;
    @JsonProperty("Contributors") 
    public ArrayList<Object> contributors;
    @JsonProperty("Features") 
    public ArrayList<Object> features;
    @JsonProperty("MinimumNotes") 
    public String minimumNotes;
    @JsonProperty("RecommendedNotes") 
    public String recommendedNotes;
    @JsonProperty("ReleaseNotes") 
    public String releaseNotes;
    @JsonProperty("DisplayPlatformProperties") 
    public Object displayPlatformProperties;
    @JsonProperty("SkuDescription") 
    public String skuDescription;
    @JsonProperty("SkuTitle") 
    public String skuTitle;
    @JsonProperty("SkuButtonTitle") 
    public String skuButtonTitle;
    @JsonProperty("DeliveryDateOverlay") 
    public Object deliveryDateOverlay;
    @JsonProperty("SkuDisplayRank") 
    public ArrayList<SkuDisplayRank> skuDisplayRank;
    @JsonProperty("TextResources") 
    public Object textResources;
    @JsonProperty("LegalText") 
    public LegalText legalText;
}
