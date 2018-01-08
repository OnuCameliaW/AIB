package com.sample;

import java.util.ArrayList;
import java.util.List;
import javax.faces.event.ActionEvent;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.kie.api.*;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class FormROA {
	 public KieServices ks;
     public KieContainer kContainer;
     public KieSession kSession;
	
     private EntityManager em;
     public Product Product = new Product();
	 public List<Product> Products =new ArrayList<Product>();
	 public List<Asset> Assets =new ArrayList<Asset>();
	 public List<Shareholder> Shareholders =new ArrayList<Shareholder>();
	 public long profit = 0;	
	 public long assetsPrice = 0;	
	 public long totalEquity = 0;
	 public long ROA = 0;
	 public long ROE = 0;
	 public String ROAMessage = "NaN";
	 public String ROEMessage = "NaN";
	 
     public FormROA() {
    	ks = KieServices.Factory.get();   	
        kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");
    	   	 
 		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
 		em = emf.createEntityManager();
 		
     }
 	public void setROAMessage(String message) {
 		this.ROAMessage = message;
 	}
 	public String getROAMessage() {
 		return this.ROAMessage;
 	}
	public void setROEMessage(String message) {
 		this.ROEMessage = message;
 	}
 	public String getROEMessage() {
 		return this.ROEMessage;
 	}
	public void getTotalProfit() {
		Object ProductProfit = em.createQuery("SELECT SUM(p.NetIncome) FROM Product p").getSingleResult();
		this.profit = (long)ProductProfit;
	}
	public void getTotalAssetPrice() {
		Object AssetsPrice = em.createQuery("SELECT SUM(a.Price) FROM Asset a").getSingleResult();
		this.assetsPrice = (long)AssetsPrice;
	}
	public void getTotaEquity() {
		Object TotalEquity= em.createQuery("SELECT SUM(s.Equity) FROM Shareholder s").getSingleResult();
		this.totalEquity = (long)TotalEquity;
	}
	public void calculateROA() {
		getTotalProfit();
		getTotalAssetPrice();
		if(this.assetsPrice != 0) {
			this.ROA = (this.profit / this.assetsPrice) * 100;
		}
	}
	public void calculateROE() {
		getTotalProfit();
		getTotaEquity();
		if(this.totalEquity != 0) {
			this.ROE = (this.profit / this.totalEquity) * 100;
		}
	}
	public void getProductsList() {
		this.Products = em.createQuery("SELECT p FROM Product p").getResultList();
		System.out.println("merge");
	}
	public Product getProduct() {
		return this.Product;
	}
	public void setProduct(Product product) {
		this.Product = product;
	}
	public List<Asset> getAssets() {
		return Assets;
	}
	public void setAssets(List<Asset> assets) {
		this.Assets = assets;
	}
	
	public void addProduct(ActionEvent event) {
		this.em.getTransaction().begin();
		this.em.persist(this.Product);
		this.em.getTransaction().commit();
		kSession.insert(this);
		calculateROA();
		calculateROE();
		kSession.fireAllRules();	
	}    
     public void Close_Entity() {
         em.close();
     }
     public String result(){
	      return "done";
	    }
}
