package pl.feen1e;

/*
 * Stwórz mapę, w której kluczami są niestandardowe obiekty reprezentujące daty.
 * Nadpisz metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie.
 * Dodaj kilka elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych kluczy.
 */

public class Date
{
    private final int day;
    private final int month;
    private final int year;

    public Date(int day, int month, int year)
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static Date createDateFromInput()
    {
        return null;
    }
}
