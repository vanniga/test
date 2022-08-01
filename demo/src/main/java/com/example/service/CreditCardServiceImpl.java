package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.CreditCard;
import com.example.repo.CreditCardRepository;

@Service
public class CreditCardServiceImpl implements CreditCardService {

	@Autowired
    CreditCardRepository creditCardRepository;
    
    public void saveCard(CreditCard creditCard) {
    	creditCardRepository.save(creditCard);
    }
    
    public List<CreditCard> getAllCreditCards(){
    	return creditCardRepository.getAll();
    }
}