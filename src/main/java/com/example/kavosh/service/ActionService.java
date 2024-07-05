package com.example.kavosh.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ActionService {


    @Async
    public synchronized void performAction(String actionName) {
        System.out.println("Action " + actionName + " started.");
        try {
            Thread.sleep(10000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Action " + actionName + " Finished.");
    }
}
