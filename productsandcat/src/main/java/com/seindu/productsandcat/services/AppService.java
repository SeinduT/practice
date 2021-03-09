package com.seindu.productsandcat.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seindu.productsandcat.models.Category;
import com.seindu.productsandcat.models.Product;
import com.seindu.productsandcat.repositories.CategoryRepository;
import com.seindu.productsandcat.repositories.ProductRepository;

@Service
public class AppService {
	@Autowired
	private ProductRepository pRepo;
	@Autowired
	private CategoryRepository cRepo;

	// Find all product
	public List<Product> findProducts() {
		return this.pRepo.findAll();
	}
	
	// find one product
	public Product getProduct(Long id) {
		return this.pRepo.findById(id).orElse(null);
	}
	
	// create product
	public Product createProduct(Product product) {
		return this.pRepo.save(product);
	}
	
	//Add category into product
	public void addCategory(Category category, Product product) {
		List<Category> categories = product.getCategories();
		categories.add(category);
		this.pRepo.save(product);
	}
	
	// create category
	public Category newCategory(Category category) {
		return this.cRepo.save(category);
	}
	
	// find category
	public Category getCategory(Long id) {
		return this.cRepo.findById(id).orElse(null);
	}
	
	// find all categories
	public List<Category> findCategories() {
		return this.cRepo.findAll();
	}
	
	//Add product into category
	public void addProduct(Product product, Category category) {
		List<Product> products = category.getProducts();
		products.add(product);
		this.cRepo.save(category);
	}
	
	// find categories not in product
	public List<Category> findCategoriesNotInProduct(Product product) {
		return cRepo.findByProductsNotContains(product);
	}
	
	// find product not in categories
	public List<Product> findProductsnotInCategories(Category category) {
		return pRepo.findByCategoriesNotContains(category);
	}
}
