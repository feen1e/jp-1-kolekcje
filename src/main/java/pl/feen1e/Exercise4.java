package pl.feen1e;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

import static pl.feen1e.Constants.ADDING_FINISHED;
import static pl.feen1e.Constants.AUTO_ADD;
import static pl.feen1e.Constants.COLLECTION_ITEMS;
import static pl.feen1e.Constants.MANUAL_ADD;

/*
 * Zaimplementuj klasę reprezentującą użytkownika z polami takimi jak:
 * nazwa użytkownika, adres e-mail i numer ID.
 * Napisz metody equals() i hashCode(), aby porównywały użytkowników na podstawie numeru ID.
 * Stwórz hashset i dodaj kilku użytkowników o tym samym numerze ID oraz kilku różnych. Przeanalizuj wynik.
 */

// Klasa odpowiadająca za zadanie 4
public class Exercise4
{
    public static void ex4HashSet(String method)
    {
        HashSet<User> users = new HashSet<>();

        // Ta część odpowiada za dodawanie kolejnych elementów do setu: kiedy metoda wpisywania równa się 2,
        // użytkownik jest proszony o wpisywanie ręczne; w przeciwnym wypadku elementy dodawane są automatycznie
        if (Objects.equals(method, "2"))
        {
            System.out.println(MANUAL_ADD);
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
            System.out.println(AUTO_ADD);
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
        // Wypisanie elementów kolekcji
        System.out.println(COLLECTION_ITEMS);
        for (User u : users)
        {
            u.print();
        }

        // Wyjaśnienie / wnioski
        System.out.println("""
                W przypadku dodania dwóch użytkowników o takim samym numerze ID, ten drugi nie jest dodawany,
                ponieważ zmodyfikowane metody .hashCode() i .equals() w klasie User sprawdzają tylko numery ID.
                Ze względu na to, metoda .add() pomija drugiego użytkownika z takim samym numerem ID, gdyż
                zgodnie z wynikiem metody .equals() są oni tacy sami, a HashSet nie dopuszcza duplikatów.""");
    }
}
