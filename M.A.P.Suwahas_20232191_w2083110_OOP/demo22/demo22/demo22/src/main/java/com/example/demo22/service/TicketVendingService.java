package com.example.demo22.service;

import com.example.demo22.entity.TicketVendingRequestEntity;
import com.example.demo22.model.request.TicketVendingRequest;

import com.example.demo22.repositry.TicketVendingRequestRepository;
import com.example.demo22.treading.Customer;
import com.example.demo22.treading.TicketPool;
import com.example.demo22.treading.Vendor;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class TicketVendingService {

    @Autowired
    private TicketVendingRequestRepository ticketVendingRequestRepository;

    private AtomicBoolean isRunning = new AtomicBoolean(false);
    private List<Thread> vendorThreads = new CopyOnWriteArrayList<>();
    private List<Thread> customerThreads = new CopyOnWriteArrayList<>();

    @Async // This makes the method asynchronous
    public synchronized void startVending(TicketVendingRequest request) {
        if (isRunning.get()) {
            throw new IllegalStateException("The vending process is already running.");
        }

        isRunning.set(true);

        // Save request parameters with "Running" status
        TicketVendingRequestEntity entity = new TicketVendingRequestEntity();
        entity.setTicketPoolSize(request.getTicketPoolSize());
        entity.setVendorCount(request.getVendorCount());
        entity.setTotalTicketsPerVendor(request.getTotalTicketsPerVendor());
        entity.setVendorReleaseRate(request.getVendorReleaseRate());
        entity.setCustomerCount(request.getCustomerCount());
        entity.setTicketsPerCustomer(request.getTicketsPerCustomer());
        entity.setCustomerRetrievalRate(request.getCustomerRetrievalRate());
        entity.setStatus("Running");
        entity = ticketVendingRequestRepository.save(entity);

        TicketPool ticketPool = new TicketPool(request.getTicketPoolSize());

        // Start vendors
        for (int i = 0; i < request.getVendorCount(); i++) {
            Vendor vendor = new Vendor(
                    request.getTotalTicketsPerVendor(),
                    request.getVendorReleaseRate(),
                    ticketPool
            );
            Thread vendorThread = new Thread(vendor, "Vendor-" + i);
            vendorThreads.add(vendorThread);
            vendorThread.start();
        }

        // Start customers
        for (int i = 0; i < request.getCustomerCount(); i++) {
            Customer customer = new Customer(
                    ticketPool,
                    request.getCustomerRetrievalRate(),
                    request.getTicketsPerCustomer()
            );
            Thread customerThread = new Thread(customer, "Customer-" + i);
            customerThreads.add(customerThread);
            customerThread.start();
        }

        // Wait for vendor threads to complete
        for (Thread thread : vendorThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Wait for customer threads to complete
        for (Thread thread : customerThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        // Update status to "Finished" after all threads are done
        entity.setStatus("Finished");
        ticketVendingRequestRepository.save(entity);

        // Clear the thread lists
        vendorThreads.clear();
        customerThreads.clear();

        isRunning.set(false);
    }

    @Async
    public  void stopVending() {
        if (!isRunning.get()) {
            throw new IllegalStateException("The vending process is not running.");
        }

        isRunning.set(false);
//         Update the status of all "Running" records to "User Stopped"
         List<TicketVendingRequestEntity> runningEntities = ticketVendingRequestRepository.findByStatus("Running");
         for (TicketVendingRequestEntity entity : runningEntities) {
         entity.setStatus("User Stopped"); }
         ticketVendingRequestRepository.saveAll(runningEntities);

        // Interrupt all threads
        for (Thread thread : vendorThreads) {
            thread.interrupt();
        }
        for (Thread thread : customerThreads) {
            thread.interrupt();
        }

        vendorThreads.clear();
        customerThreads.clear();


    }


    public boolean isRunning() {

        return isRunning.get();
    }

    public List<TicketVendingRequestEntity> getAllRequests() {

        return ticketVendingRequestRepository.findAll();
    }

    public void removeAllRequests() {

        ticketVendingRequestRepository.deleteAll();
    }
}