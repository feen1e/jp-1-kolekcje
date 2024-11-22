package pl.feen1e;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main
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
            1 - Wprowadzanie automatyczne
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
            """;
    public final static String ADDING_FINISHED = "Dodawanie zakończone.\n";
    public final static String AUTO_ADD = "Dodawanie automatyczne.\n";
    public final static String MANUAL_ADD = "Dodawanie manualne.\n";
    public final static String NON_NUMBER_INPUT = "Błąd: Podano znak niebędący liczbą.\nProszę wprowadzić numer wybranej opcji: ";
    private static final String COLLECTION_ITEMS = "Oto kolejne elementy znajdujące się w kolekcji:\n";
    private static final String EXIT = "Program zakończył działanie";


    public static void main(String[] args)
    {
        Main main = new Main();
        main.mainLoop();
    }

    private void mainLoop()
    {
        System.out.println(AUTHOR);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running)
        {
            System.out.println(MENU);
            int choice = -1;
            while (choice == -1)
            {
                try
                {
                    choice = Integer.parseInt(scanner.nextLine());

                    switch (choice)
                    {
                        case 1:
                        {
                            System.out.println(EXERCISE_4);
                            ex4HashSet(String.valueOf(chooseAddingMethod(scanner)));
                            break;
                        }
                        case 2:
                        {
                            System.out.println(EXERCISE_7);
                            ex7_arrayList(String.valueOf(chooseAddingMethod(scanner)));
                            break;
                        }
                        case 3:
                        {
                            System.out.println(EXERCISE_8);
                            ex8_hashMap(String.valueOf(chooseAddingMethod(scanner)));
                            break;
                        }
                        case 0:
                        {
                            running = false;
                            System.out.println(EXIT);
                            break;
                        }
                        default:
                        {
                            System.out.println("Podana opcja nie istnieje. Proszę wybrać poprawną opcję.");
                            choice = -1;
                        }
                    }
                }
                catch (NumberFormatException e)
                {
                    System.out.println(NON_NUMBER_INPUT);
                    choice = -1;
                }
            }
        }
    }

    private static int chooseAddingMethod(Scanner scanner)
    {
        System.out.println(CHOOSE_ADDING_METHOD);
        int adding_method = -1;
        while (adding_method == -1)
        {
            try
            {
                adding_method = Integer.parseInt(scanner.nextLine());
            }
            catch (NumberFormatException e)
            {
                System.out.println(NON_NUMBER_INPUT);
            }
        }
        return adding_method;
    }

    private static void ex4HashSet(String method)
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
        System.out.println(COLLECTION_ITEMS);
        for (User u : users)
        {
            u.print();
        }
        System.out.println("""
                W przypadku dodania dwóch użytkowników o takim samym numerze ID, ten drugi nie jest dodawany,
                ponieważ zmodyfikowane metody .hashCode() i .equals() w klasie User sprawdzają tylko numery ID.
                Ze względu na to, metoda .add() pomija drugiego użytkownika z takim samym numerem ID, gdyż
                zgodnie z wynikiem metody .equals() są oni tacy sami, a HashSet nie dopuszcza duplikatów.""");
    }

    private static void ex7_arrayList(String method)
    {
        /*
        Stwórz klasę reprezentującą produkt z polami, takimi jak nazwa i cena.
        Zaimplementuj interfejs Comparable, aby produkty były porównywane na podstawie nazwy.
        Stwórz listę produktów i posortuj ją za pomocą Collections.sort(). Następnie wyświetl posortowaną listę.
        Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania produktów według ceny.
        Wyświetl wynik i porównaj go z poprzednim.
         */

        ArrayList<Product> products = new ArrayList<>();

        if (Objects.equals(method, "2"))
        {
            System.out.println(MANUAL_ADD);
            int numberOfProducts = 0;
            while (numberOfProducts == 0)
            {
                try
                {
                    var scanner = new Scanner(System.in);
                    System.out.print("Podaj liczbę produktów do wpisania: ");
                    numberOfProducts = Integer.max(Integer.parseInt(scanner.nextLine()), 0);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("Błąd: Liczba produktów musi być liczbą całkowitą większą od 0.");
                }
            }
            for (int i = 0; i < numberOfProducts; i++)
            {
                Product p = Product.createProductFromInput();
                if (p != null)
                {
                    products.add(p);
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
            Object[][] product_examples = new Object[][]{
                    {1, "Milk", 3.99},
                    {2, "Mandarin 1kg", 7.99},
                    {3, "Bread", 4.59}};

            for (Object[] product_example : product_examples)
            {
                Product p = new Product((int) product_example[0], (String) product_example[1], (double) product_example[2]);
                p.print();
                products.add(p);
            }
        }
        System.out.println(ADDING_FINISHED);
        System.out.println(COLLECTION_ITEMS);
        for (Product p : products)
        {
            p.print();
        }
    }

    private static void ex8_hashMap(String method)
    {

    }
}