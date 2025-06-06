package com.metaverse.tihcl;


import com.metaverse.tihcl.common.util.CommonUtil;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@OpenAPIDefinition(
		info = @Info(
				title = "TiHcl API",
				version = "1.0",
				description = "API documentation for TiHcl Service"
		)
)
@SpringBootApplication(scanBasePackages = "com.metaverse")
public class TiHclApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {SpringApplication.run(TiHclApplication.class, args);}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TiHclApplication.class);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("*");
			}
		};
	}

	@Bean
	CommandLineRunner init( CommonUtil commonUtil) {
		return (args) -> {
			commonUtil.init();
		};
	}



}
