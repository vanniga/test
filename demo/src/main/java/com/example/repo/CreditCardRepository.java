package com.example.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.CreditCard;

@Repository
public class CreditCardRepository {
	
    @PersistenceContext
    private EntityManager entityManager;
    
	
	@Transactional
	public void save(CreditCard creditCard) {
		System.out.println("Before save " + creditCard.toString());
		entityManager.persist(creditCard); // entityManager.flush();
	}
	 
    
    public List<CreditCard> getAll(){
    	
    	String queryName = "SELECT * FROM CREDIT_CARD ORDER BY FULL_NAME";//"CreditCard.findAll";
    	Query query = entityManager.createNativeQuery(queryName, CreditCard.class);
    	List<CreditCard> listUsers = (List<CreditCard>)query.getResultList();
    	return listUsers;
    }    
}