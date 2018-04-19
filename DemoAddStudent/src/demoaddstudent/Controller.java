/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoaddstudent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class Controller {
    Scanner input = new Scanner(System.in);
    Student student1 = new Student("Ngo Van Tuan", "26/11/1999", "D00538", 1);
    Student student2 = new Student("Phan Van Hoang Hung", "26/03/1999", "D00539", 2);
    Student student3 = new Student("Duong Van Trong", "01/04/1999", "D00540", 1);
    Student student4 = new Student("Dao Tuan Tu", "08/03/1999", "D00541", 2);
    Student student5 = new Student("Nguyen Van Ngoc", "20/10/1999", "D00542", 1);
    ArrayList<Student> students = new ArrayList<Student>(Arrays.asList(student1,student2,student3,student4,student5));
    public int getMenu() {
        System.out.println("-----------------------------------");
        System.out.println("1. Them sinh vien");
        System.out.println("2. Danh sach sinh vien");
        System.out.println("3. Thoat");
        System.out.println("-----------------------------------");
        System.out.println("Vui long chon:");
        int choice = Integer.parseInt(input.nextLine());
        return choice;
    }

    public void addSV() {
        System.out.println("-----------------------------------");
        System.out.println("Nhap ma sinh vien:");
        String rollNumber = input.nextLine();
        System.out.println("Nhap ten sinh vien:");
        String name = input.nextLine();
        System.out.println("Nhap ngay sinh (dd/mm/yyyy):");
        String birthday = input.nextLine();
        System.out.println("Nhap gioi tinh (1: Nam, 2: Nu):");
        int gender = Integer.parseInt(input.nextLine());
        Student student = new Student(name, birthday, rollNumber, gender);
        students.add(student);
        System.out.println("Them thanh cong!");
    }

    public void getSv() {
        System.out.println("-----------------------------------");
        System.out.println("Danh sach sinh vien:");
        if (students.size() == 0) {
            System.err.println("Chua co sinh vien nao trong danh sach!");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).getName() + " - " + students.get(i).getRollNumber());
            }
        }
    }
}
