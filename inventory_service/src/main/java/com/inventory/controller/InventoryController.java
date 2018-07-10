package com.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.dao.Inventory;
import com.inventory.dao.InventoryRepository;

@RestController
@RequestMapping(value="/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryRepository inventoryRepository;
	
	@RequestMapping("/test")
    public String greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return "This is test::"+name;
    }
	
	@RequestMapping("/vehicles")
	public List<Inventory> listInventory() {
		return inventoryRepository.listAll();
	}
	
	@RequestMapping("/vehicles/type/{vehicleType}")
	public List<Inventory> findVehiclesByType(@PathVariable String vehicleType) {
		return inventoryRepository.findVehiclesByType(vehicleType);
	}
	
	@RequestMapping("/vehicle/{id}")
	public String deleteVehicle(@PathVariable String id) {
		int deleteStatus = inventoryRepository.deleteVehicleById(id);
		if(deleteStatus > 0){
			return "deleted";
		}else{
			return "not deleted";
		}
	}
	
	@RequestMapping("/vehicle/{make}/{color}/{type}/add")
	public String deleteVehicle(@PathVariable String make, @PathVariable String color, @PathVariable String type) {
		int insertStatus = inventoryRepository.addVihicle(make, type, color);
		if(insertStatus > 0){
			return "added";
		}else{
			return "not added";
		}
	}
	
	@RequestMapping("/vehicle/{id}/{make}/{color}/{type}/update")
	public String updateVehicle(@PathVariable String make, @PathVariable String color, @PathVariable String type, @PathVariable String id) {
		int updateStatus = inventoryRepository.updateVehicle(make, type, color,id);
		if(updateStatus > 0){
			return "updated";
		}else{
			return "not updated";
		}
	}

}
