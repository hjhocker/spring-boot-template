package org.test.demo.rest.response;

public class Statement {

	private String name;

	private String startDate;

	private String endDate;

	private String currentBalance;

	private String balanceLastStatemet;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getBalanceLastStatemet() {
		return balanceLastStatemet;
	}

	public void setBalanceLastStatemet(String balanceLastStatemet) {
		this.balanceLastStatemet = balanceLastStatemet;
	}

}
