package com.example.service;

import java.util.List;

import com.example.model.CreditCard;

public interface CreditCardService {

	 void saveCard(CreditCard creditCard);
	    
	 List<CreditCard> getAllCreditCards();
	    
}
