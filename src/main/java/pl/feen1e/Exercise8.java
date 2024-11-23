package pl.feen1e;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

import static pl.feen1e.Constants.ADDING_FINISHED;
import static pl.feen1e.Constants.AUTO_ADD;
import static pl.feen1e.Constants.COLLECTION_ITEMS;
import static pl.feen1e.Constants.MANUAL_ADD;

public class Exercise8
{
    public static void ex8HashMap(String method)
    {
        /*
         * Stwórz mapę, w której kluczami są niestandardowe obiekty reprezentujące daty.
         * Nadpisz metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie.
         * Dodaj kilka elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych kluczy.
         */

        HashMap<Date, String> events = new HashMap<>();

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
                    {10, 10, 2005, "Parents got married"},
                    {20, 20, 2021, "Visited Greece"},
                    {20, 20, 2021, "Visited Iceland"},
                    {11, 9, 2025, "Concert"}};

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
        System.out.println(COLLECTION_ITEMS);
        for (Date key : events.keySet())
        {
            key.print();
            System.out.println(events.get(key));
        }


    }
}
