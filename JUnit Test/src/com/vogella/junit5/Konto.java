package com.vogella.junit5;
public class Konto {
	private int bankBalance;
	
	
	public Konto(int KontoStand) {
		this.bankBalance = KontoStand;
	}


	public int getBankBalance() {
		return bankBalance;
	}


	public void setBankBalance(int bankBalance) {
		this.bankBalance = bankBalance;
	}
	
	
}
