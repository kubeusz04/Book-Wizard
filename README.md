# 📖 Book Wizard

**Book Wizard** to stylizowana aplikacja webowa przypominająca starą, magiczną księgę – idealna dla pisarzy, autorów fantasy i miłośników świata wyobraźni. Pozwala zarządzać książkami, ich rozdziałami, notatkami oraz postaciami w przyjazny, mistyczny sposób.

![screenshot](docs/preview.png)

---

## ✨ Funkcje

- Dodawanie, edytowanie i usuwanie książek
- Zarządzanie rozdziałami i planem fabularnym
- Tworzenie i przeglądanie notatek
- Organizowanie postaci i ich opisów
- Interfejs inspirowany starą księgą – czcionki, kolory i tekstury w stylu fantasy

---

## 🛠 Technologie

- **Java 17+**
- **Spring Boot**
- **Thymeleaf** – silnik szablonów HTML
- **Bootstrap 5** – responsywny wygląd
- **Maven** – zarządzanie zależnościami
- **H2 / PostgreSQL** – baza danych (domyślnie H2 w trybie dev)

---

## 🚀 Uruchamianie projektu lokalnie

### Krok 1: Klonowanie repozytorium

```bash
git clone https://github.com/twoje-konto/book-wizard.git
cd book-wizard
```

### Krok 2: Budowanie projektu

```bash
./mvnw clean install
```

### Krok 3: Uruchamianie

```bash
./mvnw spring-boot:run
```

Aplikacja powinna być dostępna pod adresem: [http://localhost:8080](http://localhost:8080)

---

## 🗂 Struktura projektu

```
src/
├── main/
│   ├── java/
│   │   └── com.example.bookwizard/
│   │       ├── controllers/
│   │       ├── models/
│   │       ├── repositories/
│   │       ├── services/
│   │       └── BookWizardApplication.java
│   ├── resources/
│   │   ├── static/
│   │   ├── templates/
│   │   │   ├── books/
│   │   │   ├── chapters/
│   │   │   ├── notes/
│   │   │   ├── characters/
│   │   │   └── layout.html
│   │   └── application.properties
```

---

## 📸 Przykładowy wygląd

<img src="docs/screenshot-home.png" width="800px">

---

## 📜 Licencja

Projekt stworzony jako aplikacja edukacyjna / hobbystyczna. Można wykorzystywać, modyfikować i rozwijać wg własnych potrzeb.

---

## 🔮 Autor

**Book Wizard** został stworzony z pasji do kodu i magii. Jeśli masz pomysł na rozwój projektu – chętnie go usłyszę!
