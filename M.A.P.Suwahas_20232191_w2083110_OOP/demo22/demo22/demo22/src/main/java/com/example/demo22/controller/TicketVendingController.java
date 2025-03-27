package com.example.demo22.controller;


import com.example.demo22.entity.TicketVendingRequestEntity;
import com.example.demo22.model.Ticket;
import com.example.demo22.model.request.TicketVendingRequest;
import com.example.demo22.model.response.ApiResponse;
import com.example.demo22.service.TicketVendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket-vending")
public class TicketVendingController {

    @Autowired
    private TicketVendingService ticketVendingService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/start")
    public ResponseEntity<ApiResponse> startVending(@RequestBody TicketVendingRequest request) {
        try {
            ticketVendingService.startVending(request);
            return ResponseEntity.ok(new ApiResponse(true, "Ticket vending process started."));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "An error occurred while starting the vending process."));
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/stop")
    public ResponseEntity<ApiResponse> stopVending() {
        try {

            ticketVendingService.stopVending();
            return ResponseEntity.ok(new ApiResponse(true, "Ticket vending process stopped."));
        } catch (IllegalStateException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false, "An error occurred while stopping the vending process."));
        }
    }

    // Get all tickets
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/requests")
    public ResponseEntity<List<TicketVendingRequestEntity>> getAllTickets() {
        try {
            List<TicketVendingRequestEntity> tickets = ticketVendingService.getAllRequests();
            return ResponseEntity.ok(tickets);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/remove")
    public void removeAllTickets( ) {
        try {
            ticketVendingService.removeAllRequests();
            ResponseEntity.ok("Successfully cleared the table");
        } catch (Exception e) {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
