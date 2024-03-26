package com.asset_management.asset.repository;

import com.asset_management.asset.entity.AssetRegisterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRegisterRepository extends JpaRepository<AssetRegisterEntity,Integer> {
    //AssetRegisterEntity findByAssetId(String assetId);
}
