package com.sistemasactivos.monitoring.config;

import com.sistemasactivos.monitoring.service.DataMonitoringService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class MyScheduledTask {

    @Autowired
    private DataMonitoringService service;

    private ScheduledExecutorService executorService;

    @PostConstruct
    public void init() {
        try {
            executorService = Executors.newSingleThreadScheduledExecutor();
            executorService.scheduleAtFixedRate(this::myTask, 0, 5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void myTask() {
        try {
            service.getMetrics("monitoring" ,"jvm.memory.used");
            service.getMetrics("monitoring" ,"process.cpu.usage");
            service.getMetrics("monitoring" ,"system.cpu.usage");
            service.getMetrics("monitoring" ,"disk.free");

            service.getMetrics("costumers" ,"jvm.memory.used");
            service.getMetrics("costumers" ,"process.cpu.usage");
            service.getMetrics("costumers" ,"system.cpu.usage");
            service.getMetrics("costumers" ,"disk.free");

            service.getMetrics("benefits" ,"jvm.memory.used");
            service.getMetrics("benefits" ,"process.cpu.usage");
            service.getMetrics("benefits" ,"system.cpu.usage");
            service.getMetrics("benefits" ,"disk.free");

            System.out.println("Ejecutando tarea programada");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() {
        executorService.shutdown();
    }


}
