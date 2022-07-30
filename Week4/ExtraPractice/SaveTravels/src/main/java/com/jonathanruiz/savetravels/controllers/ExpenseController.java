package com.jonathanruiz.savetravels.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.jonathanruiz.savetravels.models.Expense;
import com.jonathanruiz.savetravels.services.ExpenseService;


@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}
//	@RequestMapping("/")
//	public String index(Model model) {
//
//		ArrayList<Expense> expenses = new ArrayList<Expense>();
//		expenses.add(new Expense("Travel charger", "ACDC outlets", 49.95));
//		expenses.add(new Expense("Ukulele", "Ohana Instruments", 128.00));
//		expenses.add(new Expense("Sunscreen", "ABC Store", 11.71));
//		expenses.add(new Expense("Huge Plastic Flamingo Floatie", "Party City", 77.89));
//		expenses.add(new Expense("4 Manapua", "Manapua Man", 8.00));
//		model.addAttribute("expenses", expenses);
//
//		return "index.jsp";
//	}
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

}
