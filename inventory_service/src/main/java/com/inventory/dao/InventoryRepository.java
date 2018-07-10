package com.inventory.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Inventory> listAll() {
		return jdbcTemplate.query("select * from VEHICLES_INVENTORY", new InventoryRowMapper());
	}
	
	public List<Inventory> findVehiclesByType(String vehicleType) {
		return jdbcTemplate.query("select * from VEHICLES_INVENTORY where vehicle_type =?", new Object[] {vehicleType}, new InventoryRowMapper());
	}
	
	public int deleteVehicleById(String id) {
		return jdbcTemplate.update("delete from VEHICLES_INVENTORY where id =?", new Object[] {id});
	}
	
	public int addVihicle(String make, String type, String color) {
		return jdbcTemplate.update("insert into VEHICLES_INVENTORY (make, vehicle_type, color) " + "values(?,  ?, ?)",
				new Object[] { make, type, color });
	}
	
	public int updateVehicle(String make, String type, String color, String id) {
		return jdbcTemplate.update("update VEHICLES_INVENTORY " + " set make = ?, vehicle_type = ?, color = ? " + " where id = ?",
				new Object[] { make, type, color, id });
	}

}
