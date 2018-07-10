package com.inventory.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class InventoryRowMapper implements RowMapper<Inventory> {
	
	@Override
	public Inventory mapRow(ResultSet rs, int rowNum) throws SQLException {
		Inventory inventory = new Inventory();
		inventory.setId(rs.getInt("id"));
		inventory.setColor(rs.getString("color"));
		inventory.setMake(rs.getString("make"));
		inventory.setType(rs.getString("vehicle_type"));
		return inventory;
	}

}
