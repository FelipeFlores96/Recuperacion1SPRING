package boot.controller;

import javax.servlet.http.HttpServletRequest;


import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Task;
import boot.service.TaskService;

@Controller
public class MainController {
 
	
	@GetMapping("/")
	public String home(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "index";
	}
	
	@GetMapping("task")
	public String task(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "task";
	}
	
	@GetMapping("enrollement")
	public String hat(HttpServletRequest request){
		request.setAttribute("mode", "MODE_HOME");
		return "enrollement";
	}
	
 }
