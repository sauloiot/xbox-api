package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LegalText{
    @JsonProperty("AdditionalLicenseTerms")
    public String additionalLicenseTerms;
    @JsonProperty("Copyright") 
    public String copyright;
    @JsonProperty("CopyrightUri") 
    public String copyrightUri;
    @JsonProperty("PrivacyPolicy") 
    public String privacyPolicy;
    @JsonProperty("PrivacyPolicyUri") 
    public String privacyPolicyUri;
    @JsonProperty("Tou") 
    public String tou;
    @JsonProperty("TouUri") 
    public String touUri;
}
