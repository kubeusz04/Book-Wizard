package com.example.bookapp.repository;

import com.example.bookapp.model.Book;
import com.example.bookapp.model.PlotPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlotPlanRepository extends JpaRepository<PlotPlan, Long> {
    Optional<PlotPlan> findByBookId(Long bookId);

    void deleteByBook(Book book);
}
