/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech;

import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class EventController {
    EventModel em = new EventModel();
    public String getHome() {
        System.out.println("—————— Quản lý sự kiện ———————");
        System.out.println("1. Thêm mới sự kiện");
        System.out.println("2. Hiển thị danh sách sự kiện");
        System.out.println("3. Tìm sự kiện theo mã");
        System.out.println("4. Thoát chương trình");
        Scanner input = new Scanner(System.in);
        String ip = input.nextLine();
        return ip;
    }

    public Event add() {
        Scanner input = new Scanner(System.in);
        System.out.println("Tên sự kiện:");
        String name = input.nextLine();
        System.out.println("Thời gian bắt đầu (mm/dd/yyyy):");
        String createAt = input.nextLine();
        System.out.println("Thời gian kết thúc (mm/dd/yyyy):");
        String endAt = input.nextLine();
        System.out.println("Loại sự kiện:");
        System.out.println("1. Hội thảo");
        System.out.println("2. Team building");
        int category = input.nextInt();
        Event event = new Event(name, createAt, endAt, category);
        em.addEvent(event);
        return event;
    }

    public String find() {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập mã sự kiện:");
        String code = input.nextLine();
        em.findEvent(code);
        return code;
    }
    
}
