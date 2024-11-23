package pl.feen1e;

import java.util.Scanner;

/*
 * Stwórz klasę reprezentującą produkt z polami, takimi jak nazwa i cena.
 * Zaimplementuj interfejs Comparable, aby produkty były porównywane na podstawie nazwy.
 * Stwórz listę produktów i posortuj ją za pomocą Collections.sort(). Następnie wyświetl posortowaną listę.
 * Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania produktów według ceny.
 * Wyświetl wynik i porównaj go z poprzednim.
 */
public class Product implements Comparable<Product>
{
    private String name;
    private double price;

    public Product(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public void print()
    {
        System.out.printf("""
                Name: %s
                Price: %.2f zł%n%n""", name, price);
    }

    public static Product createProductFromInput()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            String name;
            double price;

            System.out.print("Podaj nazwę produktu: ");
            name = scanner.nextLine();

            System.out.print("Podaj cenę produktu: ");
            price = Double.parseDouble(scanner.nextLine());

            return new Product(name, price);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Błąd: Podano nieprawidłową cenę. Cena musi być liczbą.");
        }

        return null;
    }

    @Override
    public int compareTo(Product other)
    {
        return this.name.compareTo(other.name);
    }
}
