package com.seindu.controllerspractice.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HomeController {
	@RequestMapping("")
	public String hello() {
		return "Hello World, everyone!";
	}
	
	@RequestMapping("/world")
	public String world() {
		return "Class level annotations are cool too!";
	}
}
