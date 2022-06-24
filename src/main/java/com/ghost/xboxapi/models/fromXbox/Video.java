package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Video{
    @JsonProperty("Uri")
    public String uri;
    @JsonProperty("VideoPurpose") 
    public String videoPurpose;
    @JsonProperty("Height") 
    public int height;
    @JsonProperty("Width") 
    public int width;
    @JsonProperty("AudioEncoding") 
    public String audioEncoding;
    @JsonProperty("VideoEncoding") 
    public String videoEncoding;
    @JsonProperty("VideoPositionInfo") 
    public String videoPositionInfo;
    @JsonProperty("Caption") 
    public String caption;
    @JsonProperty("FileSizeInBytes") 
    public int fileSizeInBytes;
    @JsonProperty("PreviewImage") 
    public PreviewImage previewImage;
    @JsonProperty("TrailerId") 
    public String trailerId;
    @JsonProperty("SortOrder") 
    public int sortOrder;
}
