package com.asset_management.asset.service;

import com.asset_management.asset.dto.RequestAssetRegisterDTO;
import com.asset_management.asset.dto.RequestSupportTicketDTO;
import com.asset_management.asset.entity.AssetRegisterEntity;
import com.asset_management.asset.entity.SupportTicketsEntity;

public interface AssetRegisterService {

    AssetRegisterEntity storeAsset(RequestAssetRegisterDTO requestAssetRegisterDTO);

    SupportTicketsEntity storeSupportTicket(RequestSupportTicketDTO requestSupportTicketDTO);
}
