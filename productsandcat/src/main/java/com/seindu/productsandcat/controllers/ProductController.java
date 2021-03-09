package com.seindu.productsandcat.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.seindu.productsandcat.models.Category;
import com.seindu.productsandcat.models.Product;
import com.seindu.productsandcat.services.AppService;

@Controller
public class ProductController {
	@Autowired
	private AppService aService;
	
	// main page
	@GetMapping("/")
	public String show() {
		return "/show.jsp";
	}
	
	//Show all products
	@GetMapping("/products")
	public String showAllProducts(Model viewModel) {
		List<Product> products = this.aService.findProducts();
		viewModel.addAttribute("products", products);
		return "/products/all.jsp";
	}
	
	//Show all categories
	@GetMapping("/categories")
	public String showAllCategories(Model viewModel) {
		List<Category> categories = this.aService.findCategories();
		viewModel.addAttribute("categories", categories);
		return "/categories/all.jsp";
	}
	
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "/products/new.jsp";
	}
	
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "/categories/new.jsp";
	}
	
	@PostMapping("/products/new")
	public String createNewProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if(result.hasErrors()) {
			return "/products/new.jsp";
		}else {
			this.aService.createProduct(product);
			return "redirect:/products";
		}
	}
	
	@PostMapping("/categories/new")
	public String createNewCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "/categories/new.jsp";
		}else {
			this.aService.newCategory(category);
			return "redirect:/categories";
		}
	}
	
	@GetMapping("/categories/{id}")
	public String getProductInfo(@PathVariable("id")Long id, Model viewModel) {
		Category category = this.aService.getCategory(id);
		List<Product> noProducts = this.aService.findProductsnotInCategories(category);
		viewModel.addAttribute("category", category);
		viewModel.addAttribute("noProducts", noProducts);
		return "/categories/info.jsp";
	}
	
	@GetMapping("/products/{id}")
	public String getCategoryInfo(@PathVariable("id")Long id, Model viewModel) {
		Product product = this.aService.getProduct(id);
		List<Category> noCategories = this.aService.findCategoriesNotInProduct(product);
		viewModel.addAttribute("product", product);
		viewModel.addAttribute("noCategories", noCategories);
		return "/products/info.jsp";
	}
	
	@PostMapping("/products/add/{id}")
	public String addCategory(@PathVariable("id") Long id,@RequestParam("category") Long catId) {
		Product product = this.aService.getProduct(id);
		Category category = this.aService.getCategory(catId);
		this.aService.addCategory(category, product);
		return "redirect:/products/{id}";
	}
	@PostMapping("/category/add/{id}")
	public String addProduct(@PathVariable("id") Long id,@RequestParam("product") Long prodId) {
		Product product = this.aService.getProduct(prodId);
		Category category = this.aService.getCategory(id);
		this.aService.addProduct(product, category);
		return "redirect:/categories/{id}";
	}
}