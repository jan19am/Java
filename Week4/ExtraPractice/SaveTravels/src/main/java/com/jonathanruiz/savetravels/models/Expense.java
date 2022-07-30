package com.jonathanruiz.savetravels.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="expenses")
public class Expense {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
    @Size(min = 5, max = 200, message="Must be at least 3 characters")
    private String expenseName;
	@NotNull
	@Size(min = 5, max = 200, message="Must be at least 3 characters")
	private String vendor;
	@NotNull (message="must not be blank") 
	@Min(value=0, message="Must be more than $0.00")
	private Double amount;
    @NotNull
    @Size(min = 5, max = 200, message="Must be at least 3 characters")
    private String description;
    
    public Expense() {
	}
       
    public Expense(String expenseName, String vendor, Double amount, String description) {
		this.expenseName = expenseName;
		this.vendor = vendor;
		this.amount = amount;
		this.description = description;
		
	}

//  Setters and Getters
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getExpenseName() {
		return expenseName;
	}
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}
	public String getVendor() {
		return vendor;
	}
	public void setVendor(String vendor) {
		this.vendor = vendor;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
