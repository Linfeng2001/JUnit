package com.vogella.junit5;

public class Customer {
	private Konto konto;
	private String CustomerName;
	
	public Customer(Konto konto, String Name) {
		this.konto = konto;
		this.CustomerName = Name;
	}
	
	//heler method: check if the svervice that customer need is available 
	private boolean serviceAvailable(String serviceName, Company company) {
		if(serviceName.isEmpty() || company.getNumberOfServices() == 0) {
			return false;
		}
	
		for(String service : company.getServices()) {
			if(service.equals(serviceName)) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
	public String buyService(String serviceName, Company company, int price) {
		if(serviceAvailable(serviceName, company) && !notEnoughToPay(price)) {
			pay(price, company);
			return "succesfull bought " + serviceName;
		}else {
			return "unsuccesfull";
		}
	}
	
	
	//hleper method for pay
	private boolean notEnoughToPay(int payment) {
		if(konto.getBankBalance() <= 0 || konto.getBankBalance() < payment) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String pay(int payment, Company company) {
		if(notEnoughToPay(payment)) {
			return "You have not enough money on your accout";
		}
		else {
			int currentKontostand = this.konto.getBankBalance();
			this.konto.setBankBalance(currentKontostand - payment); 
			company.recievePayment(payment);
			return "succesfull payed";
		}
	}
	
	
	//this mehhod can be used for the test after pay
	public int checkBankBalance() {
		return this.konto.getBankBalance();
	}
	
	
	
	


	public Konto getKonto() {
		return konto;
	}


	public void setKonto(Konto konto) {
		this.konto = konto;
	}


	public String getCustomerName() {
		return CustomerName;
	}


	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	
	
	
}
