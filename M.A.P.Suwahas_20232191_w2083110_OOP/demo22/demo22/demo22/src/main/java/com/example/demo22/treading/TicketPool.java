package com.example.demo22.treading;

import com.example.demo22.model.Ticket;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    private final int maxCapacity;
    private final Queue<Ticket> ticketQueue = new LinkedList<>();

    public TicketPool(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public synchronized void addTicket(Ticket ticket) {
        while (ticketQueue.size() >= maxCapacity) {
            try {
                wait();
                System.out.println("********* Vendor Waiting for adding ticket **********");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        ticketQueue.add(ticket);
        System.out.println("Ticket added by " + Thread.currentThread().getName() +
                ". Current pool size: " + ticketQueue.size());
        notifyAll();
    }

    public synchronized Ticket buyTicket() {
        while (ticketQueue.isEmpty()) {
            try {
                wait();
                System.out.println("********* Customer Waiting for Buying ticket**********");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        Ticket ticket = ticketQueue.poll();
        notifyAll();
        return ticket;
    }
}

