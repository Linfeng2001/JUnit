package com.vogella.junit5;

public class Main {
	public static Company sogeti = new Company(new Konto(100), "sogeti");
	

	public static void main(String [] args) {
		System.out.println(sogeti.addService(new String("")));
		sogeti.addService("AI Services");
		sogeti.addService("Cloud Services");
		sogeti.addService("random Services");
		sogeti.printAllServices();
		
		
	}

}
