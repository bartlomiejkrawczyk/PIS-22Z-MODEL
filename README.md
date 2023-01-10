# Aplikacja wspomagająca naukę do egzaminu - model danych (DTOs)

## Przeznaczenie modelu
Model jest wykorzystywany w aplikacji zbierającej i sprawdzającej
wiedzę z zakresu studiów licencjackich w postaci scenariuszy
testowych (ciągów pytań) na różnych poziomach trudności.
System ten powinien w szczególności odsyłać do niezbędnych źródeł
wiedzy: materiałów z wykładów i ćwiczeń, literatury pomocniczej,
GITów i innych zasobów sieci.

## Model danych
Repozytorium zawiera DATA TRANSFER OBJECT (DTOs) - model danych służący do przekazywania między usługami.
Te same klasy wykorzystywane są w aplikacji mobilnej i na serwerze, dlatego zdecywaliśmy się na utworzenie projektu
z modelem danych, aby po opublikowaniu klas, móc korzystać z nich w API i w aplikacji.
Model danych zawiera w sobie klasy dotyczące użytkowników, materiałów z zakresu studiów - Działy, Pojęcia, Definicje, Paragrafy
zawierające Linki, Multimedia itp., ćwiczeń i testów pozwalających sprawdzić wiedzę - podzielonych na różne kategorie. 


## Diagram klas UML

```mermaid
classDiagram
    class Użytkownik {
        long id
        String login
        String e-mail
        String hasło

        int rodzajUżytkownika
    }

    class Dział {
        long id
        String nazwa
        Pojęcie[] definicje
        Dział[] podDziały
        Zadanie[] zadania
    }

    class Pojęcie {
        long id
        String frazaKluczowa
        String tldr
        Notatka[] notatki
    }

    class Paragraf {
        long id
        String nagłówek
        String opis
        Multimedia[] multimedia
    }

    %% Relacje

    Dział "1" -- "0..*" Dział
    Dział "1" -- "0..*" Pojęcie
    Pojęcie "1" -- "0..*" Paragraf

    %% Multimedia

    class Multimedia {
        <<abstract>>
        long id
        String nazwa
    }

    class Link {
        String url
    }

    class PlikMożliwyDoPobrania
    class PlikMożliwyDoWyświetlenia {
        <<abstract>>
    }

    class Dźwięk
    class Obraz
    class Film

    %% Relacje

    Multimedia <|-- Link
    Multimedia <|-- PlikMożliwyDoPobrania

    PlikMożliwyDoPobrania <|-- PlikMożliwyDoWyświetlenia
    PlikMożliwyDoWyświetlenia <|-- Dźwięk
    PlikMożliwyDoWyświetlenia <|-- Obraz
    PlikMożliwyDoWyświetlenia <|-- Film

    Paragraf "1" -- "0..*" Multimedia

    %% Zadania

    class Zadanie {
        <<abstract>>
        String treść
        Multimedia multimedia
        boolean sprawdź()
    }
    
    %% RODZAJE ZADAŃ

    class JednokrotnyWybór {
        Odpowiedź[] odpowiedzi
    }
    class WielokrotnyWybór {
        Odpowiedź[] odpowiedzi
    }
    class PrawdaFałszJednokrotne {
        boolean czyPoprawna
        boolean czyZaznaczonaPrawda
    }
    class PrawdaFałszWielokrotne {
        Odpowiedź[] odpowiedzi
    }
    class WysuwanaLista {
        OdpowiedźZListą[] odpowiedzi
    }
    class WpiszWLukę {
        OdpowiedźZLuką[] odpowiedzi
    }
    class Fiszka {
        String treść
        String odpowiedź
    }
    
    %% RODZAJE ODPOWIEDZI

    class Odpowiedź {
        String treść
        boolean czyPoprawna
        boolean czyZaznaczona
        zmieńStan()
        boolean czyPoprawnaZaznaczona()

        long ileRazyWybrano
        long ileRazyNieWybrano
    }
    class OdpowiedźZListą {
        String początek
        Odpowiedź[] możliwyWybór
        String koniec
    }
    class OdpowiedźZLuką {
        String początek
        String odpowiedź
        String koniec
        String wpisanaOdpowiedź
        
        long ileRazyPoprawnieDopasowano
        long ileRazyNiepoprawnieDopasowano
    }

    %% Relacje

    Zadanie <|-- JednokrotnyWybór : {complete, disjoint}
    Zadanie <|-- WielokrotnyWybór : {complete, disjoint}
    Zadanie <|-- PrawdaFałszJednokrotne : {complete, disjoint}
    Zadanie <|-- PrawdaFałszWielokrotne : {complete, disjoint}
    Zadanie <|-- WysuwanaLista : {complete, disjoint}
    Zadanie <|-- Fiszka : {complete, disjoint}
    Zadanie <|-- WpiszWLukę : {complete, disjoint}

    JednokrotnyWybór "1" --o "2..*" Odpowiedź
    WielokrotnyWybór "1" --o "2..*" Odpowiedź
    PrawdaFałszWielokrotne "1" --o "2..*" Odpowiedź
    WysuwanaLista "1" --o "2..*" OdpowiedźZListą
    OdpowiedźZListą "1" --o "2..*" Odpowiedź
    WpiszWLukę "1" --o "1..*" OdpowiedźZLuką

    Zadanie "1" --* "0..1" Multimedia

    Dział "1" -- "0..*" Zadanie

    Zadanie "0..*" -- "0..*" Pojęcie

```

## Aby opublikować wszystkiego klasy, aby móc korzystać z nich w innych projektach - API i w aplikacji na Androida - należy wykonać polecenie

```bash
./gradlew publishToMavenLocal
```

# Uruchomienie testów
Aby uruchomić testy najlepiej skorzystać z IntelliJ - narzędzie samo wykrywa konfiguracje build/test/run.

Można też skorzystać z polecenia:
```bash
./gradlew clean build test
```

## Pokrycie testami
Aby wygenerować raport zawierający m.in. procent pokrycia linii i gałęzi testami należy wywołać:
```bash
./gradlew jacocoTestReport
```

Raport zostanie wygenerowany [tutaj](./build/reports/jacoco/test/html/index.html)

# Ponowne wygenerowanie dokumentacji
Javadocs są dostępne [tutaj](./javadoc/index.html).
Aby ponownie wygenerować docsy należy wywołać:
```bash
./gradlew javadoc
```
