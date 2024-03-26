package com.asset_management.asset.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "TicketResolution")

public class TicketResolutionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketResolutionId;

    @ManyToOne(targetEntity = SupportTicketsEntity.class)
    @JoinColumn(name = "ticketId",referencedColumnName = "ticketId")
    private SupportTicketsEntity ticketId;

    @Column(name = "resolution_date")
    private Date resolutionDate;

    @Column(name = "resolution_description")
    private Date resolutionDescription;


}
