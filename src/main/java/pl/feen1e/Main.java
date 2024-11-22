package pl.feen1e;

import java.util.HashSet;
import java.util.Scanner;

public class Main
{
    public final static String MENU = "";


    public static void main(String[] args)
    {

    }


    private static void ex4_hashSet(int method)
    {
        /*
         * Zaimplementuj klasę reprezentującą użytkownika z polami takimi jak:
         * nazwa użytkownika, adres e-mail i numer ID.
         * Napisz metody equals() i hashCode(), aby porównywały użytkowników na podstawie numeru ID.
         * Stwórz hashset i dodaj kilku użytkowników o tym samym numerze ID oraz kilku różnych. Przeanalizuj wynik.
         */
        var users = new HashSet<User>();

        if (method == 2)
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
            Object[][] user_examples = new Object[][]{
                    {"johnsm1th", "john.smith@example.com", 1},
                    {"j4n3d0e", "jane.doe@example.com", 2},
                    {"al1ce__", "alice.wonder@example.com", 1},
                    {"b0bu1lds", "bob.builder@example.com", 4}};

            for (Object[] user_example : user_examples)
            {
                User u = new User((String) user_example[0], (String) user_example[1], (int) user_example[2]);
                u.print();
                users.add(u);
            }
        }



    }

}