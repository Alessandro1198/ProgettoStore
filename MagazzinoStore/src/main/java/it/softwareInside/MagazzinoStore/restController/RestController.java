package it.softwareInside.MagazzinoStore.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.softwareInside.MagazzinoStore.models.Item;
import it.softwareInside.MagazzinoStore.services.ItemService;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping("/addItem")
	public boolean addItem(@RequestBody() Item item) {
		return itemService.addItem(item);
	}
	
	@DeleteMapping("/removeItem")
	public boolean removeItem(@RequestParam int id) {
		return itemService.removeItemById(id);
	}
	
	@PostMapping("/updateItem")
	public boolean updateItem(@RequestBody Item item) {
		return itemService.update(item);
	}
	
	@GetMapping("/getListOfItems")
	public Iterable<Item> getListOfItems(){
		return itemService.listAllItem();
	}
	
	@GetMapping("/getTot")
	public double getTotalCost() {
		return itemService.getTotalPrice();
	}
}
