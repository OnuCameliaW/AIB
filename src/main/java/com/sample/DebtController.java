package com.sample;

import java.util.List;

import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.kie.api.*;

public class DebtController {
    private EntityManager em;
	public DebtController(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("ProjDrools");
 		em = emf.createEntityManager();
	}
	public long getTotalDebts() {
		Object totalEquity= em.createQuery("SELECT SUM(d.Amount) FROM Debt d").getSingleResult();
		return (long)totalEquity;
	}
}
