package com.asset_management.asset.service;

import com.asset_management.asset.dto.RequestAssetRegisterDTO;
import com.asset_management.asset.entity.AssetRegisterEntity;

public interface AssetRegisterService {

    AssetRegisterEntity storeAsset(RequestAssetRegisterDTO requestAssetRegisterDTO);
}
