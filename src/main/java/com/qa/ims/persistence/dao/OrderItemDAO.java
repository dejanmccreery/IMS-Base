package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.DBUtils;

public class OrderItemDAO {

    public static final Logger LOGGER = LogManager.getLogger();


    /**
     * Adds an item to the order_item table
     *
     * @param orderItem - takes in an order item object
     */
    public OrderItem addItem(OrderItem orderItem) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO order_item(order_id, item_id, quantity) VALUES (?, ?, ?)");
        ) {
            statement.setLong(1, orderItem.getOrderID());
            statement.setLong(2, orderItem.getItemID());
            statement.setInt(3, orderItem.getQuantity());
            statement.executeUpdate();
            return orderItem;
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    /**
     * Deletes an item in the database
     *
     * @param orderID - id of the order
     * @param itemID - id of the item
     */

    public int deleteItem(Long orderID, Long itemID) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                "DELETE FROM order_item WHERE order_id = ? AND item_id = ?");
        ) {
            statement.setLong(1, orderID);
            statement.setLong(2, itemID);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}


