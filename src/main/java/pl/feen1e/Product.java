package pl.feen1e;

/*
 * Stwórz klasę reprezentującą produkt z polami, takimi jak nazwa i cena.
 * Zaimplementuj interfejs Comparable, aby produkty były porównywane na podstawie nazwy.
 * Stwórz listę produktów i posortuj ją za pomocą Collections.sort(). Następnie wyświetl posortowaną listę.
 * Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania produktów według ceny.
 * Wyświetl wynik i porównaj go z poprzednim.
 */
public class Product
{
    private final int id;
    private String name;
    private double price;

    public Product(int id, String name, double price)
    {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void print()
    {
        System.out.printf("""
                ID: %d
                Name: %s
                Price: %.2f%n%n""", id, name, price);
    }

    public static Product createProductFromInput(){
        return null;
    }
}
