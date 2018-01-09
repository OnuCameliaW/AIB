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

public class FormROIC {
	 public KieServices ks;
     public KieContainer kContainer;
     public KieSession kSession;
	
     private EntityManager em;
     public Product Product = new Product();
     public ProductController pc = new ProductController();
     public ShareholderController sc = new ShareholderController();
     public AssetController ac = new AssetController();
     public DebtController dc = new DebtController();
	 public List<Product> Products =new ArrayList<Product>();
	 public List<Asset> Assets =new ArrayList<Asset>();
	 public List<Shareholder> Shareholders =new ArrayList<Shareholder>();
	 public long totalGrossIncome = 0;
	 public long profit = 0;
	 public long dividends = 0;
	 public long debts = 0;
	 public long totalEquity = 0;
	 public long ROIC = 0;
	 public long ROCE = 0;
	 public String ROICMessage = "NaN";
	 public String ROCEMessage = "NaN";
	 
     public FormROIC() {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
  		em = emf.createEntityManager();
  		
    	ks = KieServices.Factory.get();   	
        kContainer = ks.getKieClasspathContainer();
        kSession = kContainer.newKieSession("ksession-rules");    	   	 		
     }
     
 	public void setROICMessage(String message) {
 		this.ROICMessage = message;
 	}
 	public String getROICMessage() {
 		return this.ROICMessage;
 	}
	public void setROCEMessage(String message) {
 		this.ROCEMessage = message;
 	}
 	public String getROCEMessage() {
 		return this.ROCEMessage;
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
	public void calculateROCE() {
		this.totalGrossIncome= pc.getGrossProfit();
		this.totalEquity = sc.getTotaEquity();
		this.debts = dc.getTotalDebts();
		if((this.debts + this.totalEquity) != 0) {
			this.ROCE = (totalGrossIncome / (this.debts + this.totalEquity)) * 100;
		}
	}
	public void calculateROIC() {
		this.profit = pc.getTotalProfit();
		this.totalEquity = ac.getTotalAssetPrice();
		this.dividends = sc.getTotalDividends();
		this.debts = dc.getTotalDebts();
		if((this.debts + this.totalEquity) != 0) {
			this.ROIC = ((this.profit - this.dividends) / (this.debts + this.totalEquity)) * 100;
		}
	}
	public void addProduct(ActionEvent event) {
		this.em.getTransaction().begin();
		this.em.persist(this.Product);
		this.em.getTransaction().commit();
		kSession.insert(this);
		calculateROCE();
		calculateROIC();
		kSession.fireAllRules();	
	}    
     public void Close_Entity() {
         em.close();
     }
}
