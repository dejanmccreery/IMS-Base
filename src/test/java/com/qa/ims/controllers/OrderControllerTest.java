//package com.qa.ims.controllers;
//
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.qa.ims.controller.OrderController;
//import com.qa.ims.persistence.dao.OrderDAO;
//import com.qa.ims.persistence.domain.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import com.qa.ims.persistence.domain.Customer;
//import com.qa.ims.utils.Utils;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(value = MockitoExtension.class)
//public class OrderControllerTest {
//
//    @Mock
//    private Utils utils;
//
//    @Mock
//    private OrderDAO dao;
//
//    @InjectMocks
//    private OrderController controller;
//
//    @Test
//    public void testCreate() {
//        final String F_NAME = "barry", L_NAME = "scott";
//        final Customer created = new Order(F_NAME, L_NAME);
//
//        Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
//        Mockito.when(dao.create(created)).thenReturn(created);
//
//        assertEquals(created, controller.create());
//
//        Mockito.verify(utils, Mockito.times(2)).getString();
//        Mockito.verify(dao, Mockito.times(1)).create(created);
//    }
//
//    @Test
//    public void testReadAll() {
//        List<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(1L, "jordan", "harrison"));
//
//        Mockito.when(dao.readAll()).thenReturn(customers);
//
//        assertEquals(customers, controller.readAll());
//
//        Mockito.verify(dao, Mockito.times(1)).readAll();
//    }
//
//    @Test
//    public void testUpdate() {
//        Customer updated = new Customer(1L, "chris", "perrins");
//
//        Mockito.when(this.utils.getLong()).thenReturn(1L);
//        Mockito.when(this.utils.getString()).thenReturn(updated.getFirstName(), updated.getSurname());
//        Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//        assertEquals(updated, this.controller.update());
//
//        Mockito.verify(this.utils, Mockito.times(1)).getLong();
//        Mockito.verify(this.utils, Mockito.times(2)).getString();
//        Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//    }
//
//    @Test
//    public void testDelete() {
//        final long ID = 1L;
//
//        Mockito.when(utils.getLong()).thenReturn(ID);
//        Mockito.when(dao.delete(ID)).thenReturn(1);
//
//        assertEquals(1L, this.controller.delete());
//
//        Mockito.verify(utils, Mockito.times(1)).getLong();
//        Mockito.verify(dao, Mockito.times(1)).delete(ID);
//    }
//
//}
//
