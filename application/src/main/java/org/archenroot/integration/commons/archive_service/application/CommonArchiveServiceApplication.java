package org.archenroot.integration.commons.archive_service.application;

import org.apache.activemq.command.ActiveMQQueue;
import org.archenroot.integration.commons.archive_service.application.security.SecurityConfig;
import org.archenroot.integration.commons.archive_service.backend.domain.entity.Order;
import org.archenroot.integration.commons.archive_service.backend.repository.OrderRepository;
import org.archenroot.integration.commons.archive_service.backend.service.UserService;
import org.archenroot.integration.commons.archive_service.backend.util.AppLogger;
import org.archenroot.integration.commons.archive_service.backend.util.LocalDateJpaConverter;
import org.archenroot.integration.commons.archive_service.ui.AppUI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.vaadin.spring.events.annotation.EnableEventBus;



import javax.jms.Queue;


@SpringBootApplication(scanBasePackageClasses = {
		AppUI.class,
		CommonArchiveServiceApplication.class,
		UserService.class,
		SecurityConfig.class })
@EnableJpaRepositories(basePackageClasses = { OrderRepository.class })
@EntityScan(basePackageClasses = { Order.class, LocalDateJpaConverter.class })
@EnableEventBus
@ComponentScan("org.archenroot.integration.commons.archive_service.backend.domain")
public class CommonArchiveServiceApplication extends SpringBootServletInitializer {

	public static final String APP_URL = "/";
	public static final String LOGIN_URL = "/login.html";
	public static final String LOGOUT_URL = "/login.html?logout";
	public static final String LOGIN_FAILURE_URL = "/login.html?error";
	public static final String LOGIN_PROCESSING_URL = "/login";

	private final static AppLogger loggers = AppLogger.getInstance();


	public static void main(String[] args) {
		SpringApplication.run(CommonArchiveServiceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CommonArchiveServiceApplication.class);
	}

	@Bean
	public Queue queue() {
		loggers.info("New queue sample.queue created");
		return new ActiveMQQueue("sample.queue");
	}
}
