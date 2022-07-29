package com.qa.ims.persistence.dao;


import java.util.ArrayList;
import java.util.List;

import com.qa.ims.persistence.domain.Customer;
import com.qa.ims.utils.DBUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CustomerDAOTest {

	private final CustomerDAO DAO = new CustomerDAO();

	@BeforeEach
	public void setup() {
		DBUtils.connect(); // connect to db, then initialise with some test data
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "chris", "perrins");
		final Customer actual =  DAO.create(created);
		assertEquals(created, actual);
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(1L, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}

//	@Test()
//	public void testReadLatest() {
////	assertEquals(new Customer(1L, "Jordan", "Harrison"), DAO.readLatest());

//	}

	@Test
	public void testReadLatest() {
		assertEquals(new Customer(1L, "jordan", "harrison"), DAO.readLatest());
// 		that is JUnit 4 -- in JUnit 5 we do assertThrows
//
//		e.g. assertThrows(RuntimeException.class, () -> {
//			repository.readAll();
//		});
	}

	@Test
	public void testRead() {
		final Long ID = 1L;
		assertEquals(new Customer(ID, "jordan", "harrison"), DAO.read(ID));
	}

	@Test
	public void testUpdate() {
		final Customer updated = new Customer(1L, "chris", "perrins");
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDelete() {
		assertEquals(1L, DAO.delete(1L));
	}
}
