package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Properties{
    @JsonProperty("Attributes")
    public ArrayList<Attribute> attributes;
    @JsonProperty("CanInstallToSDCard") 
    public boolean canInstallToSDCard;
    @JsonProperty("Category") 
    public String category;
    @JsonProperty("Categories") 
    public Object categories;
    @JsonProperty("Subcategory") 
    public Object subcategory;
    @JsonProperty("IsAccessible") 
    public boolean isAccessible;
    @JsonProperty("IsDemo") 
    public boolean isDemo;
    @JsonProperty("IsLineOfBusinessApp") 
    public boolean isLineOfBusinessApp;
    @JsonProperty("IsPublishedToLegacyWindowsPhoneStore") 
    public boolean isPublishedToLegacyWindowsPhoneStore;
    @JsonProperty("IsPublishedToLegacyWindowsStore") 
    public boolean isPublishedToLegacyWindowsStore;
    @JsonProperty("PackageFamilyName") 
    public String packageFamilyName;
    @JsonProperty("PackageIdentityName") 
    public String packageIdentityName;
    @JsonProperty("PublisherCertificateName") 
    public String publisherCertificateName;
    @JsonProperty("PublisherId") 
    public String publisherId;
    @JsonProperty("SkuDisplayGroups") 
    public ArrayList<SkuDisplayGroup> skuDisplayGroups;
    @JsonProperty("XboxLiveTier") 
    public String xboxLiveTier;
    @JsonProperty("XboxXPA") 
    public Object xboxXPA;
    @JsonProperty("XboxCrossGenSetId") 
    public Object xboxCrossGenSetId;
    @JsonProperty("XboxConsoleGenOptimized") 
    public ArrayList<String> xboxConsoleGenOptimized;
    @JsonProperty("XboxConsoleGenCompatible") 
    public ArrayList<String> xboxConsoleGenCompatible;
    @JsonProperty("XboxLiveGoldRequired") 
    public boolean xboxLiveGoldRequired;
    @JsonProperty("ExtendedMetadata") 
    public String extendedMetadata;
    @JsonProperty("XBOX") 
    public Object xBOX;
    @JsonProperty("OwnershipType") 
    public Object ownershipType;
    @JsonProperty("PdpBackgroundColor") 
    public String pdpBackgroundColor;
    @JsonProperty("HasAddOns") 
    public boolean hasAddOns;
    @JsonProperty("RevisionId") 
    public Date revisionId;
    @JsonProperty("ProductGroupId") 
    public String productGroupId;
    @JsonProperty("ProductGroupName") 
    public String productGroupName;
    @JsonProperty("EarlyAdopterEnrollmentUrl") 
    public Object earlyAdopterEnrollmentUrl;
    @JsonProperty("FulfillmentData") 
    public Object fulfillmentData;
    @JsonProperty("FulfillmentType") 
    public Object fulfillmentType;
    @JsonProperty("FulfillmentPluginId") 
    public Object fulfillmentPluginId;
    @JsonProperty("HasThirdPartyIAPs") 
    public boolean hasThirdPartyIAPs;
    @JsonProperty("LastUpdateDate") 
    public Date lastUpdateDate;
    @JsonProperty("HardwareProperties") 
    public Object hardwareProperties;
    @JsonProperty("HardwareRequirements") 
    public ArrayList<Object> hardwareRequirements;
    @JsonProperty("HardwareWarningList") 
    public ArrayList<Object> hardwareWarningList;
    @JsonProperty("InstallationTerms") 
    public String installationTerms;
    @JsonProperty("Packages") 
    public ArrayList<Object> packages;
    @JsonProperty("VersionString") 
    public String versionString;
    @JsonProperty("SkuDisplayGroupIds") 
    public ArrayList<String> skuDisplayGroupIds;
    @JsonProperty("BundledSkus") 
    public ArrayList<BundledSku> bundledSkus;
    @JsonProperty("IsRepurchasable") 
    public boolean isRepurchasable;
    @JsonProperty("SkuDisplayRank") 
    public int skuDisplayRank;
    @JsonProperty("DisplayPhysicalStoreInventory") 
    public Object displayPhysicalStoreInventory;
    @JsonProperty("VisibleToB2BServiceIds") 
    public ArrayList<Object> visibleToB2BServiceIds;
    @JsonProperty("AdditionalIdentifiers") 
    public ArrayList<Object> additionalIdentifiers;
    @JsonProperty("IsTrial") 
    public boolean isTrial;
    @JsonProperty("IsPreOrder") 
    public boolean isPreOrder;
    @JsonProperty("IsBundle") 
    public boolean isBundle;
    @JsonProperty("OriginalReleaseDate") 
    public Date originalReleaseDate;
}
