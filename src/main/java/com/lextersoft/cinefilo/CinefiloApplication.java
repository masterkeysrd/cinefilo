package com.lextersoft.cinefilo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
public class CinefiloApplication {

    public static void main(String[] args) {
        SpringApplication.run(CinefiloApplication.class, args);
    }

    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver
                = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(5242880);
        return multipartResolver;
    }

}
