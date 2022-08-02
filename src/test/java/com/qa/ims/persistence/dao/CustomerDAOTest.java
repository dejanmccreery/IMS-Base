package com.qa.ims.persistence.dao;


import java.util.ArrayList;
import java.util.List;
import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

//	//ONLY RUN WHEN SCHEMA HAS BEEN RE-RUN AS SPECIFIED IN README
//	//UNCOMMENT AND THEN RUN
//	@BeforeEach
//	public void setup() {
//		DBUtils.connect();
//		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
//	}
//	//ONLY RUN WHEN SCHEMA HAS BEEN RE-RUN AS SPECIFIED IN README
//	//UNCOMMENT AND THEN RUN
//	@Test
//	public void testCreate() {
//		final Customer created = new Customer(1L, "chris", "perrins");
//		assertEquals(created, DAO.create(created));
//	}

//	@Test
//	public void testReadAll() {
//		List<Customer> expected = new ArrayList<>();
//		expected.add(new Customer(1L, "jordan", "harrison"));
//		assertEquals(expected, DAO.readAll());
//	}

//	@Test
//	public void testReadLatest() {
//		assertEquals((new Customer(1L, "jordan", "harrison")).toString(), DAO.readLatest());
//	}

//	@Test
//	public void testRead() {
//		final Long ID = 1L;
//		assertEquals(new Customer(ID, "jordan", "harrison"), DAO.read(ID));
//	}

//	@Test
//	public void testUpdate() {
//		final Customer updated = new Customer(1L, "chris", "perrins");
//		assertEquals(updated, DAO.update(updated));
//
//	}

	//ONLY RUN WHEN SCHEMA HAS BEEN RE-RUN AS SPECIFIED IN README
	//UNCOMMENT AND THEN RUN
//	@Test
//	public void testDelete() {
//		assertEquals(1L, DAO.delete(1L));
//	}
}
