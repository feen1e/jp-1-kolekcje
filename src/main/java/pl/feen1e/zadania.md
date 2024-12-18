﻿## Wymagane jest wykonanie przynajmniej trzech zadań obejmujących tematykę zbiorów, list i map.

1. Zaimplementuj program, który przyjmuje od użytkownika ciąg słów i przechowuje je w zbiorze typu HashSet i TreeSet. Następnie wyświetl różnice między HashSet a TreeSet w kontekście kolejności słów. Porównaj również czas dodawania i usuwania elementów w obu zbiorach.
2. Stwórz program, który generuje losowe liczby i dodaje je do listy typu ArrayList i LinkedList. Następnie przetestuj, jak długo trwa dodawanie, usuwanie i przeszukiwanie elementów w obu listach.
3. Stwórz aplikację do zarządzania słownikiem, gdzie użytkownicy mogą dodawać słowa i ich definicje. Zaimplementuj mapę typu HashMap i TreeMap do przechowywania słów i definicji. Następnie porównaj, jakie są różnice w kolejności wyświetlania słów w obu mapach.
4. ### <u>**Zaimplementuj klasę reprezentującą użytkownika z polami takimi jak nazwa użytkownika, adres e-mail i numer ID. Napisz metody equals() i hashCode(), aby porównywały użytkowników na podstawie numeru ID. Stwórz HashSet i dodaj kilku użytkowników o tym samym numerze ID oraz kilku różnych. Przeanalizuj wynik.**</u>
5. Stwórz klasę reprezentującą zamówienie z polami, takimi jak numer zamówienia, data i kwota. Zaimplementuj interfejs Comparable, aby zamówienia były porównywane na podstawie daty. Stwórz listę zamówień i posortuj ją za pomocą Collections.sort(). Następnie wyświetl posortowaną listę.
    * Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania zamówień według kwoty. Wyświetl wynik i porównaj go z poprzednim.
6. Zaimplementuj klasę reprezentującą samochód z polami takimi jak marka, model i numer rejestracyjny. Nadpisz metody equals() i hashCode(), aby porównywały samochody na podstawie numeru rejestracyjnego. Stwórz HashSet i dodaj kilka samochodów o tym samym numerze rejestracyjnym oraz kilka różnych. Przeanalizuj wynik.
7. ### <u>**Stwórz klasę reprezentującą produkt z polami, takimi jak nazwa i cena. Zaimplementuj interfejs Comparable, aby produkty były porównywane na podstawie nazwy. Stwórz listę produktów i posortuj ją za pomocą Collections.sort(). Następnie wyświetl posortowaną listę.**
    * ### **Zmodyfikuj zadanie, aby tym razem użyć własnego komparatora do sortowania produktów według ceny. Wyświetl wynik i porównaj go z poprzednim.**
8. ### **Stwórz mapę, w której kluczami są niestandardowe obiekty reprezentujące daty. Nadpisz metody equals() i hashCode() tych obiektów, aby zapewnić poprawne porównywanie. Dodaj kilka elementów do mapy i przetestuj, czy możesz znaleźć elementy za pomocą tych niestandardowych kluczy.**</u>
9. Stwórz klasę reprezentującą zwierzę z polami, takimi jak gatunek, wiek i waga. Napisz komparator, który sortuje zwierzęta najpierw według gatunku, a następnie według wieku. Stwórz listę zwierząt i posortuj ją za pomocą tego komparatora. Wyświetl posortowaną listę.
    * Rozwiń zadanie, aby tym razem użyć niestandardowego komparatora, który sortuje zwierzęta na podstawie wagi od najlżejszego do najcięższego. Wyświetl wynik i porównaj go z poprzednim.
10. Stwórz klasę reprezentującą rzekę. Rzeka ma nazwę w języku polskim, niemieckim i czeskim, nazwę rzeki, do której wpływa oraz przebieg (pole typu String). Następnie stwórz kolekcję (typ do samodzielnego wyboru) umożliwiającą przechowywanie rzek i wyświetlanie ich w zadanym porządku (wg. języka nazw).
    * przebieg jest kolekcją punktów (double lat,lon;), a nie opisem słownym
    * zaproponuj rozwiązanie umożliwiające wyświetlanie bez konieczności każdorazowego sortowania przy zmianie języka
    * dodaj możliwość filtracji rzek umożliwiając wyświetlanie dorzecza danej rzeki

# Prowadzący: dr inż. Tomasz Babczyński
