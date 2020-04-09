package com.pedrolima.springrest.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.pedrolima.springrest.entities.Category;
import com.pedrolima.springrest.entities.Product;
import com.pedrolima.springrest.repositories.CategoryRepository;
import com.pedrolima.springrest.repositories.ProductRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Escritório");

		Product p1 = new Product(null, "Computador", 2000.00);
		Product p2 = new Product(null, "Impressora", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);

		p1.getCategories().add(cat1);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat1);

		cat1.getProducts().add(p1);
		cat1.getProducts().add(p2);
		cat1.getProducts().add(p3);
		cat2.getProducts().add(p2);

		categoryRepository.saveAll(Arrays.asList(cat1, cat2));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));
	}

}
