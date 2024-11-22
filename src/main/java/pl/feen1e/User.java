package pl.feen1e;

import java.util.Scanner;

/*
 * Zaimplementuj klasę reprezentującą użytkownika z polami takimi jak:
 * nazwa użytkownika, adres e-mail i numer ID.
 * Napisz metody equals() i hashCode(), aby porównywały użytkowników na podstawie numeru ID.
 * Stwórz hashset i dodaj kilku użytkowników o tym samym numerze ID oraz kilku różnych. Przeanalizuj wynik.
 */

import java.util.Objects;

public class User
{
    private String name;
    private String email;
    private final int ID;

    public User(String name, String email, int ID)
    {
        this.name = name;
        this.email = email;
        this.ID = ID;
    }

    public void print()
    {
        System.out.printf("""
                Name: %s
                Email: %s
                ID: %d%n%n""", name, email, ID);
    }

    public static User createUserFromInput()
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            String name, email;
            int id;

            System.out.print("Podaj nazwę użytkownika: ");
            name = scanner.nextLine();

            System.out.print("Podaj adres e-mail: ");
            email = scanner.nextLine();

            System.out.print("Podaj numer ID: ");
            id = Integer.parseInt(scanner.nextLine());

            return new User(name, email, id);
        }
        catch (NumberFormatException e)
        {
            System.out.println("Błąd: Podano nieprawidłowy numer ID. ID musi być liczbą.");
        }

        return null;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (!(o instanceof User user))
        {
            return false;
        }
        return ID == user.ID;
    }

    @Override
    public int hashCode()
    {
        return Objects.hashCode(ID);
    }
}
