# 📚 Book Wizard

**Book Wizard** to aplikacja webowa oparta na Spring Boot, która pozwala na zarządzanie książkami, ich rozdziałami, postaciami, notatkami i planem fabularnym — wszystko w klimacie magicznej księgi ✨📖.

## 🔧 Technologie

- Java 17+
- Spring Boot
- Spring MVC + Thymeleaf
- Spring Data JPA (Hibernate)
- mySQL
- Bootstrap 5 (stylizacja frontendu)

## 🗂️ Struktura Projektu

```
bookapp/
├── src/
│   ├── main/
│   │   ├── java/com/example/bookapp/
│   │   │   ├── controller/       # Kontrolery do obsługi żądań HTTP
│   │   │   ├── model/            # Modele danych (Book, Chapter, Note, itd.)
│   │   │   ├── repository/       # Interfejsy repozytoriów JPA
│   │   │   └── service/          # Logika biznesowa
│   │   └── resources/
│   │       ├── templates/        # Widoki HTML (Thymeleaf)
│   │       └── application.properties
│   └── test/                     # Testy jednostkowe
├── pom.xml                       # Plik konfiguracji Maven
```

## 🚀 Jak uruchomić

1. **Importuj projekt** do IntelliJ lub innego IDE wspierającego Mavena.
2. Upewnij się, że masz zainstalowaną Javę 17+.
3. Uruchom klasę `BookappApplication.java`.
4. Otwórz przeglądarkę i wejdź na: http://localhost:8080

## 🧙‍♂️ Funkcjonalności

- Dodawanie i edycja książek
- Tworzenie rozdziałów dla książki
- Dodawanie postaci związanych z książką
- Notatki do książek
- Tworzenie planu fabularnego (plot plan)
- Stylizacja inspirowana starymi księgami i magią ✨

## 📁 Widoki (Thymeleaf)

- `/` – strona główna
- `/books` – lista książek
- `/books/new` – formularz nowej książki
- `/books/{id}/chapters` – zarządzanie rozdziałami
- `/books/{id}/notes` – notatki
- `/books/{id}/plot` – plan fabularny
- `/books/{id}/characters` – postacie

