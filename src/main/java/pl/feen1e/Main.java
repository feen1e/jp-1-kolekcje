package pl.feen1e;

import java.util.Scanner;

import static pl.feen1e.Constants.AUTHOR;
import static pl.feen1e.Constants.CHOOSE_ADDING_METHOD;
import static pl.feen1e.Constants.EXERCISE_4;
import static pl.feen1e.Constants.EXERCISE_7;
import static pl.feen1e.Constants.EXERCISE_8;
import static pl.feen1e.Constants.EXIT;
import static pl.feen1e.Constants.MENU;
import static pl.feen1e.Constants.NON_NUMBER_INPUT;

public class Main
{
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
                            Exercise4.ex4HashSet(String.valueOf(chooseAddingMethod(scanner)));
                            break;
                        }
                        case 2:
                        {
                            System.out.println(EXERCISE_7);
                            Exercise7.ex7ArrayList(String.valueOf(chooseAddingMethod(scanner)));
                            break;
                        }
                        case 3:
                        {
                            System.out.println(EXERCISE_8);
                            Exercise8.ex8HashMap(String.valueOf(chooseAddingMethod(scanner)));
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
}