/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.siinblog.book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class Controller {
    Book book1 = new Book(261199, "Hom Nay Toi That Tinh", "Ha Vu", "Ha Noi");
    Book book2 = new Book(271200, "Cot Cach Phu Nu", "Huyen Trang Bat Hoi", "Ha Noi");
    Book book3 = new Book(280101, "Phu Nu Van Nguoi Me", "Huyen Trang Bat Hoi", "Ha Noi");
    Book book4 = new Book(290202, "Ngay Nguoi Thuong Mot Nguoi Thuong Khac", "Tri", "Ha Noi");
    Book book5 = new Book(300303, "Manh Me Va Co Doc", "Phuong Ny", "Ha Noi");
    ArrayList<Book> listString = new ArrayList(Arrays.asList(book1, book2, book3, book4, book5));
    
    Scanner sc = new Scanner(System.in);
    
    public String getHomePage() {
        System.out.println("-----------------------------------");
        System.out.println("1. Xem sách");
        System.out.println("2. Tìm kiếm sách");
        System.out.println("3. Thêm sách");
        System.out.println("4. Đóng chương trình");
        String pick = sc.nextLine();
        return pick;
    }
    
    public int indexBook;
    
    public int getList() {
        System.out.println("-----------------------------------");
        for (int i = 0; i < listString.size(); i++) {
            Book get = listString.get(i);
            System.out.println((i + 1) + ". " + get.getName());
        }
        System.out.println("-----------------------------------");
        System.out.println("0. Cancel");
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng chọn:");
        Scanner sc = new Scanner(System.in);
        int select = sc.nextInt();
        indexBook = select - 1;
        return select;
    }
    
    public String getDetail() {
        System.out.println("-----------------------------------");
        System.out.println("ID: " + listString.get(indexBook).getID());
        System.out.println("Tên sách: " + listString.get(indexBook).getName());
        System.out.println("Tác giả: " + listString.get(indexBook).getAuthor());
        System.out.println("Nhà xuất bản: " + listString.get(indexBook).getNXB());
        System.out.println("------------------------");
        System.out.println("1. Sửa sách");
        System.out.println("2. Xóa sách");
        System.out.println("3. Cancel");
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng chọn:");
        String select = sc.nextLine();
        return select;
    }

    public String edit() {
        System.out.println("-----------------------------------");
        System.out.println("1. Sửa tên sách");
        System.out.println("2. Sửa tên tác giả");
        System.out.println("3. Sửa tên nhà xuất bản");
        System.out.println("4. Cancel");
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng chọn:");
        String select = sc.nextLine();
        return select;
    }

    public String remove() {
        System.out.println("-----------------------------------");
        System.out.println("Bạn có chắc chắn muốn xóa sách không?");
        System.out.println("1. Có");
        System.out.println("2. Hủy");
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng chọn:");
        String select = sc.nextLine();
        return select;
    }

    public String search() {
        System.out.println("-----------------------------------");
        System.out.println("Bạn muốn tìm kiếm sách theo:");
        System.out.println("1. Tên sách");
        System.out.println("2. Tên tác giả");
        System.out.println("3. Tên nhà xuất bản");
        System.out.println("4. Cancel");
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng chọn:");
        String select = sc.nextLine();
        return select;
    }

    public String findByName() {
        System.out.println("-----------------------------------");
        System.out.println("Nhập tên sách muốn tìm kiếm:");
        String select = sc.nextLine();
        int count = 0;
        for (int i = 0; i < listString.size(); i++) {
            if (listString.get(i).getName().toUpperCase().contains(select.toUpperCase())) {
                System.out.println("Tên sách: " + listString.get(i).getName() + " - Tác giả: " + listString.get(i).getAuthor() + " - Nhà xuất bản: " + listString.get(i).getNXB());
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không có cuốn sách nào trùng tên bạn vừa nhập!");
        }
        return select;
    }
    
    public String findByAuthor() {
        System.out.println("-----------------------------------");
        System.out.println("Nhập tên tác giả muốn tìm kiếm:");
        String select = sc.nextLine();
        int count = 0;
        for (int i = 0; i < listString.size(); i++) {
            if (listString.get(i).getAuthor().toUpperCase().contains(select.toUpperCase())) {
                System.out.println("Tên sách: " + listString.get(i).getName() + " - Tác giả: " + listString.get(i).getAuthor() + " - Nhà xuất bản: " + listString.get(i).getNXB());
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không có cuốn sách nào của tác giả bạn vừa nhập!");
        }
        return select;
    }
    
    public String findByNXB() {
        System.out.println("-----------------------------------");
        System.out.println("Nhập tên nhà xuất bản muốn tìm kiếm:");
        String select = sc.nextLine();
        int count = 0;
        for (int i = 0; i < listString.size(); i++) {
            if (listString.get(i).getNXB().toUpperCase().contains(select.toUpperCase())) {
                System.out.println("Tên sách: " + listString.get(i).getName() + " - Tác giả: " + listString.get(i).getAuthor() + " - Nhà xuất bản: " + listString.get(i).getNXB());
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Không có cuốn sách nào của nhà xuất bản bạn vừa nhập!");
        }
        return select;
    }

    public String editName() {
        System.out.println("-----------------------------------");
        System.out.println("Tên sách cũ: " + listString.get(indexBook).getName());
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng nhập tên sách mới:");
        String select = sc.nextLine();
        listString.get(indexBook).setName(select);
        return select;
    }
    
    public String editAuthor() {
        System.out.println("-----------------------------------");
        System.out.println("Tên tác giả: " + listString.get(indexBook).getAuthor());
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng nhập tên tác giả mới:");
        String select = sc.nextLine();
        listString.get(indexBook).setAuthor(select);
        return select;
    }
    
    public String editNXB() {
        System.out.println("-----------------------------------");
        System.out.println("Tên nhà xuất bản cũ: " + listString.get(indexBook).getNXB());
        System.out.println("-----------------------------------");
        System.out.println("Vui lòng nhập tên nhà xuất bản mới:");
        String select = sc.nextLine();
        listString.get(indexBook).setNXB(select);
        return select;
    }

    public void removeBook() {
        listString.remove(indexBook);
    }

    public Book addBook() {
        int id = new Random().nextInt(99999) + 100000;
        System.out.println("Nhập tên cuốn sách:");
        String name = sc.nextLine();
        System.out.println("Nhập tên tác giả:");
        String author = sc.nextLine();
        System.out.println("Nhập tên nhà xuất bản:");
        String nxb = sc.nextLine();
        Book book = new Book(id, name, author, nxb);
        listString.add(book);
        return book;
    }
}