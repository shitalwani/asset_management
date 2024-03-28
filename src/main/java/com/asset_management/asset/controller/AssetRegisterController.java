package com.asset_management.asset.controller;

import com.asset_management.asset.dto.*;
import com.asset_management.asset.entity.*;
import com.asset_management.asset.service.AssetRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asset")
public class AssetRegisterController {

    @Autowired
    AssetRegisterService assetRegisterService;

    @PostMapping("/add")
    public ResponseEntity addAsset(@RequestBody RequestAssetRegisterDTO requestAssetRegisterDTO){
       AssetRegisterEntity addAsset = assetRegisterService.storeAsset(requestAssetRegisterDTO);
       return new ResponseEntity(addAsset, HttpStatus.CREATED);
    }

    @PostMapping("addSupportTicket")
    public ResponseEntity addSupportTicket(@RequestBody RequestSupportTicketDTO requestSupportTicketDTO){
     SupportTicketsEntity addTicket = assetRegisterService.storeSupportTicket(requestSupportTicketDTO);
     return new ResponseEntity(addTicket,HttpStatus.CREATED);
    }

    @PostMapping("addTicketResolution")
    public ResponseEntity addTicketResolution(@RequestBody RequestTicketResolutionDTO requestTicketResolutionDTO){
        TicketResolutionEntity addResolution = assetRegisterService.storeTicketResolution(requestTicketResolutionDTO);
        return new ResponseEntity(addResolution,HttpStatus.CREATED);

    }
    @GetMapping("/get/{ticketId}")
    public ResponseEntity<ResponseSupportTicketDTO> getSupportTicketById(@PathVariable(name = "ticketId")Integer ticketId){
        ResponseSupportTicketDTO getByTicketId = assetRegisterService.getByTicketId(ticketId);
        return new ResponseEntity<>(getByTicketId,HttpStatus.OK);
    }

    @PutMapping("/update/supportRequest/resolve/{ticketId}")
    public ResponseEntity<SupportTicketsEntity> updateStatus(@RequestBody UpdateSupportTicketDTO updateSupportTicketDTO,@PathVariable(name = "ticketId") Integer ticketId){
        SupportTicketsEntity updateStatus = assetRegisterService.updateResolutionStatus(updateSupportTicketDTO,ticketId);
        return new ResponseEntity<SupportTicketsEntity>(updateStatus,HttpStatus.OK);
    }

    @PostMapping("/createAssetType")
    public ResponseEntity<List<AssetTypeEntity>> createAssetType(@RequestBody List<RequestAssetTypeDTO> requestAssetTypeDTO){
        List<AssetTypeEntity> addAssetType = assetRegisterService.addAssetTypes(requestAssetTypeDTO);
        return new ResponseEntity<>(addAssetType,HttpStatus.CREATED);
    }

}
