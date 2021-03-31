package com.petrenko.lab0302.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.petrenko.lab0302.entity.Item;

public class ItemDao {
	private static ArrayList<Item> items = new ArrayList<Item>();

	// Викликаємо через DaoManager.initialize
	static void initialize(){
		try {
			DaoManager.createTableIfMissing("item",
					"code varchar(10) PRIMARY KEY, "
					+ "name varchar(255), "
					+ "price bigint");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static List<Item> getItems() {
		if(!DaoManager.useLocal) {
			try {
				Connection conn = DaoManager.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet result = stmt.executeQuery("select * from item");
				items.clear();
				Item curItem;
				while(result.next()) {
					items.add(curItem = new Item());
					curItem.code = result.getString("code");
					curItem.name = result.getString("name");
					curItem.price = result.getLong("price");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public static List<Item> getItems(String code) {
		if(DaoManager.useLocal)
			return null;
		else {
			try {
				Connection conn = DaoManager.getConnection();
				PreparedStatement stmt = conn.prepareStatement("select * from item where code = ?");
				stmt.setString(1, code);
				ResultSet result = stmt.executeQuery();
				items.clear();
				Item curItem;
				while(result.next()) {
					items.add(curItem = new Item());
					curItem.code = result.getString("code");
					curItem.name = result.getString("name");
					curItem.price = result.getLong("price");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return items;
	}
	
	public static void addItem(Item item) {
		if(DaoManager.useLocal)
			items.add(item);
	}
}
