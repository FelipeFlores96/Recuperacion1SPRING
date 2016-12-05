package boot.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import boot.model.Note;
import boot.model.Task;
import boot.service.NoteService;
import boot.service.TaskService;

@Controller
public class NoteController {
	
	@Autowired
	private NoteService noteService;

	@GetMapping("/all-notes")
	public String allNotes(HttpServletRequest request){
		request.setAttribute("notes", noteService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "note";
	}
	
	@GetMapping("/new-note")
	public String newNote(HttpServletRequest request){
		request.setAttribute("mode", "MODE_NEW");
		return "note";
	}
	
	@PostMapping("/save-note")
	public String saveNote(@ModelAttribute Note note, BindingResult bindingResult, HttpServletRequest request){
		noteService.save(note);
		request.setAttribute("notes", noteService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "note";
	}
	
	@GetMapping("/update-note")
	public String updateNote(@RequestParam int id, HttpServletRequest request){
		request.setAttribute("note", noteService.findNote(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "note";
	}
	
	@GetMapping("/delete-note")
	public String deleteNote(@RequestParam int id, HttpServletRequest request){
		noteService.delete(id);
		request.setAttribute("notes", noteService.findAll());
		request.setAttribute("mode", "MODE_TASKS");
		return "note";
	}
}
