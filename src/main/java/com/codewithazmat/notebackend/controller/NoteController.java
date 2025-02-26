package com.codewithazmat.notebackend.controller;

import com.codewithazmat.notebackend.model.Notes;
import com.codewithazmat.notebackend.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class NoteController {

    @Autowired
   private NoteRepository noteRepository;

    @PostMapping("/note")
    Notes saveNote(@RequestBody Notes inputNote){
        return noteRepository.save(inputNote);
    }

    @GetMapping("/allnote")
    List<Notes> allNotes(){
        return noteRepository.findAll();
    }

    @DeleteMapping("/note/{id}")
    List<Notes> deleteNote(@PathVariable Long id){
        noteRepository.deleteById(id);
        return noteRepository.findAll();
    }

    @PutMapping("/note/{id}")
    Notes updateNote(@PathVariable Long id,@RequestBody Notes updateNote){

        Notes note = noteRepository.findById(id).orElseThrow(() -> new RuntimeException("this is from bakcend"));

        note.setTitle(updateNote.getTitle());
        note.setNote(updateNote.getNote());

        return noteRepository.save(note);
    }


}
