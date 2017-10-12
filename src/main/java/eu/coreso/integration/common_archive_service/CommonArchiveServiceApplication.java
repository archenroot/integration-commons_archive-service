package eu.coreso.integration.common_archive_service;

import org.archenroot.integration.commons.archive_service.backend.util.AppLogger;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.jms.Queue;

@SpringBootApplication
//@ConfigurationProperties
//@ImportResource({ "classpath:dao-context.xml" })
@ComponentScan("eu.coreso.integration.common_archive_service.backend.domain")
public class CommonArchiveServiceApplication {

    private final static AppLogger logger = AppLogger.getInstance();

    public static void main(String[] args) {

        SpringApplication.run(CommonArchiveServiceApplication.class, args);
    }

    @Bean
    public Queue queue() {
        logger.info("New queue sample.queue created");
        return new ActiveMQQueue("sample.queue");
    }
}