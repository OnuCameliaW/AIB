package com.sample;
import javax.persistence.*;

@Entity
public class Shareholder {
	@Id
	public Integer Id;
	public String Name;
	public Integer Equity;
	public Integer Dividend;
	
	public Shareholder() {
		super();
	}
	public Shareholder(String name, Integer equity, Integer dividend) {
		super();
		this.Name = name;
		this.Equity = equity;
		this.Dividend = dividend;
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
	public Integer getEquity() {
 		return this.Equity;
	}
	public void setEquity(Integer equity) {
		this.Equity = equity;
	}	
	public Integer getDividend() {
 		return this.Dividend;
	}
	public void setDividend(Integer dividend) {
		this.Dividend = dividend;
	}	
}
