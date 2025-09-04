package com.noteapp.noteaap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "notes")
public class Note {

    @Id
    private String id;
    private String title;
    private String content;
    private boolean shared;

    public Note() {}

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
        this.shared = false;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public boolean isShared() { return shared; }
    public void setShared(boolean shared) { this.shared = shared; }
}