#!/bin/bash
CONFLUENT_HOME=/Users/Shalini/Desktop/VodafonePrudentiaWS/Kafka/confluent-7.7.1
$CONFLUENT_HOME/bin/kafka-topics --describe  --bootstrap-server localhost:9092 --topic sample
