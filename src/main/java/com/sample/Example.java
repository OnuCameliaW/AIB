package com.sample;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Example
 *
 */
public class Example implements Serializable {

	 
	private String Name; 
	private Integer Id;
	private static final long serialVersionUID = 1L;	
	public Example() {
		super();
	} 
	   
	public String getName() {
 		return this.Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}
	   
	public Integer getId() {
 		return this.Id;
	}

	public void setId(Integer Id) {
		this.Id = Id;
	}
	
   
}
