package com.noteapp.noteaap.controller;

import com.noteapp.noteaap.model.Note;
import com.noteapp.noteaap.service.NoteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
public class NoteController {
    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Note> getAllNotes() {
        return service.getAllNotes();
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable String id) {
        return service.getNoteById(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @PostMapping
    public Note createNote(@RequestBody Note note) {
        return service.createNote(note);
    }

    @PutMapping("/{id}")
    public Note updateNote(@PathVariable String id, @RequestBody Note note) {
        return service.updateNote(id, note);
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable String id) {
        service.deleteNote(id);
    }

    @PostMapping("/{id}/share")
    public Note shareNote(@PathVariable String id) {
        return service.shareNote(id)
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }

    @GetMapping("/{id}/public")
    public Note getSharedNote(@PathVariable String id) {
        return service.getSharedNote(id)
                .orElseThrow(() -> new RuntimeException("Note not shared"));
    }
}