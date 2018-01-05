package com.sample;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.xmlbeans.impl.piccolo.xml.EntityManager;

public class Example_Add_Entity {
	 private static final String PERSISTENCE_UNIT_NAME = "Example";
     private static EntityManagerFactory factory;

     public Example_Add_Entity() {

        factory = Persistence.createEntityManagerFactory("ProjDrools");
        javax.persistence.EntityManager em = factory.createEntityManager();
        
        
        ((javax.persistence.EntityManager) em).getTransaction().begin();
    	Example example_add =new Example("Cami");
        ((javax.persistence.EntityManager) em).persist(example_add);
        ((javax.persistence.EntityManager) em).getTransaction().commit();
        
        List<Example> lst=((javax.persistence.EntityManager) em).createQuery("Select e FROM Example e").getResultList();
        for(Example f:lst)
        	System.out.println(f.FirstName);

          ((EntityManagerFactory) em).close();
     }
}
