#!/bin/bash
CONFLUENT_HOME=/Users/Shalini/Desktop/VodafonePrudentiaWS/Kafka/confluent-7.7.1
$CONFLUENT_HOME/bin/kafka-console-consumer --topic dummy --bootstrap-server localhost:9092 --from-beginning
#--consumer-property max.partition.fetch.bytes=10485880