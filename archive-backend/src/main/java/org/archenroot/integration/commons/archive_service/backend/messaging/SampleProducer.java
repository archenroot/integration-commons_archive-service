package org.archenroot.integration.commons.archive_service.backend.messaging;


import org.archenroot.integration.commons.archive_service.backend.util.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class SampleProducer implements CommandLineRunner {

    private final static AppLogger logger = AppLogger.getInstance();

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Override
    public void run(String... args) throws Exception {
        send("===== TESTING MESSAGE =====");
        logger.info("Message was sent to the Queue");
    }

    public void send(String msg) {
        logger.info("Queue send void invocated.");
        this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
    }

}