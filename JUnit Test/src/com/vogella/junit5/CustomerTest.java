package com.vogella.junit5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	private Customer customer = new Customer(new Konto(1000), "customer");
	private Company Sogeti = new Company(new Konto(1000), "Sogeti");
	
	@Test
	void checkCustomerBankBalance() {
		int expectedCustomer = 10000;
		
		assertEquals(expectedCustomer, customer.checkBankBalance(), "Bank balance is not as exoected");
		
	}
	@Test
	//able to buy
	void testBuyService1(){
		Sogeti.addService("AIServices");
		customer.buyService("AIServices", Sogeti, 300);
		int expected = 1;
		
		assertEquals(expected, customer.getNummberOfServices());
	}
	
	@Test
	//has not enough to pay
	void testBuyServices2() {
		Sogeti.addService("AIServices");
		customer.getKonto().setBankBalance(100);
		customer.buyService("AIServices", Sogeti, 500);
		int expected = 1;
		
		assertEquals(customer.getNummberOfServices(), expected);
	}
	
	@Test
	//can not find the service which we need
	void testBuyServices3() {
		Sogeti.addService("AIServices");
		customer.buyService("CloudServices", Sogeti, 100);
		int expected = 1;
		
		assertEquals(expected, customer.getNummberOfServices());
	
	}
	@Test
	void testPay() {
		int expected = 900;
		customer.pay(100, Sogeti);
		
		assertEquals(expected, customer.getKonto().getBankBalance());
	}

}
