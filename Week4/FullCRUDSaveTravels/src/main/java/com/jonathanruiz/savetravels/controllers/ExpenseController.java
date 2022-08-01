package com.jonathanruiz.savetravels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonathanruiz.savetravels.models.Expense;
import com.jonathanruiz.savetravels.services.ExpenseService;


@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
	
	@GetMapping("/expense")
	public String newExpense(@ModelAttribute("expense")Expense expense, Model model)
	
	{
		ArrayList<Expense> expenses = new ArrayList<Expense>();
		expenses = (ArrayList<Expense>) expenseService.findAll();
		model.addAttribute("expenses", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expense/new")
	public String create(
			@Valid @ModelAttribute("expense")Expense expense,
			BindingResult result)
	{
		if(result.hasErrors()) {
			return "index.jsp";
		}
		expenseService.createExpense(expense);
		return "redirect:/expense";
	}
	@DeleteMapping("/expense/{id}")
    public String delete(@PathVariable("id") Long id) {
        expenseService.deleteExpense(id);
        return "redirect:/expense";
    }
	@GetMapping("/expense/{id}")
	public String find(@PathVariable("id") Long id, Model model) {
		 Expense expenseItem = expenseService.findExpense(id);
		model.addAttribute("expenseItem", expenseItem);
		return "details.jsp";
	}
	
	@GetMapping("/expense/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model) {
        Expense expense = expenseService.findExpense(id);
        model.addAttribute("expense", expense );
        return "edit.jsp";
    }
    
    @PutMapping("/expense/{id}")
    public String update(@Valid @ModelAttribute("expense") Expense expense, 
    		BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            expenseService.updateExpense(expense);
            return "redirect:/expense";
        }
    }
}
