package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product{
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LocalizedProperties") 
    public ArrayList<LocalizedProperty> localizedProperties;
    @JsonProperty("MarketProperties") 
    public ArrayList<MarketProperty> marketProperties;
    @JsonProperty("ProductASchema") 
    public String productASchema;
    @JsonProperty("ProductBSchema") 
    public String productBSchema;
    @JsonProperty("ProductId") 
    public String productId;
    @JsonProperty("Properties") 
    public Properties properties;
    @JsonProperty("AlternateIds") 
    public ArrayList<AlternateId> alternateIds;
    @JsonProperty("DomainDataVersion") 
    public Object domainDataVersion;
    @JsonProperty("IngestionSource") 
    public String ingestionSource;
    @JsonProperty("IsMicrosoftProduct") 
    public boolean isMicrosoftProduct;
    @JsonProperty("PreferredSkuId") 
    public String preferredSkuId;
    @JsonProperty("ProductType") 
    public String productType;
    @JsonProperty("ValidationData") 
    public ValidationData validationData;
    @JsonProperty("MerchandizingTags") 
    public ArrayList<Object> merchandizingTags;
    @JsonProperty("SandboxId") 
    public String sandboxId;
    @JsonProperty("ProductFamily") 
    public String productFamily;
    @JsonProperty("SchemaVersion") 
    public String schemaVersion;
    @JsonProperty("IsSandboxedProduct") 
    public boolean isSandboxedProduct;
    @JsonProperty("ProductKind") 
    public String productKind;
    @JsonProperty("ProductPolicies")
    public ProductPolicies productPolicies;
    @JsonProperty("DisplaySkuAvailabilities") 
    public ArrayList<DisplaySkuAvailability> displaySkuAvailabilities;
}
