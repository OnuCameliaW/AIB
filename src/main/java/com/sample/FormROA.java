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
     public ProductController pc = new ProductController();
     public ShareholderController sc = new ShareholderController();
     public AssetController ac = new AssetController();
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
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
  		em = emf.createEntityManager();
  		
    	ks = KieServices.Factory.get();   	
        kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");    	   	 		
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
	public void calculateROA() {
		this.profit = pc.getTotalProfit();
		this.assetsPrice = ac.getTotalAssetPrice();
		if(this.assetsPrice != 0) {
			this.ROA = (this.profit / this.assetsPrice) * 100;
		}
	}
	public void calculateROE() {
		this.profit = pc.getTotalProfit();
		this.totalEquity = sc.getTotaEquity();
		if(this.totalEquity != 0) {
			this.ROE = (this.profit / this.totalEquity) * 100;
		}
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
}
