package com.asset_management.asset.dto;

import lombok.Data;

import java.util.Date;

@Data
public class UpdateSupportTicketDTO {
    private Date expectedResolution;
    private String  ticketStatus;
}
