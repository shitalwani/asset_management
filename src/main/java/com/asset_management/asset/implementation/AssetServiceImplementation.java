package com.asset_management.asset.implementation;

import com.asset_management.asset.dto.RequestAssetRegisterDTO;
import com.asset_management.asset.entity.AssetRegisterEntity;
import com.asset_management.asset.repository.AssetRegisterRepository;
import com.asset_management.asset.service.AssetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetServiceImplementation implements AssetRegisterService {

    @Autowired
    AssetRegisterRepository assetRegisterRepository;

    @Override
    public AssetRegisterEntity storeAsset(RequestAssetRegisterDTO requestAssetRegisterDTO) {
        AssetRegisterEntity assetRegisterEntity = new AssetRegisterEntity();
        assetRegisterEntity.setIssuedOn(requestAssetRegisterDTO.getIssuedOn());
        assetRegisterEntity.setAssetType(requestAssetRegisterDTO.getAssetType());
        assetRegisterEntity.setMake(requestAssetRegisterDTO.getMake());
        assetRegisterEntity.setIssuedToEmployee(requestAssetRegisterDTO.getIssuedToEmployee());
        assetRegisterEntity.setModelNumber(requestAssetRegisterDTO.getModelNumber());
        return assetRegisterRepository.save(assetRegisterEntity) ;
    }
}
