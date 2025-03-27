package com.example.demo22.treading;



import com.example.demo22.model.Ticket;

import java.math.BigDecimal;
import java.util.Random;

public class Vendor implements Runnable {
    private int totalTickets;
    private int ticketReleaseRate;
    private TicketPool ticketPool;
    private Random random;

    public Vendor(int totalTickets, int ticketReleaseRate, TicketPool ticketPool) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.ticketPool = ticketPool;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 1; i <= totalTickets; i++) {
            Ticket ticket = new Ticket(i, "Event-" + i, BigDecimal.valueOf(500 + random.nextInt(501)));
            ticketPool.addTicket(ticket);

            try {
                Thread.sleep(ticketReleaseRate * 1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}