package com.qa.ims.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
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
        LOGGER.info("When was the order made? (yyyy-mm-dd): ");
        LocalDate date = LocalDate.parse(utils.getString());

        Map<Long, Integer> itemQuantities = IdQuantityMap();

        Order order = orderDAO.create(new Order(customerId, date));
        LOGGER.info("Order created.");
        return order;
    }

    /**
     * Adds item to an order.
     * @return
     */
    public Order addItem() {
        LOGGER.info("Please enter the ID of the item you'd like to add: ");
        Long id = utils.getLong();
        LOGGER.info("Please enter an item name: ");
        String name = utils.getString();
        LOGGER.info("Please enter the value of the item: ");
        Double value = utils.getDouble();
        // add to Item List
        LOGGER.info("Item successfully updated.");
        return order;
    }

    /**
     * Deletes item from an order.
     * @return
     */
    public Order deleteItem() {
        LOGGER.info("Please enter the ID of the item you would like to delete: ");
        Long id = utils.getLong();
        // Delete from Item List
        return orderDAO.delete(id);
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
            LOGGER.info("Item ID: " + current + "| How many of this item are in the order?");
            quantList.add(utils.getInteger());
        }

        return (Map<K, V>) zipToMap(idList, quantList);
    }

}


