package com.example.bookapp.controller;

import com.example.bookapp.model.Book;
import com.example.bookapp.model.PlotPlan;
import com.example.bookapp.repository.BookRepository;
import com.example.bookapp.repository.PlotPlanRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books/{bookId}/plot")
public class PlotPlanController {
    private final PlotPlanRepository plotPlanRepository;
    private final BookRepository bookRepository;

    public PlotPlanController(PlotPlanRepository plotPlanRepository, BookRepository bookRepository) {
        this.plotPlanRepository = plotPlanRepository;
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public String getPlot(@PathVariable Long bookId, Model model) {
        Book book = bookRepository.findById(bookId).orElseThrow();
        PlotPlan plotPlan = plotPlanRepository.findByBookId(bookId).orElse(new PlotPlan());
        model.addAttribute("book", book);
        model.addAttribute("plotPlan", plotPlan);
        return "plot";
    }

    @PostMapping("/save")
    public String savePlot(@PathVariable Long bookId, @RequestParam String content) {
        PlotPlan plotPlan = plotPlanRepository.findByBookId(bookId).orElse(new PlotPlan());
        plotPlan.setBook(bookRepository.findById(bookId).orElseThrow());
        plotPlan.setContent(content); // Zapisuje treść planu fabuły
        plotPlanRepository.save(plotPlan); // Zapisuje zmiany do bazy danych
        return "redirect:/books/" + bookId + "/plot"; // Przekierowuje z powrotem na stronę planu fabuły
    }

}
