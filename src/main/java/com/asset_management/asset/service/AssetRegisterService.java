package com.asset_management.asset.service;

import com.asset_management.asset.dto.RequestAssetRegisterDTO;
import com.asset_management.asset.dto.RequestSupportTicketDTO;
import com.asset_management.asset.dto.RequestTicketResolutionDTO;
import com.asset_management.asset.entity.AssetRegisterEntity;
import com.asset_management.asset.entity.ResponseSupportTicketDTO;
import com.asset_management.asset.entity.SupportTicketsEntity;
import com.asset_management.asset.entity.TicketResolutionEntity;

public interface AssetRegisterService {

    AssetRegisterEntity storeAsset(RequestAssetRegisterDTO requestAssetRegisterDTO);

    SupportTicketsEntity storeSupportTicket(RequestSupportTicketDTO requestSupportTicketDTO);

    TicketResolutionEntity storeTicketResolution(RequestTicketResolutionDTO requestTicketResolutionDTO);

    ResponseSupportTicketDTO getByTicketId(Integer ticketId);
}
