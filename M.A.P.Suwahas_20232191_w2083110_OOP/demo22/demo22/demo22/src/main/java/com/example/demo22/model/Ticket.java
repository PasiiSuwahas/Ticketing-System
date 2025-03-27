package com.example.demo22.model;


import java.math.BigDecimal;



public class Ticket {
    private int ticketId;
    private String eventName;
    private BigDecimal price;

    public Ticket(int ticketId, String eventName, BigDecimal price) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.price = price;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Ticket{id=" + ticketId + ", event='" + eventName + "', price=" + price + '}';
    }
}