package com.example.bookapp.controller;

import com.example.bookapp.model.Book;
import com.example.bookapp.model.Character;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.repository.CharacterRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books/{bookId}/characters")
public class CharacterController {
    private final CharacterRepository characterRepository;
    private final BookRepository bookRepository;

    public CharacterController(CharacterRepository characterRepository, BookRepository bookRepository) {
        this.characterRepository = characterRepository;
        this.bookRepository = bookRepository;
    }

    // Pobieranie postaci
    @GetMapping
    public String getCharacters(@PathVariable Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElse(null);
        if (book == null) {
            return "error"; // Jeżeli książka nie istnieje, kierujemy na stronę błędu
        }
        List<Character> characters = characterRepository.findByBookId(bookId);
        model.addAttribute("book", book);
        model.addAttribute("characters", characters);
        return "characters"; // Widok 'characters.html'
    }

    // Formularz do dodania nowej postaci
    @GetMapping("/new")
    public String newCharacter(@PathVariable Long bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("character", new Character());
        return "character-form"; // Widok formularza do dodania postaci
    }

    // Zapisywanie nowej postaci
    @PostMapping("/save")
    public String saveCharacter(@PathVariable Long bookId, @ModelAttribute Character character) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Książka nie została znaleziona"));
        character.setBook(book);
        characterRepository.save(character);
        return "redirect:/books/" + bookId + "/characters";
    }

    // Usuwanie postaci
    @GetMapping("/{characterId}/delete")
    public String deleteCharacter(@PathVariable Long bookId, @PathVariable Long characterId) {
        characterRepository.deleteById(characterId);
        return "redirect:/books/" + bookId + "/characters";
    }
}
