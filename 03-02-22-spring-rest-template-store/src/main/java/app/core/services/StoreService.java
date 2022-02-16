package app.core.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Item;
import app.core.entities.Store;
import app.core.exceptions.StoreException;
import app.core.repos.ItemRepo;
import app.core.repos.StoreRepo;

@Service
@Transactional
public class StoreService {

	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private StoreRepo storeRepo;
	
	// create - http POST
	public int addStore(Store store) throws StoreException { // detached store
		if(!storeRepo.existsById(store.getId())) {
			return storeRepo.save(store).getId(); // persistent store
		} else {
			throw new StoreException("addStore failed - store exists");
		}
	}
	
	// read - http GET
	public Store getStore(int storeId) throws StoreException {
		Optional<Store> opt = storeRepo.findById(storeId);
		if(opt.isPresent()) {
			return opt.get();
		} else {
			throw new StoreException("getStore failed - store doesn't exist");
		}
	}
	
	public List<Item> getStoreItems(int storeId) {
		return getStore(storeId).getItems();
	}
	
	// update - http PUT
	public void updateStore(Store store) throws StoreException {
		Optional<Store> opt = storeRepo.findById(store.getId());
		if(opt.isPresent()) {
			storeRepo.save(store);
		} else {
			throw new StoreException("updateStore failed - store doesn't exist");
		}
	}
	
	// delete - http DELETE
	public void deleteStore(int storeId) throws StoreException {
		if(storeRepo.existsById(storeId)) {
			storeRepo.deleteById(storeId);
		} else {
			throw new StoreException("deleteStore failed - store doesn't exist");
		}
	}
}
