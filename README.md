# System generowania tabliczek przystankowych		

## Wstęp
Celem pracy jest stworzenie serwisu generującego tablice przystankowe dla pojazdów komunikacji publicznej. 
Tworzony serwis jest elementem większego systemu od półtorej roku wspomagającego organizację i zarządzanie komunikacją publiczną. Danych rozkładowych do tablic przystankowych dostarcza moduł "schedule".

## Opis
Serwis umożliwia generowanie tablic przystankowych w formacie PDF z podziałem na firmy, wersje rozkładu, linie oraz przystanki. Każda firma powinna mieć możliwość wyboru własnego szablonu tablicy przystankowej. Ponadto, powinna istnieć możliwość zmienienia rozkładu dla pojedynczych przystanków. Jednorazowo użyta konfiguracja dla firmy/użytkownika powinna zostać zapisana w bazie danych i ustawiona jako domyślna przy tworzeniu kolejnych zapytań. 

## Funkcjonalności tablic przystankowych
Tablice przystankowe są generowane z rozszerzeniem PDF. System generuje tablice przystankowe w różnych rozmiarach. Jedna tablica przystankowa może zawierać rozkłady jazdy kilku linii, również tych z różnych firm. Jedna tablica przystankowa zawiera rozkład jazdy tylko dla jednego przystanku autobusowego.

## Biznes plan
System generowania tablic przystankowych istnieje już w wersji alpha. Obecna wersja zawiera wiele błędów i jest ciężka do modyfikacji i wprowadzania nowych funkcjonalności. Z tego powodu wybraliśmy ten projekt. Chcemy dopracować system aby trzymał się dobrych standardów programowania. System od roku przynosi regularne zyski. Funkcjonalności serwisu opracowane są na podstawie dialogu z klientami i ich zapotrzebowań.

## Diagram ERD

Diagram ERD dla serwisu wygląda następująco:
![schedule_template_erd](/img/drive_module_erd.png)

Nie zawiera on dużo tabeli, ponieważ większość funkcjonalności jest wykonywana w odrębnych modułach. 
Jako projekt na przedmiot Testowanie i Jakość Oprogramowania II chcemy oddać wyłącznie moduł generowania tablic, ponieważ poprawne napisanie całego systemu w tak krótkim czasie jest niemożliwe. Jednakże do oceny oddany zostanie cały serwer, w celu możliwości sprawdzenia poprawności wykonania zadania. 

Aktualna struktura bazy danych dla całego projektu:
![tarbus_erd](/img/tarbus_erd.png)

## Rozkład obowiązków

Zespół składa się z trzech osób, które będą odpowiedzialne za:
- Dominik Pająk - dopracowanie istniejących modułów "drive", "schedule" i "core" do planowanych funkcjonalności modułu "schedule_tables_generator". Przydzielanie zadań, tworzenie dokumentacji, zarządzanie spójnością projektu.
- Bartosz Dymański - implementacja bazy danych, serwisów i repozytoriów. Przygotowanie przykładowych tablic przystankowych w HTML z użyciem frameworka thymeleaf
- Dariusz Czajka - stworzenie parsera PDF, zamieniającego szablon napisany w HTML na plik PDF

## Stack
1. **Technologia** - Java z wykorzystaniem frameworka [Spring](https://spring.io/)
2. **Baza danych** - Relacyjna baza danych [PostgreSQL](https://www.postgresql.org/)
3. **Dokumentacja** - [Swagger](https://swagger.io/)
4. **Inne**
    - **Generowanie szablonów html** - [Themyleaf]({https://www.thymeleaf.org/)
    - **Generowanie PDF** - [OpenPDF](https://github.com/LibrePDF/OpenPDF)


# Notes
https://github.com/itext/itext7
https://github.com/itext/i7j-pdfhtml