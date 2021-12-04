package com.vogella.junit5;
import java.util.ArrayList;
import java.util.List;

public class Company {
	private Konto konto;
	private List<String> services;
	private final String companyName;
	
	public Company(Konto konto, String companyName) {
		this.companyName = companyName;
		this.konto = konto;
		services = new ArrayList <String> ();
	}
	//TODO
	//if service is already excist it should not be able to add
	public String addService(String serviceName) {
		if(!serviceName.isEmpty()) {
			//check if service already exist
			for(String service: services) {
				if(service.equals(serviceName)) {
					throw new IllegalArgumentException();
					}	
			}
			//new able to add to the list
			this.services.add(serviceName);
			return ("Service succesfull added");
		}
		throw new IllegalArgumentException();
	}
	
	public void printAllServices() {
		for(String service: services) {
			System.out.println(service);
		}
	}
	
	public void recievePayment(int payment) {
		int current = konto.getBankBalance();
		this.konto.setBankBalance(current + payment);
	}
	
	//this mehhod can be used for the test after pay
	public int checkBankBalance() {
		return this.konto.getBankBalance();
	}
	
	
	
	
	public int getNumberOfServices() {
		return services.size();
	}

	public Konto getKonto() {
		return konto;
	}

	public void setKonto(Konto konto) {
		this.konto = konto;
	}

	public List<String> getServices() {
		return services;
	}

	public void setServices(List services) {
		this.services = services;
	}

	public String getCompanyName() {
		return companyName;
	}
}
