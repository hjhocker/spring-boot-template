package org.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

//@EnableAutoConfiguration(exclude = JpaRepositoriesAutoConfiguration.class)
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(DemoApplication.class);
    }
	
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
