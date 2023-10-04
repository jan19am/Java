package com.jonathanruiz.savetravels.services;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
	public void deleteExpense(Long id) {
		expenseRepository.deleteById(id);
	}
	public Expense findExpense(Long id) {
        Optional<Expense> optionalExpense = expenseRepository.findById(id);
        if(optionalExpense.isPresent()) {
            return optionalExpense.get();
        } else {
            return null;
        }
    }
//	public Expense updateExpense(Long id, String expenseName, String vendor, 
//			Double amount, String description) {
//		Expense expenseToUpdate = findExpense(id);
//		return expenseRepository.save(expenseToUpdate);
//	}
	public Expense updateExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
}
