package io.jittakal.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConfigClientApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ConfigClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
	}

    /**
     * Output property from cloud-config-server on startup of app,
     *
     * also can be seen at:
     * http://localhost:8080/env/info.foo
     */
    @Bean
    public CommandLineRunner printProperties(@Value("${config.client.msg}") final String configClientMsg)  {
        return args -> LOGGER.info("config.client.msg is: [{}]", configClientMsg);
	}
		
}
