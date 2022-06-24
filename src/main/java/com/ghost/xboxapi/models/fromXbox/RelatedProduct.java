package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RelatedProduct{
    @JsonProperty("RelatedProductId")
    public String relatedProductId;
    @JsonProperty("RelationshipType") 
    public String relationshipType;
}
