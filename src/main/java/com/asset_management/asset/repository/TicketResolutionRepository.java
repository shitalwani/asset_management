package com.asset_management.asset.repository;

import com.asset_management.asset.entity.TicketResolutionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketResolutionRepository extends JpaRepository<TicketResolutionEntity,Integer> {

}
