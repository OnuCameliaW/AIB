package com.sample;
import javax.persistence.*;

@Entity
public class Debt {
	@Id
	public Integer Id;
	public String Description;
	public Integer Amount;

	public Debt() {
		super();
	}
	public Debt(String description, Integer amount) {
		super();
		this.Description = description;
		this.Amount = amount;
	}
	public Integer getId() {
 		return this.Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}	
	public String getDescription() {
 		return this.Description;
	}
	public void setDescription(String description) {
		this.Description = description;
	}	
	public Integer getAmount() {
 		return this.Amount;
	}
	public void setAmount(Integer amount) {
		this.Amount = amount;
	}	
}
