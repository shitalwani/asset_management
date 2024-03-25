package com.asset_management.asset.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.util.Date;

@Data
public class RequestAssetRegisterDTO {
    private Date issuedOn;
    private String issuedToEmployee;
    private String modelNumber;
    private String make;
    private String assetType;
}
