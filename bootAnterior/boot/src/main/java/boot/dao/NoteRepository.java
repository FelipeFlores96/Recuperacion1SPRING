package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Note;

public interface NoteRepository extends CrudRepository<Note, Integer> {
	
}
