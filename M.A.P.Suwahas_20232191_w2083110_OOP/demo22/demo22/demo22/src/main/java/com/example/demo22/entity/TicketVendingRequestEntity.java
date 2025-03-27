package com.example.demo22.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "ticket_vending_request")
public class TicketVendingRequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int ticketPoolSize;
    private int vendorCount;
    private int totalTicketsPerVendor;
    private int vendorReleaseRate;
    private int customerCount;
    private int ticketsPerCustomer;
    private int customerRetrievalRate;
    private String status;

    public TicketVendingRequestEntity(Long id, int ticketPoolSize, int vendorCount, int totalTicketsPerVendor, int vendorReleaseRate, int customerCount, int ticketsPerCustomer, int customerRetrievalRate, String status) {
        this.id = id;
        this.ticketPoolSize = ticketPoolSize;
        this.vendorCount = vendorCount;
        this.totalTicketsPerVendor = totalTicketsPerVendor;
        this.vendorReleaseRate = vendorReleaseRate;
        this.customerCount = customerCount;
        this.ticketsPerCustomer = ticketsPerCustomer;
        this.customerRetrievalRate = customerRetrievalRate;
        this.status = status;
    }

    public TicketVendingRequestEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTicketPoolSize() {
        return ticketPoolSize;
    }

    public void setTicketPoolSize(int ticketPoolSize) {
        this.ticketPoolSize = ticketPoolSize;
    }

    public int getVendorCount() {
        return vendorCount;
    }

    public void setVendorCount(int vendorCount) {
        this.vendorCount = vendorCount;
    }

    public int getTotalTicketsPerVendor() {
        return totalTicketsPerVendor;
    }

    public void setTotalTicketsPerVendor(int totalTicketsPerVendor) {
        this.totalTicketsPerVendor = totalTicketsPerVendor;
    }

    public int getVendorReleaseRate() {
        return vendorReleaseRate;
    }

    public void setVendorReleaseRate(int vendorReleaseRate) {
        this.vendorReleaseRate = vendorReleaseRate;
    }

    public int getCustomerCount() {
        return customerCount;
    }

    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

    public int getTicketsPerCustomer() {
        return ticketsPerCustomer;
    }

    public void setTicketsPerCustomer(int ticketsPerCustomer) {
        this.ticketsPerCustomer = ticketsPerCustomer;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}