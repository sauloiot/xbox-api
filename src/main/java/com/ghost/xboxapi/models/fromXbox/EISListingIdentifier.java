package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EISListingIdentifier{
    @JsonProperty("ListingId")
    public String listingId;
    @JsonProperty("AssetId") 
    public String assetId;
}
