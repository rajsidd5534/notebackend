package com.noteapp.noteaap.service;

import com.noteapp.noteaap.model.Note;
import com.noteapp.noteaap.repo.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    public List<Note> getAllNotes() {
        return repository.findAll();
    }

    public Optional<Note> getNoteById(String id) {
        return repository.findById(id);
    }

    public Note createNote(Note note) {
        return repository.save(note);
    }

    public Note updateNote(String id, Note updated) {
        return repository.findById(id)
                .map(note -> {
                    note.setTitle(updated.getTitle());
                    note.setContent(updated.getContent());
                    return repository.save(note);
                }).orElseThrow(() -> new RuntimeException("Note not found"));
    }

    public void deleteNote(String id) {
        repository.deleteById(id);
    }

    public Optional<Note> shareNote(String id) {
        return repository.findById(id).map(note -> {
            note.setShared(true);
            return repository.save(note);
        });
    }

    public Optional<Note> getSharedNote(String id) {
        return repository.findById(id).filter(Note::isShared);
    }
}
