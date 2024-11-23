package pl.feen1e;

/*
 * Stwórz mapę, w której kluczami są niestandardowe obiekty reprezentujące daty.
 * Nadpisz metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie.
 * Dodaj kilka elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych kluczy.
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

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
        System.out.printf("%02d.%02d.%4d: ", day, month, year);
    }

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

    public static boolean isValidDate(String date)
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.M.yyyy");
        try
        {
            LocalDate parsedDate = LocalDate.parse(date, formatter);
            return true;
        }
        catch (DateTimeParseException e)
        {
            return false;
        }
    }

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
