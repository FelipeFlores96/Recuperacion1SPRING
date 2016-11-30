package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Enrollement;
import boot.service.EnrollementService;

@Controller
public class EnrollementController {

	@Autowired
	private EnrollementService enrollementService;

	@GetMapping("/all-enrollements")
	public String allEnrollements(HttpServletRequest request) {
		request.setAttribute("enrollements", enrollementService.findAll());
		request.setAttribute("mode", "MODE_ENROLLEMENTS");
		return "enrollement";
	}

	@GetMapping("/new-enrollement")
	public String newEnrollement(HttpServletRequest request) {
		request.setAttribute("mode", "MODE_NEW");
		return "enrollement";
	}

	@PostMapping("/save-enrollement")
	public String saveEnrollement(@ModelAttribute Enrollement enrollement, BindingResult bidingResult,
			HttpServletRequest request) {
		enrollementService.save(enrollement);
		request.setAttribute("enrollements", enrollementService.findAll());
		request.setAttribute("mode", "MODE_ENROLLEMENTS");
		return "enrollement";

	}

	@GetMapping("/update-enrollement")
	public String updateEnrollement(@RequestParam int id, HttpServletRequest request) {
		request.setAttribute("enrollement", enrollementService.findEnrollement(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "enrollement";
	}

	@GetMapping("/delete-enrollement")
	public String deleteEnrollement(@RequestParam int id, HttpServletRequest request) {
		enrollementService.delete(id);
		request.setAttribute("enrollements", enrollementService.findAll());
		request.setAttribute("mode", "MODE_ENROLLEMENTS");
		return "enrollement";
	}

}
