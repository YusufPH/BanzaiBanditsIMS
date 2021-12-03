package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Orders;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Orders> {
    public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public Orders modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long orderId = resultSet.getLong("OrderID");
		Long customerID = resultSet.getLong("CustomerID");
        Long orderItemId = resultSet.getLong("ItemOrderID")
		Long itemID = resultSet.getLong("ItemID");
		Long amount  = resultSet.getLong("Amount");
		Double cost = amount * getPrice(itemID);

        ItemsDAO itemDao = new ItemsDAO();
		Item item = itemDao.read(itemId)
        List<Item> items = Arrays.asList(item);
		return new Orders (orderID, customerID, orderItemId, itemID, items);
	}

    public Double getPrice(Long itemId) {
		ItemsDAO items = new ItemsDAO();
		Double price = items.read(itemId).getValue();
		return price;
	}

    /**
	 * Reads all item orders from the database
	 * 
	 * @return A list of item orders
	 */
	@Override
	public List<Orders> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders o join ItemOrders io on o.OrderID = io.OrderID");) {
			List<Orders> orders = new ArrayList<>();
			while (resultSet.next()) {
				orders.add(modelFromResultSet(resultSet));
			}
			return orders;
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

    public Orders readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orders o join ItemOrders io on o.OrderID = io.OrderID ORDER BY io.ItemOrderID DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}





}