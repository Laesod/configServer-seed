package com;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.config.server.EnableConfigServer;

import java.io.File;

@EnableConfigServer
@EnableAdminServer
@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

	public static void main(String[] args) {
		File pid = new File("app.pid");
		pid.deleteOnExit();

		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		app.addListeners(new ApplicationPidFileWriter(pid));

		app.run(args);
	}
}