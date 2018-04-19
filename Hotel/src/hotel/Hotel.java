/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class Hotel {
    
    /**
     * @param args the command line arguments
     */
    
    private String name;
    private String location;
    private String ownerName;
    
    public Hotel() {
        name = "Xuan Hung";
        location = "Ha Noi";
        ownerName = "Dao Hong Luyen";
    }

    public Hotel(String name, String location, String ownerName) {
        this.name = name;
        this.location = location;
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Hotel hotel1 = new Hotel("Hoang Sang", "Ha Noi", "Hoang Sang");
        Hotel hotel2 = new Hotel("Hoang Hung", "Hung Yen", "Phan Van Hoang Hung");
        Hotel hotel3 = new Hotel("Siin Dep Trai", "Ha Noi", "Ngo Van Tuan");
        Hotel hotel4 = new Hotel("Tuk Mat Lon", "Hung Yen", "Dao Tuan Tu");
        Hotel hotel5 = new Hotel("Ngac Coc", "Quang Ninh", "Nguyen Van Ngoc");
        Hotel hotel6 = new Hotel("Bun Yeol", "Hai Duong", "Nguyen Van Hanh");
        Hotel hotel7 = new Hotel("Caption Bach Nhuc", "Hai Duong", "Nguyen Tuan Minh");
        Hotel hotel8 = new Hotel("Trong Kax", "Gia Lai", "Duong Trong");
        Hotel hotel9 = new Hotel("Nguyen Tuan", "Ha Noi", "Nguyen Xuan Tuan");
        ArrayList<Hotel> listHotel = new ArrayList(Arrays.asList(hotel, hotel1, hotel2, hotel3, hotel4, hotel5, hotel6, hotel7, hotel8, hotel9));
        
        System.out.println("Nhập tên chủ khách sạn:");
        Scanner input = new Scanner(System.in);
        String ownerName = input.nextLine();
        int count = 0;
        for (int i = 0; i < listHotel.size(); i++) {
            Hotel get = listHotel.get(i);
            if (get.getOwnerName().equals(ownerName)) {
                System.out.println("Tên khách sạn: " + get.getName() + " - Địa Chỉ: " + get.getLocation() + " - Chủ sở hữu: " + get.getOwnerName());
                count++;
            }
        }
        if (count == 0){
            System.err.println("Tên chủ khách sạn vừa nhập không tồn tại trong hệ thống của chúng tôi!");
        }
    }
    
}
