package com.example.demo;

import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.CatalogController;
import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@SpringBootTest
class CatalogServiceApplicationTests {
	
	@Mock
	private ProductRepository prodRepo;

	@InjectMocks
	private CatalogController contr;
	
	public List<Product> product;
	
	
	
	@Test 
	@Order(1)
	public void TestFindByName(){ //Testing on Get Product Details By Name Id Method
		List<Product> product = new ArrayList<Product>();
		product.add(new Product (2, "Note 8", "Electronics", 65465, "data.jpg", "Samsung galaxy note 8"));
		when(prodRepo.findByName("Note 8")).thenReturn(product);
		assertEquals(1, prodRepo.findByName("Note 8").size());
	}
	
	
}