package com.asset_management.asset.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "assetRegister")
public class AssetRegisterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetId;

    @Column(name = "issued_on")
    private Date issuedOn;

    @Column(name = "issued_to_employee")
    private String issuedToEmployee;

    @Column(name = "model_no")
    private String modelNumber;

    @Column(name = "make")
    private String make;

    @Column(name = "asset_type")
    private String assetType;

}
