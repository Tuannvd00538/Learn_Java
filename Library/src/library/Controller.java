/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class Controller {
    Scanner input = new Scanner(System.in);
    public int getHome() {
        System.out.println("1. Add Author");
        System.out.println("2. Add Publishing Company");
        System.out.println("3. Add Book");
        System.out.println("4. Info Author");
        System.out.println("5. Info Publishing Company");
        System.out.println("6. Info Book");
        System.out.println("7. Find Author/Publishing Company/Book");
        System.out.println("8. Save Data");
        System.out.println("9. Get Data");
        System.out.println("10. Close");
        System.out.println("------------------------------------");
        System.out.println("Please enter your choice:");
        int choice = Integer.parseInt(input.nextLine());
        return choice;
    }
    
    File authorFile = new File("\\Users\\Ngo Van Tuan\\Documents\\NetBeansProjects\\Library\\src\\save\\author.obj");
    File pcFile = new File("\\Users\\Ngo Van Tuan\\Documents\\NetBeansProjects\\Library\\src\\save\\pc.obj");
    File bookFile = new File("\\Users\\Ngo Van Tuan\\Documents\\NetBeansProjects\\Library\\src\\save\\book.obj");
    
    public void addAuthor() throws IOException, ClassNotFoundException {
        System.out.println("------------------------------------");
        System.out.println("How many authors do you want?");
        int intauthor = Integer.parseInt(input.nextLine());
        for (int i = 0; i < intauthor; i++) {
            System.out.println("------------------------------------");
            System.out.println("Please enter the author's name:");
            String name = input.nextLine();
            System.out.println("Please enter the author's birthday:");
            int age = Integer.parseInt(input.nextLine());
            System.out.println("Please enter the author's gender:");
            int gender = Integer.parseInt(input.nextLine());
            System.out.println("Please enter the author's pseudonym:");
            String pseudonym = input.nextLine();
            System.out.println("Please enter the author's address:");
            String address = input.nextLine();
            Author author = new Author(name, age, gender, pseudonym, address);
            FileOutputStream output = new FileOutputStream(authorFile);
            ObjectOutputStream outObj = new ObjectOutputStream(output);
            outObj.writeObject(author);
            outObj.close();
            output.close();
            System.out.println("Add author success!");
        }
    }
    
    public void addPC() throws IOException, ClassNotFoundException {
        System.out.println("------------------------------------");
        System.out.println("How many publishing company do you want?");
        int intauthor = Integer.parseInt(input.nextLine());
        for (int i = 0; i < intauthor; i++) {
            System.out.println("------------------------------------");
            System.out.println("Please enter the publishing company name:");
            String name = input.nextLine();
            System.out.println("Please enter the publishing company address:");
            String address = input.nextLine();
            PublishingCompany pc = new PublishingCompany(name, address);
            FileOutputStream output = new FileOutputStream(pcFile);
            ObjectOutputStream outObj = new ObjectOutputStream(output);
            outObj.writeObject(pc);
            outObj.close();
            output.close();
            System.out.println("Add publishing company success!");
        }
    }
    
    public void addBook() throws IOException, ClassNotFoundException {
        System.out.println("------------------------------------");
        System.out.println("How many book do you want?");
        int intauthor = Integer.parseInt(input.nextLine());
        for (int i = 0; i < intauthor; i++) {
            System.out.println("------------------------------------");
            System.out.println("Please enter the book name:");
            String name = input.nextLine();
            System.out.println("Please enter the book kind:");
            String kind = input.nextLine();
            System.out.println("Please enter the book author:");
            String author = input.nextLine();
            System.out.println("Please enter the book publishing year:");
            int py = Integer.parseInt(input.nextLine());
            System.out.println("Please enter the book publishing company:");
            String pc = input.nextLine();
            Book book = new Book(name, kind, author, py, author);
            FileOutputStream output = new FileOutputStream(bookFile);
            ObjectOutputStream outObj = new ObjectOutputStream(output);
            outObj.writeObject(book);
            outObj.close();
            output.close();
            System.out.println("Add book success!");
        }
    }
    
    public void infoAuthor() throws FileNotFoundException, IOException, ClassNotFoundException {
        System.out.println("------------------------------------");
        System.out.println("List author:");
        FileInputStream in = new FileInputStream(authorFile);
        ObjectInputStream inObj = new ObjectInputStream(in);
        Author author = (Author) inObj.readObject();
        inObj.close();
        in.close();
        System.out.println(author);
    }

    public void infoBook() {
        
    }
}
