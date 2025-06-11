# 📚 Book Wizard

Book Wizard to aplikacja webowa stworzona w Spring Boot, która wspiera autorów w tworzeniu książek. Umożliwia zarządzanie książkami, rozdziałami, postaciami, notatkami oraz planem fabularnym. Zawiera również wbudowaną funkcję AI do generowania tekstów rozdziałów.

## ✨ Funkcje

- ✅ Tworzenie i edycja książek
- ✅ Zarządzanie rozdziałami, postaciami, notatkami i planami fabularnymi
- ✅ Wbudowana sztuczna inteligencja do generowania treści rozdziałów
- ✅ Prosty interfejs webowy


## 🚀 Technologie

- Java 17+
- Spring Boot
- Maven
- Thymeleaf 
- Gemini 2.5 
- MySQL

## 🧠 AI - Pisanie rozdziałów

Wykorzystując funkcję `AiController`, użytkownik może poprosić aplikację o automatyczne wygenerowanie rozdziału książki na podstawie wprowadzonego tematu lub planu.

## 🔧 Instalacja lokalna

1. **Klonuj repozytorium**

```bash
git clone https://github.com/twoj-login/book-wizard.git
cd book-wizard
````

2. **Zbuduj projekt**

```bash
./mvnw clean install
```

3. **Uruchom aplikację**

```bash
./mvnw spring-boot:run
```

4. **Otwórz w przeglądarce**

```
http://localhost:8080
```

## 📁 Struktura projektu

```
src/
├── main/
│   ├── java/com/example/bookapp/
│   │   ├── controller/    # Kontrolery REST
│   │   ├── model/         # Modele danych (Book, Chapter, Character, itd.)
│   │   └── BookappApplication.java
│   └── resources/
│       └── templates/     # Widoki HTML (jeśli używane)
```

## 📄 Plik `pom.xml`

Zawiera wszystkie niezbędne zależności dla Spring Boot, kompilatora Java, oraz ewentualnych bibliotek do obsługi AI.

## 🤖 Konfiguracja AI

Aby korzystać z funkcji AI, należy dodać klucz API do pliku `application.properties`:

```
openai.api.key=YOUR_API_KEY
```

## 📝 TODO

* [ ] Autoryzacja i logowanie użytkownika
* [ ] Eksport książki do PDF lub DOCX


## 📃 Licencja

Projekt na licencji MIT.
