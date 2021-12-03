package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.ItemsDAO;
import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.Utils;

/**
 * Takes in item details for CRUD functionality
 *
 */
public class ItemController implements CrudController<Items> {
    
    public static final Logger LOGGER = LogManager.getLogger();

	private ItemsDAO itemDAO;
	private Utils utils;

	public ItemController(ItemsDAO itemDAO, Utils utils) {
    
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}
    
    /**
	 * Reads all items to the logger
	 * 
	 * @return List of Items
	 */
	@Override
	public List<Items> readAll() {
		List<Items> items = itemDAO.readAll();
		for (Items item : items) {
			LOGGER.info(item.toString());
		}
		return items;
	}

    /**
	 * Creates a Item by taking in user input
	 * 
	 * @return a new Item
	 */
	@Override
	public Items create() {
		LOGGER.info("Please enter a name");
		String name = utils.getString();
		LOGGER.info("Please enter a value");
		Double value = utils.getDouble();
		LOGGER.info("Please enter a stock amount");
		int stock = utils.getDouble().intValue();
		Items item = itemDAO.create(new Items(name, stock, value));
		LOGGER.info("Item created");
		return item;
	}

    /**
	 * Updates an existing Item by taking in user input
	 * 
	 * @return The updated Item
	 */
	@Override
	public Items update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		Long id = utils.getLong();
		LOGGER.info("Please enter a name");
		String name = utils.getString();
		LOGGER.info("Please enter a value");
		Double value = utils.getDouble();
		LOGGER.info("Please enter a stock amount");
		int stock = utils.getDouble().intValue();
		Items item = itemDAO.update(new Items(id, name, stock, value));
		LOGGER.info("Item Updated");
		return item;
	}

    /**
	 * Deletes an existing item by the id of the item
	 * 
	 * @return number of items deleted
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		Long id = utils.getLong();
		return itemDAO.delete(id);
	}







}