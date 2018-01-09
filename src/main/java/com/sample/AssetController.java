package com.sample;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.kie.api.*;

public class AssetController {
    private EntityManager em;
	public AssetController(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
 		em = emf.createEntityManager();
	}
	
	public long getTotalAssetPrice() {
		Object assetsPrice = em.createQuery("SELECT SUM(a.Price) FROM Asset a").getSingleResult();
		return (long)assetsPrice;
	}
}
