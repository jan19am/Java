package com.jonathanruiz.beltexam.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.jonathanruiz.beltexam.models.LoginUser;
import com.jonathanruiz.beltexam.models.Team;
import com.jonathanruiz.beltexam.models.User;
import com.jonathanruiz.beltexam.services.TeamService;
import com.jonathanruiz.beltexam.services.UserService;


@Controller
public class MainController {
	@Autowired
	private UserService users;
	
	@Autowired
	private TeamService teams;
	
//	LogIn & Registration Page
	
	@GetMapping("/")
	public String index(Model model) {
		 
	     model.addAttribute("newUser", new User());
	     model.addAttribute("newLogin", new LoginUser());
	     return "index.jsp";
	 }
	
	@PostMapping("/register")
	 public String register(@Valid @ModelAttribute("newUser") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
		 
	     User validated = users.register(newUser, result);
	     
	     if(result.hasErrors() || validated == null) {
	    	 
	         model.addAttribute("newLogin", new LoginUser());
	         return "index.jsp";
	     }
	     
	     users.create(validated);
	     session.setAttribute("userId", validated.getId());
	     return "redirect:/";
	 }
	
	@PostMapping("/login")
	 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     User user = users.login(newLogin, result);
	 
	     if(result.hasErrors() || user == null) {
	         model.addAttribute("newUser", new User());
	         return "index.jsp";
	     }
	    
	     session.setAttribute("userId", user.getId());
	     return "redirect:/home";
	}
	
//	Dashboard Page
	
	@GetMapping("/home")
    public String home(Model model, HttpSession session) {
		
		if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	
    	model.addAttribute("teams", teams.all());
    	model.addAttribute("user", users.find((Long)session.getAttribute("userId")));
    	return "home.jsp";
    }
	
	@GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
	
//	Create Team Page
	
	@GetMapping("/teams/new")
	public String addTeam(@ModelAttribute("team") Team team, Model model, HttpSession session) {
    	
    	User user = users.find((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	
    	return "addTeam.jsp";
    }
	
	@PostMapping("/teams/create")
    public String createTeam(@Valid @ModelAttribute("team") Team team, BindingResult result) {

    	if (result.hasErrors()) {
    		return "addTeam.jsp";
    	}    
    	teams.create(team);
    	return "redirect:/home";
	}
	
//	Team Details Page
	
	@GetMapping("/teams/{id}")
    public String showPage(@PathVariable("id") Long id, Model model, HttpSession session) {
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	Team team = teams.find(id);
    	model.addAttribute("team", team);
    	model.addAttribute("user", users.find((Long)session.getAttribute("userId")));
    	
    	return "teamDetails.jsp";
    }
	
	@GetMapping("/edit/{id}")
	public String editPage(Model model, @PathVariable("id") Long id, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
    	
    	Team team = teams.find(id);
    	model.addAttribute("team", team);
    	
    	return "editPage.jsp";
    }
	
	@PutMapping("/teams/{id}")
    public String updateTeam(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model, @PathVariable("id") Long id) {
    	
    	if (result.hasErrors()) {
    		model.addAttribute("team", teams.find(id));
    		return "editPage.jsp";
    	}

        teams.update(team);
        
    	
    	return "redirect:/home";
	}
	
	@PutMapping("/players/{id}")
    public String updatePlayers(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model, @PathVariable("id") Long id) {
    	
    	if (result.hasErrors()) {
    		model.addAttribute("team", teams.find(id));
    		System.out.print(result);
    		return "teamDetails.jsp";
    	}

        teams.update(team);
        
    	return "redirect:/home";
	}
	
	@DeleteMapping("/teams/{id}")
	public String deleteTeam(@PathVariable("id") Long id) {
		teams.destroy(id);
		return "redirect:/home";
	}
}
