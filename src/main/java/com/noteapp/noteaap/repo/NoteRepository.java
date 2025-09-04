package com.noteapp.noteaap.repo;

import com.noteapp.noteaap.model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NoteRepository extends MongoRepository<Note, String> {
}
