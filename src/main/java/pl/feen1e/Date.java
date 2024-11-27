package pl.feen1e;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/*
 * Stwórz mapę, w której kluczami są niestandardowe obiekty reprezentujące daty.
 * Nadpisz metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie.
 * Dodaj kilka elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych kluczy.
 */

// Klasa reprezentująca datę na potrzeby zadania 8
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

    public void print()
    {
        System.out.printf("%02d.%02d.%04d: ", day, month, year);
    }

    // Tworzenie daty z danych wejściowych
    public static Date createDateFromInput()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Podaj datę w formacie DD.MM.RRRR: ");
            String date = scanner.nextLine();
            if (!isValidDate(date))
            {
                System.out.println("Podano nieprawidłową datę.");
                return null;
            }
            String[] dateArray = date.split("\\.");
            return new Date(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));

        }
        catch (PatternSyntaxException | ArrayIndexOutOfBoundsException | NumberFormatException e)
        {
            System.out.print("Podano datę w nieprawidłowym formacie. ");
        }
        catch (NullPointerException e)
        {
            System.out.print("Nie podano daty. ");
        }

        return null;
    }

    // Tworzenie daty z wcześniej podanych danych
    public static Date createDate(String date)
    {
        try
        {
            if (!isValidDate(date))
            {
                System.out.println("Podano nieprawidłową datę.");
                return null;
            }
            String[] dateArray = date.split("\\.");
            return new Date(Integer.parseInt(dateArray[0]), Integer.parseInt(dateArray[1]), Integer.parseInt(dateArray[2]));
        }
        catch (PatternSyntaxException | ArrayIndexOutOfBoundsException | NumberFormatException e)
        {
            System.out.print("Podano datę w nieprawidłowym formacie. ");
        }
        catch (NullPointerException e)
        {
            System.out.print("Nie podano daty. ");
        }
        return null;
    }

    // Tworzenie wydarzenia na podstawie danych wejściowych
    public static String createEvent()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Podaj nazwę wydarzenia: ");
            return scanner.nextLine();
        }
        catch (NullPointerException e)
        {
            System.out.println("Nie podano nazwy wydarzenia. ");
        }
        return null;
    }

    // Funkcja sprawdzająca, czy data jest prawidłowa
    public static boolean isValidDate(String date)
    {
        String[] dateArray = date.split("\\.");
        int day = Integer.parseInt(dateArray[0]);
        int month = Integer.parseInt(dateArray[1]);
        int year = Integer.parseInt(dateArray[2]);

        if (month < 1 || month > 12)
        {
            return false;
        }

        int[] daysInEachMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        boolean leapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);

        if (month == 2 && leapYear)
        {
            daysInEachMonth[1] = 29;
        }

        return day > 0 && day <= daysInEachMonth[month - 1];
    }

    // Te metody equals() i hashCode() zapewniają, że daty są porównywane na podstawie dni oraz miesięcy, oraz lat
    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof Date date))
        {
            return false;
        }
        return day == date.day && month == date.month && year == date.year;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(day, month, year);
    }
}
