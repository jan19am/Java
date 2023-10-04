package com.jonathanruiz.beltreview.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonathanruiz.beltreview.models.LoginUser;
import com.jonathanruiz.beltreview.models.Project;
import com.jonathanruiz.beltreview.models.User;
import com.jonathanruiz.beltreview.services.ProjectService;
import com.jonathanruiz.beltreview.services.UserService;

@Controller
public class ProjectController {
	
	@Autowired
    private UserService users;
	@Autowired
	private ProjectService projects;
	
	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // Call a register method in the service 
        // to do some extra validations and create a new user!
    	User user = users.register(newUser, result);
    	
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
    
        return "redirect:/dashboard";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = users.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "index.jsp";
        }
    
        // No errors! 
        // Store their ID from the DB in session, 
        // in other words, log them in.
        session.setAttribute("userId", user.getId());
    
        return "redirect:/dashboard";
    }
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
    	
    	if(session.getAttribute("userId") == null) {
    		return "redirect:/";
    	}
//    	if(session.getAttribute("projectId") == null) {
//    		System.out.println("not working, Chief!");
//    		return "redirect:/";
//    	}
    	User user = users.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("projects", projects.uncollected(user));
    	model.addAttribute("myprojects", projects.joinedProjects(user));
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
//    	model.addAttribute("userProjects", projects.findById((Long)session.getAttribute("projectId")));
    	return "projects.jsp";
    }
    
    @GetMapping("/projects/new")
    public String addProject(@ModelAttribute("project") Project project, Model model, HttpSession session) {
    	User user = users.findById((Long)session.getAttribute("userId"));
    	model.addAttribute("user", user);
    	
		return "addProject.jsp";
    }
    
    @PostMapping("/projects")
    public String createProject(@Valid @ModelAttribute("project") Project project, BindingResult result, HttpSession session) {

    	if (result.hasErrors()) {
    		return "addProject.jsp";
    	}
//    	List userList = project.getUsers();
//    	User user = users.findById((Long)session.getAttribute("userId"));
//    	userList.add(user);
//    	project.setUsers(userList);
    	projects.create(project);
    	
    	return "redirect:/dashboard";
    }
   
    
    @GetMapping("/join/{id}")
    public String joinTeam (@PathVariable ("id") Long projectId, HttpSession session, Model model) {
    	model.addAttribute("user", users.findById((Long)session.getAttribute("userId")));
    	Long userId = (Long)session.getAttribute("userId");
    	projects.addToUsers(projectId, userId);
    	return "redirect:/dashboard";
    }
    
    
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}
