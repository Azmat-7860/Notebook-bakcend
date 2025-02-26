package com.codewithazmat.notebackend.repository;

import com.codewithazmat.notebackend.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Notes,Long> {
}
