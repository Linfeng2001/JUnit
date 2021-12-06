package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KontoTest {
	private Konto konto = new Konto(1000);

	@Test
	void testGetBankBalance() {
		int expected = 1000;
		
		assertEquals(expected, konto.getBankBalance());
	}
	
	@Test
	void testSetBankBalance() {
		konto.setBankBalance(5);
		
		assertTrue(konto.getBankBalance() == 5);
		
	}

}
