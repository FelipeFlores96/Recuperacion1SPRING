package boot.service;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import boot.dao.NoteRepository;
import boot.model.Note;

@Service @Transactional
public class NoteService {
	private final NoteRepository noteRepository;

	public NoteService(NoteRepository noteRepository) {
		super();
		this.noteRepository = noteRepository;
	}
	
	public List<Note> findAll(){
		List<Note> notes = new ArrayList<Note>();
		for (Note note : noteRepository.findAll()) {
			notes.add(note);
		}
		return notes;
	}	
	
	public void save(Note note){
		noteRepository.save(note);
	}
	
	public void delete(int id){
		noteRepository.delete(id);
	}
	
	public Note findNote(int id){
		return noteRepository.findOne(id);
	}
}
