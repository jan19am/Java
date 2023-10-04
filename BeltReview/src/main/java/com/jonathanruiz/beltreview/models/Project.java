package com.jonathanruiz.beltreview.models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotEmpty (message = "Title is required!")
	@Size(min=3, max=30, message="Title must be between 3 and 30 characters")
	private String title;
	
	@NotEmpty (message = "Description is required!")
	@Size(min=3, max=30, message="Description must be between 3 and 30 characters")
	private String description;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date date;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "users_projects",
    		joinColumns = @JoinColumn(name = "project_id"),
    		inverseJoinColumns = @JoinColumn(name = "user_id")
    )
	private List<User> users;
	
	public Project () {}
	
	public Project(Long id,
			@NotEmpty(message = "Title is required!") @Size(min = 3, max = 30, message = "Title must be between 3 and 30 characters") String title,
			@NotEmpty(message = "Description is required!") @Size(min = 3, max = 30, message = "Description must be between 3 and 30 characters") String description,
			Date date, List<User> users) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.date = date;
		this.users = users;
	}

	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
