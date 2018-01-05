package com.sample;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CustomerRuleObject {
    @Id
    private String firstName;
     
    private String lastName; 
     
    private String message = "";
     
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
     
 