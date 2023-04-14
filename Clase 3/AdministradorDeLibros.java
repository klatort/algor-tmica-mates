/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject3;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.List;


/**
 *
 * @author Ander
 */

class Book {
    String title;
    String author;
    int year;
    int price;
    
    public Book(String title, String author, int year, int price) {
        this.title  = title;
        this.author = author;
        this.year   = year;
        this.price  = price;
    }
    
}


public class AdministradorDeLibros {
    
    public static int input(int n) {
        Scanner in = new Scanner(System.in);
        int opc = in.nextInt();
        if (IntStream.rangeClosed(1, n).boxed().anyMatch(e -> e == opc)) {
            return opc;
        } else {
            System.out.println("Vuelva a ingresar la opcion");
            return input(n);
        }
    }

    public static void showBook(Book book) {
        System.out.println("Titulo: " + book.title);
        System.out.println("Autor: " + book.author);
        System.out.println("Año de publicacion: " + book.year);
        System.out.println("Precio: " + book.price);
    }
    
    

    public static void addBook(List<Book> stateBooks) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Ingrese el titulo del libro");
        String title  = in.next().toLowerCase();
                
        System.out.println("Ingrese el autor libro");
        String author = in.next();
        
        System.out.println("Ingrese el año de publicacion del libro");
        int year      = in.nextInt();
        
        System.out.println("Ingrese el precio del libro");
        int price     = in.nextInt();
        
        stateBooks.add(new Book(title, author, year, price));
    }
    
    public static Book findBook(List<Book> stateBooks) { 
        Scanner in = new Scanner(System.in);
        
        System.out.println("Ingrese el titulo del libro");
        String title  = in.next();
        
        return stateBooks.stream()
            .filter(book -> title.equals(book.title))
            .findAny()
            .orElse(null);
    }
    
    public static void listBooks(List<Book> stateBooks) { 
        stateBooks.forEach(book -> showBook(book));
    }
    
    public static Integer priceBooks(List<Book> stateBooks) {
        return stateBooks.stream().map(book -> book.price).reduce(0, (a, b) -> a + b);
    }
    
    

    public static void newInterface(List<Book> stateBooks) {
        System.out.println("\tBienvenido al gestor de libros\b");
        System.out.println("1. Agregar un libro");
        System.out.println("2. Buscar un libro");
        System.out.println("3. Listar todos los libros");
        System.out.println("4. Calcular el precio total");
        System.out.println("5. Salir");
        
        int opc = input(5);
        
        if (opc != 5) {
            switch (opc) {
                case 1:
                    addBook(stateBooks);
                    break;
                case 2: 
                    Book maybeBook = findBook(stateBooks);
                    if (maybeBook != null) {
                        showBook(maybeBook);
                    } else {
                        System.out.println("Ese libro no existe");
                    }
                    break;
                case 3: 
                    listBooks(stateBooks);
                    break;
                case 4:
                    System.out.println("El precio total es: " + priceBooks(stateBooks));
                    break;
            }
            
            newInterface(stateBooks);
        }
    }
    
    public static void main(String[] args) {
        List<Book> stateBooks = new ArrayList<Book>();
        newInterface(stateBooks); 
    }
}
