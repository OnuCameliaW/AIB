package com.sample;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.kie.api.*;

public class ProductController {
     private EntityManager em;
	public ProductController(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
 		em = emf.createEntityManager();
	}
	
	public long getTotalProfit() {
		Object productProfit = em.createQuery("SELECT SUM(p.NetIncome) FROM Product p").getSingleResult();
		return (long)productProfit;
	}
	public long getGrossProfit() {
		Object productGrossProfit = em.createQuery("SELECT SUM(p.GrossIncome) FROM Product p").getSingleResult();
		return (long)productGrossProfit;
	}
	public List<Product> getProductsList() {
		List<Product> products = em.createQuery("SELECT p FROM Product p").getResultList();
		return products;
	}
	
}
