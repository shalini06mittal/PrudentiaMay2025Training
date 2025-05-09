#!/bin/bash
CONFLUENT_HOME=/Users/Shalini/Desktop/VodafonePrudentiaWS/Kafka/confluent-7.7.1
$CONFLUENT_HOME/bin/kafka-configs --bootstrap-server localhost:9092 \
                                --alter --entity-type topics \
                                    --entity-name dummy \
                                    --add-config min.insync.replicas=2
