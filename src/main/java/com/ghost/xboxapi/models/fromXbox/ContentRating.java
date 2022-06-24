package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ContentRating{
    @JsonProperty("RatingSystem")
    public String ratingSystem;
    @JsonProperty("RatingId") 
    public String ratingId;
    @JsonProperty("RatingDescriptors") 
    public ArrayList<String> ratingDescriptors;
    @JsonProperty("RatingDisclaimers") 
    public ArrayList<String> ratingDisclaimers;
    @JsonProperty("InteractiveElements") 
    public ArrayList<String> interactiveElements;
}
