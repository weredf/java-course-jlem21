package app.core.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.core.beans.Product;

@RestController
@CrossOrigin
@RequestMapping("/api/product")
public class ProductController {

	@GetMapping
	public List<Product> getProducts(){
		List<Product> products = new ArrayList<>();
		products.add(new Product(7, "Red Apple", 1.5, 140));
		products.add(new Product(6, "Pizza", 40, 30));
		products.add(new Product(5, "Avocado", 4, 80));
		products.add(new Product(4, "Tomato", 2, 300));
		products.add(new Product(3, "Honey", 25, 50));
		products.add(new Product(2, "Milk", 5.80, 100));
		products.add(new Product(1, "Bread", 10.90, 200));
		try {
			TimeUnit.MILLISECONDS.sleep(250);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return products;
	}
}
