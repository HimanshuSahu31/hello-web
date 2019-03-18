package com.hello.web.helloweb;

import com.hello.web.helloweb.config.LocalConfiguration;
import io.molr.mole.server.main.DemoMolrServerMain;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({LocalConfiguration.class, DemoMolrServerMain.class})
public class HelloWebApplication {
	public static void main(String[] args) {
		SpringApplication.run(HelloWebApplication.class);
	}

}
