package com.example.bookapp.controller;

import com.example.bookapp.model.Chapter;
import com.example.bookapp.model.Book;
import com.example.bookapp.service.ChapterService;
import com.example.bookapp.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books/{bookId}/chapters")
public class ChapterController {
    private final ChapterService chapterService;
    private final BookService bookService;

    public ChapterController(ChapterService chapterService, BookService bookService) {
        this.chapterService = chapterService;
        this.bookService = bookService;
    }

    @GetMapping
    public String listChapters(@PathVariable Long bookId, Model model) {
        bookService.getBookById(bookId).ifPresent(book -> {
            model.addAttribute("book", book);
            model.addAttribute("chapters", chapterService.getChaptersByBookId(bookId));
        });
        return "chapters/list";
    }

    @GetMapping("/new")
    public String showCreateChapterForm(@PathVariable Long bookId, Model model) {
        model.addAttribute("bookId", bookId);
        model.addAttribute("chapter", new Chapter());
        return "chapters/form";
    }

    @PostMapping("/save")
    public String saveChapter(@PathVariable Long bookId, @ModelAttribute Chapter chapter) {
        bookService.getBookById(bookId).ifPresent(book -> {
            chapter.setBook(book);
            chapterService.saveChapter(chapter);
        });
        return "redirect:/books/" + bookId + "/chapters";
    }

    @GetMapping("/{id}/edit")
    public String showEditChapterForm(@PathVariable Long bookId, @PathVariable Long id, Model model) {
        chapterService.getChapterById(id).ifPresent(chapter -> {
            model.addAttribute("bookId", bookId);
            model.addAttribute("chapter", chapter);
        });
        return "chapters/form";
    }

    @PostMapping("/{id}/delete")
    public String deleteChapter(@PathVariable Long bookId, @PathVariable Long id) {
        chapterService.deleteChapter(id);
        return "redirect:/books/" + bookId + "/chapters";
    }
}
