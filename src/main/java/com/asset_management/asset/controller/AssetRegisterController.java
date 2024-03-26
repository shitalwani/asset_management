package com.asset_management.asset.controller;

import com.asset_management.asset.dto.RequestAssetRegisterDTO;
import com.asset_management.asset.dto.RequestSupportTicketDTO;
import com.asset_management.asset.entity.AssetRegisterEntity;
import com.asset_management.asset.entity.SupportTicketsEntity;
import com.asset_management.asset.service.AssetRegisterService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
