package com.asset_management.asset.implementation;

import com.asset_management.asset.dto.RequestAssetRegisterDTO;
import com.asset_management.asset.dto.RequestSupportTicketDTO;
import com.asset_management.asset.entity.AssetRegisterEntity;
import com.asset_management.asset.entity.SupportTicketsEntity;
import com.asset_management.asset.exception.ApplicationException;
import com.asset_management.asset.repository.AssetRegisterRepository;
import com.asset_management.asset.repository.SupportTicketRepository;
import com.asset_management.asset.service.AssetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AssetServiceImplementation implements AssetRegisterService {

    @Autowired
    AssetRegisterRepository assetRegisterRepository;

    @Autowired
    SupportTicketRepository supportTicketRepository;

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

    @Override
    public SupportTicketsEntity storeSupportTicket(RequestSupportTicketDTO requestSupportTicketDTO) {
        SupportTicketsEntity supportTicketsEntity = new SupportTicketsEntity();
        supportTicketsEntity.setTicketStatus(String.valueOf(requestSupportTicketDTO.getTicketStatus()));
        supportTicketsEntity.setTicketRaisedOn(requestSupportTicketDTO.getTicketRaisedOn());
        supportTicketsEntity.setTicketRaisedByEmployee(requestSupportTicketDTO.getTicketRaisedByEmployee());
        supportTicketsEntity.setAssignedToEmployee(requestSupportTicketDTO.getAssignedToEmployee());
        supportTicketsEntity.setExpectedResolution(requestSupportTicketDTO.getExpectedResolution());

        Optional<AssetRegisterEntity> assetRegisterEntity = assetRegisterRepository.findById(requestSupportTicketDTO.getAssetId());
        if(assetRegisterEntity.isEmpty()){
            throw new ApplicationException("record not found ", HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
        supportTicketsEntity.setAssetId(assetRegisterEntity.get());

        return supportTicketRepository.save(supportTicketsEntity);
    }
}
