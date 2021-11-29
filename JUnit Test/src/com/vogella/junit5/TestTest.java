package com.vogella.junit5;
import org.junit.Assert;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestTest {
	private Customer customer1  = new Customer(new Konto(1000), "customer1");
	private Company Sogeti = new Company(new Konto(500), "Sogeti");
	
	@Test
	void checkCustomerBankBalance() {
		int expectedCustomer = 10000;
		
		assertEquals(expectedCustomer, customer1.checkBankBalance(), "Bank balance is not as exoected");
		
	}
	@Test 
	void checkCompanyBankBalance() {
		int expectedCompany = 500;
		
		assertEquals(expectedCompany, Sogeti.checkBankBalance(), "Bank balance is not as exoected");
	}
	
	@Test
	void addService() {
		String dummyServices = new String("");
		String AIServices = new String("AI Services");
		String randomSevices = new String ("randomServices");
		
		assertEquals(Sogeti.getNumberOfServices(), 0);
		
		//now we add some services
		assertThrows(IllegalArgumentException.class, ()->{
			Sogeti.addService(AIServices);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			Sogeti.addService(randomSevices);
		});
		
		
		assertThrows(IllegalArgumentException.class, ()->{
			Sogeti.addService(dummyServices);
		});
		
		
		//you can not add same service twice
//		Sogeti.addService(AIServices);
//		Sogeti.addService(dummyServices);
		
		//check number of services
		
		
		
	}
	//void testBuyService
	//void testPay
	//void testCompanyGetMoney
	//
	

}
