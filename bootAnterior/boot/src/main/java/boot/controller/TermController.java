package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Task;
import boot.model.Term;
import boot.service.TaskService;
import boot.service.TermService;

@Controller
public class TermController {
	
	@Autowired
	private TermService termService;

	@GetMapping("/all-terms")
	public String allTerms(HttpServletRequest request){
		request.setAttribute("terms", termService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "term";
	}
	
	@GetMapping("/new-term")
	public String newTerm(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "term";
	}
	
	@PostMapping("/save-term")
	public String saveTerm(@ModelAttribute Term term, BindingResult bindingResult, HttpServletRequest request){
		termService.save(term);
		request.setAttribute("terms", termService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "term";
	}
	
	@GetMapping("/update-term")
	public String updateTerm(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("term", termService.findTerm(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "term";
	}
	
	@GetMapping("/delete-term")
	public String deleteTerm(@RequestParam int id, HttpServletRequest request){
		termService.delete(id);
		request.setAttribute("terms", termService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "term";
	}
}
