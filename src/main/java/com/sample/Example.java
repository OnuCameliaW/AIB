package com.sample;

import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


@Entity
public class Example {
	@Id
	private Integer Id;
	public String FirstName;
	
	public Example() {
		super();
	} 
	public Example(String fn) {
		super();
		this.FirstName =  fn;
	} 
	public Integer getId() {
 		return this.Id;
	}
	public void setId(Integer Id) {
		this.Id = Id;
	}
	public void setFirstName(String fn) {
		this.FirstName = fn;
	}
	public String getFirstName() {
 		return this.FirstName;
	}
	  public String result(){
		  setFirstName("CamiLulu");
	      return "done";
	    }
   
}
