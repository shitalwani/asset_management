package com.asset_management.asset.entity;

import jakarta.persistence.*;
import lombok.Data;
@Data
@Entity
@Table(name = "assetType")
public class AssetTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer assetId;
    @Column(name = "asset_type")
    private String assetType;
}
