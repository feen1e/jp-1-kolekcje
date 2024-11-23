package pl.feen1e;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

import static pl.feen1e.Constants.ADDING_FINISHED;
import static pl.feen1e.Constants.AUTO_ADD;
import static pl.feen1e.Constants.COLLECTION_ITEMS;
import static pl.feen1e.Constants.MANUAL_ADD;

public class Exercise7
{
    public static void ex7ArrayList(String method)
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
                    {"Milk", 4.99},
                    {"Mandarin 1kg", 7.99},
                    {"Bread", 4.59},
                    {"Cookies", 3.99},
                    {"Milk", 3.99}};

            for (Object[] product_example : product_examples)
            {
                Product p = new Product((String) product_example[0], (double) product_example[1]);
                p.print();
                products.add(p);
            }
        }
        System.out.println(ADDING_FINISHED);
        Collections.sort(products);
        System.out.println("Produkty zostały posortowane alfabetycznie.");
        System.out.println(COLLECTION_ITEMS);
        for (Product p : products)
        {
            p.print();
        }
        Collections.sort(products, Comparator.comparingDouble(Product::getPrice).thenComparing(Product::getName));
        System.out.println("Następnie posortowano je według ceny (oraz nazwy, gdy produkty mają taką samą cenę), " +
                "używając własnego komparatora.");
        System.out.println(COLLECTION_ITEMS);
        for (Product p : products)
        {
            p.print();
        }

        System.out.println("""
                Sortowanie bez użycia własnego komparatora, czyli Collections.sort(products) wymaga
                zaimplementowania w klasie porównywanych obiektów interfejsu Comparable i zdefiniowaniu
                metody .compareTo(), używanej podczas sortowania. Warto użyć tego podejścia jeśli
                istnieje zdefiniowany jednoznaczny porządek sortowania (np. alfabetycznie, po ID)
                często używany w aplikacji. Użycie różnych komparatorów jest jednak lepsze, gdy
                potrzeba różnych porządków sortownia w zależności od kontekstu (np. raz po nazwie,
                innym razem po cenie lub ID). Pozwalają też one na oddzielenie logiki sortowania od
                klasy, dzięki czemu mają one mniejszą złożoność.""");
    }

}
