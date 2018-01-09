package com.sample;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.kie.api.*;

public class ShareholderController {
    private EntityManager em;
	public ShareholderController(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
 		em = emf.createEntityManager();
	}
	public long getTotaEquity() {
		Object totalEquity= em.createQuery("SELECT SUM(s.Equity) FROM Shareholder s").getSingleResult();
		return (long)totalEquity;
	}
}
