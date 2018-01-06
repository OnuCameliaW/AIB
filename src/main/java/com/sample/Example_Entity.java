package com.sample;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Example_Entity {
     private EntityManager em;
	 public Example Ex_add;
	 
	 public void setExample(Example e) {
	        this.Ex_add = e;
	    } 
	 public Example getExample() {
	        return this.Ex_add;
	    } 
     public Example_Entity() {
 		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
 		em = emf.createEntityManager();
     }
     public void Add_Entity(ActionEvent event) {
    	 Ex_add =new Example("CamiTest1");
  		em.getTransaction().begin();
          em.persist(Ex_add);
        em.getTransaction().commit();
         Close_Entity();
     }
     public void Get_Entity() {
    	 List<Example> lst=em.createQuery("Select e FROM Example e").getResultList();
         for(Example f:lst)
         	System.out.println(f.FirstName);

     }
     public void Close_Entity() {
         em.close();
     }
     public String result(){
	      return "done";
	    }
}
