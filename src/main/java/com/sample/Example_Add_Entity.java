package com.sample;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.xmlbeans.impl.piccolo.xml.EntityManager;

public class Example_Add_Entity {
	 private static final String PERSISTENCE_UNIT_NAME = "Example";
     private static EntityManagerFactory factory;

     public Example_Add_Entity() {
          factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
          javax.persistence.EntityManager em = factory.createEntityManager();
          // Read the existing entries and write to console
//          Query q = em.createQuery("SELECT u FROM User u");
//          List<User> userList = q.getResultList();
//          for (User user : userList) {
//               System.out.println(user.Name);
//          }
          //System.out.println("Size: " + userList.size());

          // Create new user
          ((javax.persistence.EntityManager) em).getTransaction().begin();
          Example user = new Example();
          user.setName("Andi");
          ((javax.persistence.EntityManager) em).persist(user);
          ((javax.persistence.EntityManager) em).getTransaction().commit();

          em.close();
     }
}
