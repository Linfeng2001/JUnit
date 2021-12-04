package com.vogella.junit5;

import org.junit.Assert;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class CompanyTest {

	private Company Sogeti = new Company(new Konto(500), "Sogeti");
	private String dummyServices = new String("");
	private String AIServices = new String("AI Services");
	private String randomSevices = new String ("randomServices");
	
	
	@Test 
	void checkCompanyBankBalance() {
		int expectedCompany = 500;
		
		assertEquals(expectedCompany, Sogeti.checkBankBalance(), "Bank balance is not as exoected");
	}
	
	@Test
	void addServices() {
		//Test should fail
		assertThrows(IllegalArgumentException.class, ()->{
			Sogeti.addService(AIServices);
		});
		
		assertThrows(IllegalArgumentException.class, ()->{
			Sogeti.addService(randomSevices);
		});
	}
	
	@Test
	void addDummyServices() {
		//Test should be successful
		assertThrows(IllegalArgumentException.class, ()->{
			Sogeti.addService(dummyServices);
		});
	}
	
	@Test
	void testNummberOfServices() {
		int expected = 2;
		Sogeti.addService(AIServices);
		Sogeti.addService(randomSevices);
		
		assertEquals(expected, Sogeti.getNumberOfServices());
	}
	
	@Test 
	void testNummberOfServicesWithDummy(){
		int expected = 2;
		Sogeti.addService(AIServices);
		Sogeti.addService(randomSevices);
		Sogeti.addService(dummyServices);
		
		assertEquals(expected, Sogeti.getNumberOfServices());
	}
	
	@Test
	void testCompanyGetMoney(){
		//company has 500 on bank
		int expected = 700;
		Customer customer = new Customer(new Konto(1000), "customer");
		
		customer.pay(200, Sogeti);
		//System.out.print(customer.getKonto().getBankBalance());
		//System.out.print(Sogeti.checkBankBalance());
		assertEquals(expected, Sogeti.checkBankBalance());
	}
	
	
	
	

}
