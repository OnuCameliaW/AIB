package com.sample;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

/**
 * ID class for entity: Example
 *
 */ 
public class ExamplePK  implements Serializable {   
   
	         
	private String Name;         
	private Integer Id;
	private static final long serialVersionUID = 1L;

	public ExamplePK() {}

	

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
	
   
	/*
	 * @see java.lang.Object#equals(Object)
	 */	
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}
		if (!(o instanceof ExamplePK)) {
			return false;
		}
		ExamplePK other = (ExamplePK) o;
		return true
			&& (getName() == null ? other.getName() == null : getName().equals(other.getName()))
			&& (getId() == null ? other.getId() == null : getId().equals(other.getId()));
	}
	
	/*	 
	 * @see java.lang.Object#hashCode()
	 */	
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (getName() == null ? 0 : getName().hashCode());
		result = prime * result + (getId() == null ? 0 : getId().hashCode());
		return result;
	}
   
   
}
