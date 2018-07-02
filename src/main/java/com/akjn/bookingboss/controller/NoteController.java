/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.akjn.bookingboss.controller;

import com.akjn.bookingboss.exception.ResourceNotFoundException;
import com.akjn.bookingboss.domain.Products;
import com.akjn.bookingboss.service.EventDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import com.akjn.bookingboss.service.ProductRepository;
import com.akjn.bookingboss.service.IEventAppService;

/**
 *
 * @author AkhilJayan
 */
@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    ProductRepository noteRepository;
    
    @Autowired
    IEventAppService _noteService;
    
    
    // Get All Notes
    @GetMapping("/notesall")
    public List<EventDto> getAllNotesDto() {
        //return _noteService.getAllNotes();
        return null;
    }

    // Get All Notes
    @GetMapping("/notes")
    public List<Products> getAllNotes() {
        return noteRepository.findAll();
    }

    // Create a new Note
    @PostMapping("/notes")
    public Products createNote(@Valid @RequestBody Products note) {
        return noteRepository.save(note);
    }

    // Get a Single Note
    @GetMapping("/notes/{id}")
    public Products getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    // Update a Note
    @PutMapping("/notes/{id}")
    public Products updateNote(@PathVariable(value = "id") Long noteId,
            @Valid @RequestBody Products noteDetails) {

        Products note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

//        note.setTitle(noteDetails.getTitle());
//        note.setContent(noteDetails.getContent());

        Products updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    // Delete a Note
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {
        Products note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
        noteRepository.delete(note);
        return ResponseEntity.ok().build();
    }
}
