package com.sample;
import javax.persistence.*;

@Entity
public class Product {
	@Id
	public Integer Id;
	public String Name;
	public Integer NetIncome;

	public Product() {
		super();
	}
	public Product(String name, Integer net_income) {
		super();
		this.Name = name;
		this.NetIncome = net_income;
	}
	public Integer getId() {
 		return this.Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}	
	public String getName() {
 		return this.Name;
	}
	public void setName(String name) {
		this.Name = name;
	}	
	public Integer getNetIncome() {
 		return this.NetIncome;
	}
	public void setNetIncome(Integer net_income) {
		this.NetIncome = net_income;
	}	
}
