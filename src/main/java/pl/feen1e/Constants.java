package pl.feen1e;

// Klasa zawierająca wszystkie stałe pola
public class Constants
{
    public final static String AUTHOR = "Autor: Dominik Kaczmarek 281007";
    public final static String MENU = """
            
            *----------------- Lista 1. Kolekcje - Menu ----------------*
            1 - Zadanie 4. HashSet
            2 - Zadanie 7. ArrayList
            3 - Zadanie 8. HashMap
            0 - Zakończenie działania programu
            *-----------------------------------------------------------*
            Proszę wprowadzić numer wybranej opcji:\s""";
    public final static String CHOOSE_ADDING_METHOD = """
            *-----------------------------------------------------------*
            Wybierz metodę wprowadzania danych:
            1 - Wprowadzanie automatyczne - domyślne
            (Nie wymaga wprowadzania danych, używa gotowych przykładów)
            2 - Wprowadzanie ręczne
            (Wymaga ręcznego wprowadzenia każdego elementu kolekcji)
            *-----------------------------------------------------------*
            Proszę wprowadzić numer wybranej opcji:\s""";
    public final static String EXERCISE_4 = """
            
            Zadanie polegało na implementacji klasy reprezentującej użytkownika, z polami takimi jak
            nazwa użytkownika, adres e-mail, numer ID. Należało nadpisać metody hashCode() i equals(),
            aby porównywały użytkowników na podstawie numeru ID. Następnie należało stworzyć HashSet
            i dodać kilku użytkowników z takimi samymi oraz różnymi numerami ID i przeanalizować wynik.
            """;
    public final static String EXERCISE_7 = """
            
            Zadanie polegało na implementacji klasy reprezentującej produkt, z polami takimi jak
            nazwa i cena. Należało zaimplementować interfejs Comparable, aby porównywać produkty
            na podstawie nazwy. Następnie należało stworzyć listę produktów i posortować je za
            pomocą Collection.sort(). Kolejnym krokiem było użycia własnego komparatora do sortowania
            produktów według ich ceny oraz wyświetlenie i porównanie wyników.
            """;
    public final static String EXERCISE_8 = """
            
            Zadanie polegało na stworzeniu mapy, której kluczami są niestandardowe obiekty
            reprezentujące daty. Należało nadpisać metody equals() i hashCode() tych obiektów,
            aby zapewnić poprawne porównywanie. Następnie trzeba było dodać kilka elementów do
            mapy i przetestować znajdowanie elementów za pomocą tych niestandardowych kluczy.
            """;
    public final static String ADDING_FINISHED = "Dodawanie zakończone.\n";
    public final static String AUTO_ADD = "Dodawanie automatyczne.\n";
    public final static String MANUAL_ADD = "Dodawanie manualne.\n";
    public final static String NON_NUMBER_INPUT = "Błąd: Podano znak niebędący liczbą.\nProszę wprowadzić numer wybranej opcji: ";
    public static final String COLLECTION_ITEMS = "Oto kolejne elementy znajdujące się w kolekcji:\n";
    public static final String EXIT = "Program zakończył działanie";
}
