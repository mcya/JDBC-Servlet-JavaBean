package com.changzhou.ecport.entity;

public class Order {
	private String oriderId;
	private String oriderPrice;
	private String oriderStats;
	private String oriderPayway;
	
	public Order(String oriderId, String oriderPrice, String oriderStats,
			String oriderPayway) {
		super();
		this.oriderId = oriderId;
		this.oriderPrice = oriderPrice;
		this.oriderStats = oriderStats;
		this.oriderPayway = oriderPayway;
		
	}
	public Order() {
		super();
	}
	public String getOriderId() {
		return oriderId;
	}
	public void setOriderId(String oriderId) {
		this.oriderId = oriderId;
	}
	public String getOriderPrice() {
		return oriderPrice;
	}
	public void setOriderPrice(String oriderPrice) {
		this.oriderPrice = oriderPrice;
	}
	public String getOriderStats() {
		return oriderStats;
	}
	public void setOriderStats(String oriderStats) {
		this.oriderStats = oriderStats;
	}
	public String getOriderPayway() {
		return oriderPayway;
	}
	public void setOriderPayway(String oriderPayway) {
		this.oriderPayway = oriderPayway;
	}
	
}
