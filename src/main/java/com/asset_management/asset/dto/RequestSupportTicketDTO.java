package com.asset_management.asset.dto;

import com.asset_management.asset.entity.AssetRegisterEntity;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.util.Date;

@Data
public class RequestSupportTicketDTO {
    private Date ticketRaisedOn;
    private String ticketRaisedByEmployee;
    private Integer assetId;
    private String assignedToEmployee;
    private Date expectedResolution;

    @Enumerated(EnumType.STRING)
    private RequestStatusEnum.TICKET_STATUS ticketStatus;
}
