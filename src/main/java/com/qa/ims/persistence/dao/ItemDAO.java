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

import com.qa.ims.persistence.domain.Items;
import com.qa.ims.utils.DBUtils;

public class ItemsDAO implements Dao<Items> {

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public Items modelFromResultSet(ResultSet resultSet) throws SQLException {
        Long itemID = resultSet.getLong("ItemID");
        String itemName = resultSet.getString("ItemName");
        int stockAmount = resultSet.getInt("StockAmount");
        Double price = resultSet.getDouble("Price");
        return new Items(itemID, itemName, stockAmount, price);
    }

    /**
     * Reads all customers from the database
     *
     * @return A list of customers
     */
    @Override
    public List<Items> readAll() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items");) {
            List<Items> items = new ArrayList<>();
            while (resultSet.next()) {
                items.add(modelFromResultSet(resultSet));
            }
            return items;
        } catch (SQLException e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return new ArrayList<>();
    }

    public Items readLatest() {
        try (Connection connection = DBUtils.getInstance().getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM items ORDER BY ItemID DESC LIMIT 1");) {
            resultSet.next();
            return modelFromResultSet(resultSet);
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Creates a customer in the database
     *
     * @param - takes in a customer object. id will be ignored
     */
    @Override
    public Items create(Items items) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("INSERT INTO items(order_item, price) VALUES (?, ?)");) {
            statement.setString(1, items.getName());
            statement.setDouble(2, items.getValue());
            statement.executeUpdate();
            return readLatest();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    @Override
    public Items read(Long ItemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM items WHERE ItemID = ?");) {
            statement.setLong(1, ItemID);
            try (ResultSet resultSet = statement.executeQuery();) {
                resultSet.next();
                return modelFromResultSet(resultSet);
            }
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Updates a customer in the database
     *
     * @param - takes in a customer object, the id field will be used to
     *                 update that customer in the database
     * @return
     */
    @Override
    public Items update(Items items) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection
                     .prepareStatement("UPDATE items SET order_item = ?, price = ? WHERE ItemID = ?");) {
            statement.setString(1, items.getName());
            statement.setDouble(2, items.getValue());
            statement.setLong(3, items.getId());
            statement.executeUpdate();
            return read(items.getId());
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Deletes a customer in the database
     *
     * @param - id of the customer
     */
    @Override
    public int delete(long itemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement("DELETE FROM items WHERE itemID = ?");) {
            statement.setLong(1, itemID);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}