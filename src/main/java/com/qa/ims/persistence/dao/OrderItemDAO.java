package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
     * @param id - id of the item
     */

    public int deleteItem(Long id) {
        try (Connection connection = DBUtils.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "DELETE FROM order_item WHERE id = ?");
        ) {
            statement.setLong(1, id);
            return statement.executeUpdate();
        } catch (Exception e) {
            LOGGER.debug(e);
            LOGGER.error(e.getMessage());
        }
        return 0;
    }

}


