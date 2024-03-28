package com.asset_management.asset.repository;

import com.asset_management.asset.entity.AssetTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetTypeRepository extends JpaRepository<AssetTypeEntity,Integer> {
}
