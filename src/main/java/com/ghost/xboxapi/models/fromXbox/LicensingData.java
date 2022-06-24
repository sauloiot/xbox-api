package com.ghost.xboxapi.models.fromXbox;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class LicensingData{
    @JsonProperty("SatisfyingEntitlementKeys")
    public ArrayList<SatisfyingEntitlementKey> satisfyingEntitlementKeys;
}
