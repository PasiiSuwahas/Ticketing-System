package com.example.demo22.treading;

import com.example.demo22.model.Ticket;

public class Customer implements Runnable {
    private TicketPool ticketPool;
    private int customerRetrievalRate;
    private int quantity;

    public Customer(TicketPool ticketPool, int customerRetrievalRate, int quantity) {
        this.ticketPool = ticketPool;
        this.customerRetrievalRate = customerRetrievalRate;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        for (int i = 0; i < quantity; i++) {
            Ticket ticket = ticketPool.buyTicket();
            System.out.println("Bought: " + ticket);
            try {
                Thread.sleep(customerRetrievalRate * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}

