package com.example.demo22.repositry;

import com.example.demo22.entity.TicketVendingRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketVendingRequestRepository extends JpaRepository<TicketVendingRequestEntity, Long> {

    List<TicketVendingRequestEntity> findByStatus(String status);

}