package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.repo.ProductRepository;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	ProductRepository prodRepo;
	
	
	
	@PostMapping("/post")
	public void addProduct(@RequestBody Product product) {
		prodRepo.save(product);
	}
	
	@GetMapping("/get")
	public List<Product> getAllProducts(){
		List<Product> list= new ArrayList<>();
		prodRepo.findAll().stream().forEach(list::add);
		return list;
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") int id) {
		return prodRepo.findById(id).get();
	}
	
	@PutMapping("/put")
	public void updateProduct(@RequestBody Product product) {
		prodRepo.save(product);
	}
	

	@GetMapping("/get/{name}") 
	public List<Product> getProductByName(@PathVariable("name") String name){
		 return prodRepo.findByName(name);
		 
	}

	@DeleteMapping("/{id}") 
	public void deleteProduct(@PathVariable("id") int id) {
		prodRepo.deleteById(id);
		
	}

	

	
}