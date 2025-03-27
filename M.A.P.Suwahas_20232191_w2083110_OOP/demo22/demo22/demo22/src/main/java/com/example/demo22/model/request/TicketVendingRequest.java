package com.example.demo22.model.request;




public class TicketVendingRequest {
    private int ticketPoolSize;
    private int vendorCount;
    private int totalTicketsPerVendor;
    private int vendorReleaseRate;
    private int customerCount;
    private int ticketsPerCustomer;
    private int customerRetrievalRate;

    public TicketVendingRequest(int ticketPoolSize, int vendorCount, int totalTicketsPerVendor, int vendorReleaseRate, int customerCount, int ticketsPerCustomer, int customerRetrievalRate) {
        this.ticketPoolSize = ticketPoolSize;
        this.vendorCount = vendorCount;
        this.totalTicketsPerVendor = totalTicketsPerVendor;
        this.vendorReleaseRate = vendorReleaseRate;
        this.customerCount = customerCount;
        this.ticketsPerCustomer = ticketsPerCustomer;
        this.customerRetrievalRate = customerRetrievalRate;
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
}
