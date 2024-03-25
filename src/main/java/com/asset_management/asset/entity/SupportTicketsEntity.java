package com.asset_management.asset.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "support_ticket")
public class SupportTicketsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    @Column(name = "ticket_raised_on")
    private Date ticketRaisedOn;

    @Column(name = "ticket_raised_by_employee")
    private String ticketRaisedByEmployee;

    @Column(name = "asset_id")
    private Integer assetId;

    @Column(name = "assigned_to_employee")
    private String assignedToEmployee;

    @Column(name = "expected_resolution")
    private Date expectedResolution;

    @Column(name = "ticket_status")
    private Date ticketStatus;


}
