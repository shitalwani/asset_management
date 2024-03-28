package com.asset_management.asset.implementation;

import com.asset_management.asset.dto.*;
import com.asset_management.asset.entity.*;
import com.asset_management.asset.exception.ApplicationException;
import com.asset_management.asset.repository.AssetRegisterRepository;
import com.asset_management.asset.repository.AssetTypeRepository;
import com.asset_management.asset.repository.SupportTicketRepository;
import com.asset_management.asset.repository.TicketResolutionRepository;
import com.asset_management.asset.service.AssetRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AssetServiceImplementation implements AssetRegisterService {

    @Autowired
    AssetRegisterRepository assetRegisterRepository;

    @Autowired
    SupportTicketRepository supportTicketRepository;

    @Autowired
    TicketResolutionRepository ticketResolutionRepository;

    @Autowired
    AssetTypeRepository assetTypeRepository;

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

    @Override
    public TicketResolutionEntity storeTicketResolution(RequestTicketResolutionDTO requestTicketResolutionDTO) {

        TicketResolutionEntity ticketResolutionEntity = new TicketResolutionEntity();

        Optional<SupportTicketsEntity> supportTicketsEntity = supportTicketRepository.findById(requestTicketResolutionDTO.getTicketId());
        if(supportTicketsEntity.isEmpty()){
            throw new ApplicationException("Record not available!!!",HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
        }
        ticketResolutionEntity.setTicketId(supportTicketsEntity.get());

        ticketResolutionEntity.setResolutionDate(requestTicketResolutionDTO.getResolutionDate());
        ticketResolutionEntity.setResolutionDescription(requestTicketResolutionDTO.getResolutionDescription());
        return ticketResolutionRepository.save(ticketResolutionEntity);
    }

    @Override
    public ResponseSupportTicketDTO getByTicketId(Integer ticketId) {
       ResponseSupportTicketDTO responseSupportTicketDTO = new ResponseSupportTicketDTO();
       try {
           Optional<SupportTicketsEntity> supportTicketsEntity = supportTicketRepository.findById(ticketId);
           if (supportTicketsEntity.isEmpty()) {
               throw new ApplicationException("Record not found for Id :" + ticketId, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
           }
           SupportTicketsEntity supportTicketsEntityOptional = supportTicketsEntity.get();
           responseSupportTicketDTO.setTicketRaisedOn(supportTicketsEntityOptional.getTicketRaisedOn());
           responseSupportTicketDTO.setTicketStatus(supportTicketsEntityOptional.getTicketStatus());
           responseSupportTicketDTO.setTicketRaisedByEmployee(supportTicketsEntityOptional.getTicketRaisedByEmployee());
           responseSupportTicketDTO.setExpectedResolution(supportTicketsEntityOptional.getExpectedResolution());
           responseSupportTicketDTO.setAssetId(supportTicketsEntityOptional.getAssetId());
       } catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }
       return responseSupportTicketDTO;
    }

    @Override
    public SupportTicketsEntity updateResolutionStatus(UpdateSupportTicketDTO updateSupportTicketDTO, Integer ticketId) {
        Optional<SupportTicketsEntity> supportTicketsEntity = supportTicketRepository.findById(ticketId);
        SupportTicketsEntity supportTicketsEntityOptional = supportTicketsEntity.get();
        try {
            if (supportTicketsEntity.isEmpty()) {
                throw new ApplicationException("Record not found for Id:" + ticketId, HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST);
            }
            supportTicketsEntityOptional.setTicketStatus(updateSupportTicketDTO.getTicketStatus());
            supportTicketsEntityOptional.setExpectedResolution(updateSupportTicketDTO.getExpectedResolution());
        }catch(Exception e){
            e.printStackTrace();
        }
        return supportTicketRepository.save(supportTicketsEntityOptional);
    }

    @Override
    public List<AssetTypeEntity> addAssetTypes(List<RequestAssetTypeDTO> requestAssetTypeDTOList) {
        List<AssetTypeEntity> assetTypeEntityList = new ArrayList<>();
        try {
            if (!requestAssetTypeDTOList.isEmpty()) {
                requestAssetTypeDTOList.forEach(data -> {
                    AssetTypeEntity assetTypeEntity = new AssetTypeEntity();
                    assetTypeEntity.setAssetType(data.getAssetType());
                    AssetTypeEntity assetTypeEntity1 = assetTypeRepository.save(assetTypeEntity);
                    assetTypeEntityList.add(assetTypeEntity1);
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return assetTypeEntityList;
    }
}
