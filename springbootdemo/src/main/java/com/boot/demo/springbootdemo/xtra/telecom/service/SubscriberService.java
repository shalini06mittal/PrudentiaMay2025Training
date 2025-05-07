package com.boot.demo.springbootdemo.xtra.telecom.service;

import com.boot.demo.springbootdemo.xtra.telecom.model.Subscriber;
import com.boot.demo.springbootdemo.xtra.telecom.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriberService {

    @Autowired
    private SubscriberRepository subscriberRepository;

    public Subscriber createSubscriber(Subscriber subscriber) {
        return subscriberRepository.save(subscriber);
    }

    public List<Subscriber> getAllSubscribers() {
        return subscriberRepository.findAll();
    }

    public Optional<Subscriber> getSubscriberById(String id) {
        return subscriberRepository.findById(id);
    }

    public Subscriber updateSubscriber(String id, Subscriber updatedSubscriber) {
        updatedSubscriber.setId(id);
        return subscriberRepository.save(updatedSubscriber);
    }

    public void deleteSubscriber(String id) {
        subscriberRepository.deleteById(id);
    }
}
