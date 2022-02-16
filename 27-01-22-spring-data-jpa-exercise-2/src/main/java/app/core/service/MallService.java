package app.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.Product;
import app.core.entities.Store;
import app.core.repositories.ProductRepo;
import app.core.repositories.StoreRepo;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class MallService {

	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private StoreRepo storeRepo;
	
	public int addStore(Store store) {
		store = this.storeRepo.save(store);
		return store.getId();
	}
	
	public Store getStore(int storeId) {
		return this.storeRepo.findById(storeId).orElseThrow();
	}
	
	public List<Store> getAllStoresInMall() {
		return null;
	}
	
	public void updateStore(Store store) {
		
	}
	
	public void deleteStore(int storeId) {
		
	}
	
	public int addProductToStore(int storeId, Product product) {
		Store store = this.storeRepo.findById(storeId).orElseThrow();
		store.addProduct(product);
		return 0;
	}
	
	public Product getProduct(int productId) {
		return this.productRepo.findById(productId).orElseThrow();
	}
	
	public List<Product> getAllProductsInMall() {
		return null;
	}
	
	public List<Product> getAllProductsInMall(double maxPrice) {
		return null;
	}
	
	public List<Store> getAllStoresInMall(String name) {
		return null;
	}
}
