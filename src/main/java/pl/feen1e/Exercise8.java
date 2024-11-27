package pl.feen1e;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static pl.feen1e.Constants.ADDING_FINISHED;
import static pl.feen1e.Constants.AUTO_ADD;
import static pl.feen1e.Constants.COLLECTION_ITEMS;
import static pl.feen1e.Constants.MANUAL_ADD;

/*
 * Stwórz mapę, w której kluczami są niestandardowe obiekty reprezentujące daty.
 * Nadpisz metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie.
 * Dodaj kilka elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych kluczy.
 */

// Klasa odpowiadająca za wykonanie zadania 8
public class Exercise8
{
    public static void ex8HashMap(String method)
    {
        HashMap<Date, String> events = new HashMap<>();

        // Ta część odpowiada za dodawanie kolejnych par do mapy: kiedy metoda wpisywania równa się 2,
        // użytkownik jest proszony o wpisywanie ręczne; w przeciwnym wypadku pary dodawane są automatycznie
        if (Objects.equals(method, "2"))
        {
            System.out.println(MANUAL_ADD);
            int numberOfProducts = 0;
            while (numberOfProducts == 0)
            {
                try
                {
                    var scanner = new Scanner(System.in);
                    System.out.print("Podaj liczbę wydarzeń do wpisania: ");
                    numberOfProducts = Integer.max(Integer.parseInt(scanner.nextLine()), 0);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Błąd: Liczba wydarzeń musi być liczbą całkowitą większą od 0.");
                }
            }
            for (int i = 0; i < numberOfProducts; i++)
            {
                Date d = Date.createDateFromInput();
                if (d != null)
                {
                    String e = Date.createEvent();
                    events.put(d, e);
                }
                else
                {
                    i -= 1;
                }
            }
        }
        else
        {
            System.out.println(AUTO_ADD);
            Object[][] event_examples = new Object[][]{
                    {10, 10, 2005, "Adopted a cat"},
                    {20, 10, 2021, "Visited Greece"},
                    {20, 10, 2021, "Visited Iceland"},
                    {11, 9, 2025, "A concert"}};

            for (Object[] event_example : event_examples)
            {
                Date d = new Date((int) event_example[0], (int) event_example[1], (int) event_example[2]);
                String e = event_example[3].toString();
                d.print();
                System.out.println(e);
                events.put(d, e);
            }
        }
        System.out.println(ADDING_FINISHED);

        // Wypisanie elementów kolekcji
        System.out.println(COLLECTION_ITEMS);
        for (Date key : events.keySet())
        {
            key.print();
            System.out.println(events.get(key));
        }

        // Ta część odpowiada za wyszukiwanie par w kolekcji: kiedy metoda wprowadzania to 2, użytkownik jest
        // proszony o wpisywanie szukanych dat ręcznie, w przeciwnym wypadku 2 przykłady są wyszukiwane automatycznie
        if (Objects.equals(method, "2"))
        {
            String input;
            while (true)
            {
                try
                {
                    Scanner scanner = new Scanner(System.in);

                    System.out.println("\nPodaj datę do wyszukania w formacie DD.MM.RRRR lub wpisz 0, " +
                            "żeby zakończyć wyszukiwanie elementów: ");

                    input = scanner.nextLine();
                    if (input.equals("0"))
                    {
                        break;
                    }
                    Date d = Date.createDate(input);
                    if (d == null)
                    {
                        continue;
                    }
                    System.out.println(events.getOrDefault(d,
                            "Nie ma wydarzenia odpowiadającego podanej dacie."));

                }
                catch (Exception e)
                {
                    System.out.println("Wystąpił nieoczekiwany problem.\n" + e.getMessage());
                }

            }
        }
        else
        {
            System.out.println("\nWyszukiwanie daty znajdującej się w kolekcji: 20.10.2021.");
            System.out.println(events.getOrDefault(new Date(20, 10, 2021),
                    "Nie ma wydarzenia odpowiadającego podanej dacie."));
            System.out.println("\nWyszukiwanie daty niebędącej w kolekcji: 24.12.2023.");
            System.out.println(events.getOrDefault(new Date(24, 12, 2021),
                    "Nie ma wydarzenia odpowiadającego podanej dacie."));

        }

        // Wyjaśnienie / wnioski
        System.out.println("""
                
                W przypadku dodania dwóch wydarzeń o takiej samej dacie, drugie wydarzenie
                zastępuje pierwsze. Dzieje się tak, ponieważ HashMap, w przeciwieństwie do HashSet,
                aktualizuje wartość dla istniejącego klucza zamiast go pomijać. Przy wywołaniu
                metody .put(key, value), HashMap używa metod .hashCode() i .equals() do sprawdzenia,
                czy klucz już istnieje w mapie. Jeśli klucz jest obecny, jego wartość zostaje
                zastąpiona nową, a jeśli klucza nie ma, para klucz-wartość jest dodawana do mapy.""");

    }
}
