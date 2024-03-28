package com.asset_management.asset.service;

import com.asset_management.asset.dto.*;
import com.asset_management.asset.entity.*;

import java.util.List;

public interface AssetRegisterService {

    AssetRegisterEntity storeAsset(RequestAssetRegisterDTO requestAssetRegisterDTO);

    SupportTicketsEntity storeSupportTicket(RequestSupportTicketDTO requestSupportTicketDTO);

    TicketResolutionEntity storeTicketResolution(RequestTicketResolutionDTO requestTicketResolutionDTO);

    ResponseSupportTicketDTO getByTicketId(Integer ticketId);

    SupportTicketsEntity updateResolutionStatus(UpdateSupportTicketDTO updateSupportTicketDTO, Integer ticketId);

    List<AssetTypeEntity> addAssetTypes(List<RequestAssetTypeDTO> requestAssetTypeDTO);
}
