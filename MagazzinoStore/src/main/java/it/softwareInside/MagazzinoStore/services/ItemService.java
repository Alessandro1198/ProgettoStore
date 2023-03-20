package it.softwareInside.MagazzinoStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.MagazzinoStore.repository.ItemRepository;
import it.softwareInside.MagazzinoStore.models.Item;

@Service
public class ItemService {
	
	@Autowired
	ItemRepository itemRepository;
	
	
	public boolean addItem(Item item) {
		if(item == null)
			return false;
		
		try {
			itemRepository.save(item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean removeItemById(int id) {
		if(id < 0)
			return false;
		
		try {
			Item item = itemRepository.findById(id).get();
			itemRepository.delete(item);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean update(Item item) {
		return addItem(item);
	}
	
	public Iterable<Item> listAllItem() {
		return itemRepository.findAll();
	}
	
	public double getTotalPrice() {
		double tot = 0;
		
		for (Item item : itemRepository.findAll()) {
			tot += item.getCosto();
		}
		
		return tot;
	}
}
