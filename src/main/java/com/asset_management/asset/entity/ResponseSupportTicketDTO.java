package com.asset_management.asset.entity;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.util.Date;

@Data
public class ResponseSupportTicketDTO {
    private Date ticketRaisedOn;
    private String ticketRaisedByEmployee;
    private AssetRegisterEntity assetId;
    private String assignedToEmployee;
    private Date expectedResolution;
    private String  ticketStatus;

}
