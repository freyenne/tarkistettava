package com.example.harjoitustyo2019;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.example.harjoitustyo2019.model.Product;
import com.example.harjoitustyo2019.repositories.ProductRepository;
import com.example.harjoitustyo2019.model.Product;
import com.example.harjoitustyo2019.repositories.ProductRepository;
import com.example.harjoitustyo2019.model.User;
import com.example.harjoitustyo2019.repositories.UserRepository;



@SpringBootApplication
public class Harjoitustyo2019Application extends SpringBootServletInitializer {
	private static final Logger log = LoggerFactory.getLogger(Harjoitustyo2019Application.class);
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Harjoitustyo2019Application.class);
    }


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Harjoitustyo2019Application.class, args);
	}
	
	@Bean
	public CommandLineRunner productDemo(ProductRepository prepository) {
		return (args) -> {
			log.info("");
			
			prepository.save(new Product(1,"Osmosal", "9,99", "Oy Leiras Finland Ab", "Oraaliliuokset"));
			prepository.save(new Product(2,"Neo-Amisept","4,99","Orion Corporation","Anstiseptiset-liuokset"));

			log.info("");
			for (Product product : prepository.findAll()) {
				log.info(product.toString());
			}

		};
	}
}
