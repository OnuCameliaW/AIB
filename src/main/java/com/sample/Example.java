package com.sample;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;


@Entity
public class Example {
	@Id
	private Integer Id;
	 protected String FirstName;
	
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
	 @Override
	    public String toString() {
	        return String.format("(%d, %d)", this.FirstName);
	    }
	
   
}
