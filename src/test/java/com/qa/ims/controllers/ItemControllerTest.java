package com.qa.ims.controllers;


import java.util.ArrayList;
import java.util.List;

import com.qa.ims.controller.ItemController;
import com.qa.ims.controller.OrderController;
import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.persistence.domain.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.qa.ims.utils.Utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(value = MockitoExtension.class)
public class ItemControllerTest {

    @Mock
    private Utils utils;

    @Mock
    private ItemDAO dao;

    @InjectMocks
    private ItemController controller;

    //ONLY RUN WHEN SCHEMA HAS BEEN RE-RUN AS SPECIFIED IN README
    //UNCOMMENT AND THEN RUN
//    @Test
//    public void testCreate() {
//        final String name = "Bat";
//        final Double value = 9.99;
//        final Item created = new Item(name, value);
//
//        Mockito.when(utils.getString()).thenReturn(name);
//        Mockito.when(utils.getDouble()).thenReturn(value);
//        Mockito.when(dao.create(created)).thenReturn(created);
//
//        assertEquals(created, controller.create());
//
//        Mockito.verify(utils, Mockito.times(1)).getString();
//        Mockito.verify(utils, Mockito.times(1)).getDouble();
//        Mockito.verify(dao, Mockito.times(1)).create(created);
//    }
//
    //ONLY RUN WHEN SCHEMA HAS BEEN RE-RUN AS SPECIFIED IN README
    //UNCOMMENT AND THEN RUN
//    @Test
//    public void testReadAll() {
//        List<Item> items = new ArrayList<>();
//        items.add(new Item(1L, "Bat", 9.99));
//
//        Mockito.when(dao.readAll()).thenReturn(items);
//
//        assertEquals(items, controller.readAll());
//
//        Mockito.verify(dao, Mockito.times(1)).readAll();
//    }

//    @Test
//    public void testUpdate() {
//        Item updated = new Item(1L, "Bat", 9.99);
//
//        Mockito.when(this.utils.getLong()).thenReturn(1L);
//        Mockito.when(this.utils.getString()).thenReturn(updated.getName());
//        Mockito.when(this.utils.getDouble()).thenReturn(updated.getValue());
//        Mockito.when(this.dao.update(updated)).thenReturn(updated);
//
//        assertEquals(updated, this.controller.update());
//
//        Mockito.verify(this.utils, Mockito.times(1)).getLong();
//        Mockito.verify(this.utils, Mockito.times(1)).getString();
//        Mockito.verify(this.utils, Mockito.times(1)).getDouble();
//        Mockito.verify(this.dao, Mockito.times(1)).update(updated);
//    }

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

}


