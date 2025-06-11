package com.example.bookapp.controller;

import com.example.bookapp.model.Book;
import com.example.bookapp.model.Note;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.repository.NoteRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books/{bookId}/notes")
public class NoteController {
    private final NoteRepository noteRepository;
    private final BookRepository bookRepository;

    public NoteController(NoteRepository noteRepository, BookRepository bookRepository) {
        this.noteRepository = noteRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String getNotes(@PathVariable Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        List<Note> notes = noteRepository.findByBookId(bookId);
        model.addAttribute("book", book);
        model.addAttribute("notes", notes);
        return "notes";
    }

    @PostMapping("/save")
    public String saveNote(@PathVariable Long bookId, @RequestParam String content) {
        Note note = new Note();
        note.setBook(bookRepository.findById(bookId).orElseThrow());
        note.setContent(content);
        noteRepository.save(note);
        return "redirect:/books/" + bookId + "/notes";
    }

    @GetMapping("/{noteId}/delete")
    public String deleteNote(@PathVariable Long bookId, @PathVariable Long noteId) {
        noteRepository.deleteById(noteId);
        return "redirect:/books/" + bookId + "/notes";
    }
}
