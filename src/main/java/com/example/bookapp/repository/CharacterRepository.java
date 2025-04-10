package com.example.bookapp.repository;

import com.example.bookapp.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByBookId(Long bookId);
}
