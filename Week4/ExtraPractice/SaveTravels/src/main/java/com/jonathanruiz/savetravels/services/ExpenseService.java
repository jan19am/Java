package com.jonathanruiz.savetravels.services;


import java.util.List;

import org.springframework.stereotype.Service;

import com.jonathanruiz.savetravels.models.Expense;
import com.jonathanruiz.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;  
	}
	public Expense createExpense(Expense b) {
        return expenseRepository.save(b);
    }
	public List<Expense> findAll() {
		return expenseRepository.findAll();
	}
}
