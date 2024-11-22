package pl.feen1e;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main
{
    public final static String AUTHOR = "Autor: Dominik Kaczmarek 281007";
    public final static String MENU = """
            *---------------------------------------*
                Lista 1. Kolekcje - Menu:
            1 - Zadanie 4. HashSet
            2 - Zadanie 7. ArrayList
            3 - Zadanie 8. HashMap
            0 - Zakończenie działania programu
            *---------------------------------------*
            Proszę wprowadzić numer wybranej opcji:\s""";
    public final static String ADDING_FINISHED = "Dodawanie zakończone.%n";


    public static void main(String[] args)
    {

    }


    private static void ex4_hashSet(String method)
    {
        /*
         * Zaimplementuj klasę reprezentującą użytkownika z polami takimi jak:
         * nazwa użytkownika, adres e-mail i numer ID.
         * Napisz metody equals() i hashCode(), aby porównywały użytkowników na podstawie numeru ID.
         * Stwórz hashset i dodaj kilku użytkowników o tym samym numerze ID oraz kilku różnych. Przeanalizuj wynik.
         */
        var users = new HashSet<User>();

        if (Objects.equals(method, "2"))
        {
            System.out.println("Dodawanie manualne.");
            int numberOfUsers = 0;
            while (numberOfUsers == 0)
            {
                try
                {
                    var scanner = new Scanner(System.in);
                    System.out.print("Podaj liczbę użytkowników do wpisania: ");
                    numberOfUsers = Integer.max(Integer.parseInt(scanner.nextLine()), 0);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Błąd: Liczba użytkowników musi być liczbą całkowitą większą od 0.");
                }
            }
            for (int i = 0; i < numberOfUsers; i++)
            {
                User u = User.createUserFromInput();
                if (u != null)
                {
                    users.add(u);
                }
                else
                {
                    i -= 1;
                }
            }
        }
        else
        {
            System.out.println("Dodawanie automatyczne.");
            Object[][] user_examples = new Object[][]{
                    {"johnsm1th", "john.smith@example.com", 1},
                    {"j4n3d0e", "jane.doe@example.com", 2},
                    {"al1ce__", "alice.wonder@example.com", 3},
                    {"b0bu1lds", "bob.builder@example.com", 1}};

            for (Object[] user_example : user_examples)
            {
                User u = new User((String) user_example[0], (String) user_example[1], (int) user_example[2]);
                u.print();
                users.add(u);
            }
            System.out.println("Proszę zwrócić uwagę na to, że użytkownik 4 ma taki sam numer ID jak użytkownik 1.");
        }
        System.out.println(ADDING_FINISHED);



    }

}