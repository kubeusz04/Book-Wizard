package com.example.bookapp.repository;

import com.example.bookapp.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByBookId(Long bookId);
}
