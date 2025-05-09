package com.boot.demo.springbootdemo.xtra.telecom.controller;

import com.boot.demo.springbootdemo.xtra.telecom.model.Usage;
import com.boot.demo.springbootdemo.xtra.telecom.service.UsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/usage")
public class UsageController {

    @Autowired
    private UsageService usageService;

    @PostMapping
    public ResponseEntity<Usage> recordUsage(@RequestBody Usage usage) {
        return ResponseEntity.ok(usageService.recordUsage(usage));
    }

    @GetMapping("/{subscriberId}")
    public List<Usage> getUsageBySubscriber(@PathVariable String subscriberId) {
        return usageService.getUsageBySubscriber(subscriberId);
    }

    @GetMapping("/report")
    public List<Usage> getUsageReport(@RequestParam String subscriberId,
                                      @RequestParam String start,
                                      @RequestParam String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return usageService.getUsageBySubscriberBetweenDates(subscriberId, startDate, endDate);
    }
}
