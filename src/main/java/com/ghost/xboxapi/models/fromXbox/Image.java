package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Image{
    @JsonProperty("FileId")
    public String fileId;
    @JsonProperty("EISListingIdentifier") 
    public EISListingIdentifier eISListingIdentifier;
    @JsonProperty("BackgroundColor") 
    public String backgroundColor;
    @JsonProperty("Caption") 
    public String caption;
    @JsonProperty("FileSizeInBytes") 
    public int fileSizeInBytes;
    @JsonProperty("ForegroundColor") 
    public String foregroundColor;
    @JsonProperty("Height") 
    public int height;
    @JsonProperty("ImagePositionInfo") 
    public String imagePositionInfo;
    @JsonProperty("ImagePurpose") 
    public String imagePurpose;
    @JsonProperty("UnscaledImageSHA256Hash") 
    public String unscaledImageSHA256Hash;
    @JsonProperty("Uri") 
    public String uri;
    @JsonProperty("Width") 
    public int width;
}
