package com.example.bookapp.service;

import com.example.bookapp.model.Book;
import com.example.bookapp.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final PlotPlanRepository plotPlanRepository;
    private final ChapterRepository chapterRepository;
    private final NoteRepository noteRepository;
    private final CharacterRepository characterRepository;

    public BookService(BookRepository bookRepository,
                       PlotPlanRepository plotPlanRepository,
                       ChapterRepository chapterRepository,
                       NoteRepository noteRepository,
                       CharacterRepository characterRepository) {
        this.bookRepository = bookRepository;
        this.plotPlanRepository = plotPlanRepository;
        this.chapterRepository = chapterRepository;
        this.noteRepository = noteRepository;
        this.characterRepository = characterRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nie znaleziono książki"));

        plotPlanRepository.deleteByBook(book);
        chapterRepository.deleteAllByBook(book);
        noteRepository.deleteAllByBook(book);
        characterRepository.deleteAllByBook(book);

        bookRepository.delete(book);
    }
}
