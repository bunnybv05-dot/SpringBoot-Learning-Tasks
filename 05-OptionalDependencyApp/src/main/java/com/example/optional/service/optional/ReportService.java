package com.example.optional.service.optional;

import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component  // KEEP THIS UNCOMMENTED for Experiment 1
public class ReportService {
    
    public String generateReport(String type) {
        return String.format("📊 %s Report generated at %s", 
            type, LocalDateTime.now());
    }
    
    public String getReportStatus() {
        return "Report Service is OPERATIONAL";
    }
}