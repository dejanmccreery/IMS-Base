package com.qa.ims.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.qa.ims.persistence.dao.CustomerDAO;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {

    public static final Logger LOGGER = LogManager.getLogger();

    private OrderDAO orderDAO;
    private Utils utils;

    public OrderController(OrderDAO orderDAO, Utils utils) {
        super();
        this.orderDAO = orderDAO;
        this.utils = utils;
    }

    /**
     * Reads all orders to the logger
     */
    @Override
    public List<Order> readAll() {
        List<Order> orders = orderDAO.readAll();
        for (Order order : orders) {
            LOGGER.info(order);
        }
        return orders;
    }

    /**
     * Creates an order by taking in user input
     */
    @Override
    public Order create() {
        LOGGER.info("Please enter the ID of the customer making the order: ");
        Long customerId = utils.getLong();

        if (!checkCustomerID(customerId)) return null;

        LOGGER.info("When was the order made? (yyyy-mm-dd): ");
        Date date = Date.valueOf(utils.getString());

        //creating order in order table
        Order order = orderDAO.create(new Order(customerId, date));

        //creating order items in order
        Map<Long, Integer> itemQuantities = IdQuantityMap();
        OrderItemDAO orderItemDAO = new OrderItemDAO();
        for (Map.Entry<Long, Integer> entry : itemQuantities.entrySet()) {
            Long itemID = entry.getKey();
            Integer quantity = entry.getValue();
            OrderItem oi = new OrderItem(order.getID(), itemID, quantity);
            orderItemDAO.addItem(oi);
            order.addOrderItem(oi);
        }

        LOGGER.info("Order created.");
        return order;
    }

    @Override
    public Order update() {
        LOGGER.info("Please enter the ID of the order you'd like to update: ");
        Long orderID = utils.getLong();

        if (!checkOrderID(orderID)) return null;

        Order order = this.orderDAO.read(orderID);

        OrderItemDAO orderItemDAO = new OrderItemDAO();
        LOGGER.info("How would you like to update your order?");
        LOGGER.info("[1] Add an item to the order ");
        LOGGER.info("[2] Delete an item from the order");
        LOGGER.info("Enter 1 or 2 to select ");
        Integer input = utils.getInteger();
        switch (input) {
            case 1:
                addItem(orderID, orderItemDAO, order);
                return order;
            case 2:
                deleteItem(orderID, orderItemDAO, order);
                break;
            default:
                LOGGER.info("Please enter valid input.");
                break;
        }

        return order;
    }

    /**
     * Adds item to an order.
     * @return
     */
    private void addItem(Long orderID, OrderItemDAO orderItemDAO, Order order) {
        LOGGER.info("Please enter the ID of the item you'd like to add: ");
        Long itemID = utils.getLong();

        if (!checkItemID(itemID, order)) return;

        LOGGER.info("Item ID: " + itemID + "| How many units of this item are in the order?");
        Integer quantity = utils.getInteger();

        OrderItem oi = new OrderItem(orderID, itemID, quantity);
        orderItemDAO.addItem(oi);
        order.addOrderItem(oi);
        LOGGER.info("Item successfully updated.");
    }

    /**
     * Deletes item from an order.
     * @return
     */
    private void deleteItem(Long orderID, OrderItemDAO orderItemDAO, Order order) {
        LOGGER.info("Please enter the ID of the item you would like to delete: ");
        Long itemID = utils.getLong();

        if (!checkItemID(itemID, order)) return;

        orderItemDAO.deleteItem(orderID, itemID);
        order.removeOrderItem(orderID, itemID);
        LOGGER.info("Item successfully deleted.");
    }

    /**
     * Deletes an existing order using the id of the order
     *
     * @return
     */
    @Override
    public int delete() {
        LOGGER.info("Please enter the ID of the order you would like to delete: ");
        Long id = utils.getLong();

        if (!checkOrderID(id)) return 0;

        return orderDAO.delete(id);
    }

    private <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
        return IntStream.range(0, keys.size()).boxed()
                .collect(Collectors.toMap(keys::get, values::get));
    }

    /**
     * Takes a list of items, and uses it to take in quantities for each item in the list.
     * Then zips them together into a map.
     * @return
     * @param <K> generic. used for Long ID in this case.
     * @param <V> generic. used for Integer Quantity in this case.
     */
    private <K,V> Map<K, V> IdQuantityMap(){

        LOGGER.info("Enter the IDs of the items in the Order as a comma-separated list: ");
        //split string input and create arraylist -- regex permits for whitespaces and commas
        List<String> intermediate = new ArrayList<String>(Arrays.asList(utils.getString().split("[\\s,]+")));
        //convert type from String to Long
        List<Long> idList = intermediate.stream().map(Long::parseLong).collect(Collectors.toList());

        //gathering quantities by looping across each ID in the list provided
        List<Integer> quantList = new ArrayList<>();
        for (int i = 0; i < idList.size(); i++) {
            Long current = idList.get(i);
            LOGGER.info("Item ID: " + current + "| How many units of this item are in the order?");
            quantList.add(utils.getInteger());
        }

        return (Map<K, V>) zipToMap(idList, quantList);
    }

    private boolean checkOrderID(Long id) {
        List<Order> orderList = orderDAO.readAll();
        if (!orderList.contains(id)) {
            LOGGER.info("Order does not exist");
            return false;
        }
        return true;
    }

    private boolean checkCustomerID(Long id) {
        CustomerDAO cd = new CustomerDAO();
        List<Customer> customers = cd.readAll();
        if (!customers.contains(id)) {
            LOGGER.info("Customer does not exist");
            return false;
        }
        return true;
    }

    private boolean checkItemID(Long id, Order order) {
        if (!order.getItems().contains(id)) {
            LOGGER.info("Item is not in order");
            return false;
        }
        return true;
    }

}


