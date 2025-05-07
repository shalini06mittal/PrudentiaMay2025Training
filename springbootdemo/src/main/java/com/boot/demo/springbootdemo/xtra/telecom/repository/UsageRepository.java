package com.boot.demo.springbootdemo.xtra.telecom.repository;

import com.boot.demo.springbootdemo.xtra.telecom.model.Usage;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsageRepository extends MongoRepository<Usage, String> {
    List<Usage> findBySubscriberId(String subscriberId);
    List<Usage> findBySubscriberIdAndDateBetween(String subscriberId, LocalDate start, LocalDate end);
}
