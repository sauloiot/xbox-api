package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UsageDatum{
    @JsonProperty("AggregateTimeSpan")
    public String aggregateTimeSpan;
    @JsonProperty("AverageRating") 
    public double averageRating;
    @JsonProperty("PlayCount") 
    public int playCount;
    @JsonProperty("RatingCount") 
    public int ratingCount;
    @JsonProperty("RentalCount") 
    public String rentalCount;
    @JsonProperty("TrialCount") 
    public String trialCount;
    @JsonProperty("PurchaseCount") 
    public String purchaseCount;
}
