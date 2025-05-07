package com.boot.demo.springbootdemo.xtra.telecom.controller;

import com.boot.demo.springbootdemo.xtra.telecom.model.Subscriber;
import com.boot.demo.springbootdemo.xtra.telecom.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscribers")
public class SubscriberController {

    @Autowired
    private SubscriberService subscriberService;

    @PostMapping
    public ResponseEntity<Subscriber> createSubscriber(@RequestBody Subscriber subscriber) {
        return ResponseEntity.ok(subscriberService.createSubscriber(subscriber));
    }

    @GetMapping
    public List<Subscriber> getAllSubscribers() {
        return subscriberService.getAllSubscribers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subscriber> getSubscriberById(@PathVariable String id) {
        return subscriberService.getSubscriberById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subscriber> updateSubscriber(@PathVariable String id, @RequestBody Subscriber updated) {
        return ResponseEntity.ok(subscriberService.updateSubscriber(id, updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscriber(@PathVariable String id) {
        subscriberService.deleteSubscriber(id);
        return ResponseEntity.noContent().build();
    }
}
