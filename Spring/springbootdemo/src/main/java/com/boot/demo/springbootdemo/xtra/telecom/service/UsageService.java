package com.boot.demo.springbootdemo.xtra.telecom.service;

import com.boot.demo.springbootdemo.xtra.telecom.model.Usage;
import com.boot.demo.springbootdemo.xtra.telecom.repository.UsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UsageService {

    @Autowired
    private UsageRepository usageRepository;

    public Usage recordUsage(Usage usage) {
        usage.setDate(LocalDate.now());
        return usageRepository.save(usage);
    }

    public List<Usage> getUsageBySubscriber(String subscriberId) {
        return usageRepository.findBySubscriberId(subscriberId);
    }

    public List<Usage> getUsageBySubscriberBetweenDates(String subscriberId, LocalDate start, LocalDate end) {
        return usageRepository.findBySubscriberIdAndDateBetween(subscriberId, start, end);
    }
}
