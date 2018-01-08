package com.sample;
import javax.persistence.*;

@Entity
public class Asset {
	@Id
	private Integer Id;
	private String Name;
	private Integer Price;

	public Asset() {
		super();
	}
	public Asset(String name, Integer price) {
		super();
		this.Name = name;
		this.Price = price;
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
	public Integer getPrice() {
 		return this.Price;
	}
	public void setPrice(Integer price) {
		this.Price = price;
	}	
}
