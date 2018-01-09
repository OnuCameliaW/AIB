package com.sample;
import javax.persistence.*;

@Entity
public class Product {
	@Id
	public Integer Id;
	public String Name;
	public Integer NetIncome;
	public Integer GrossIncome;
	
	public Product() {
		super();
	}
	public Product(String name, Integer net_income, Integer gross_income) {
		super();
		this.Name = name;
		this.NetIncome = net_income;
		this.GrossIncome = gross_income;
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
	public Integer getGrossIncome() {
 		return this.NetIncome;
	}
	public void setGrossIncome(Integer gross_income) {
		this.GrossIncome = gross_income;
	}	
}
