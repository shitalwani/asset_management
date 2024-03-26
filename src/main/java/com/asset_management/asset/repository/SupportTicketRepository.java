package com.asset_management.asset.repository;

import com.asset_management.asset.entity.SupportTicketsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportTicketRepository extends JpaRepository<SupportTicketsEntity,Integer>{
}
