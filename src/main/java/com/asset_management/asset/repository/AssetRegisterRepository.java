package com.asset_management.asset.repository;

import com.asset_management.asset.entity.AssetRegisterEntity;
import jakarta.persistence.NamedNativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRegisterRepository extends JpaRepository<AssetRegisterEntity,Integer> {
    //AssetRegisterEntity findByAssetId(String assetId);

    @Query(value = "select count(*) from asset_register ar where ar.issued_to_employee = :employeeId", nativeQuery = true)
    Integer getCountOfAssets(String employeeId);

}
