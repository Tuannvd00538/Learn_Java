/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainreader;

import controller.DantriReader;
import controller.Reader;
import controller.VnexpressReader;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class MainReader {
    
    public static void main(String[] args) {
        generareMenu();
    }
    
    public static void generareMenu () {
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------------------------");
        System.out.println("1. Vnexpress");
        System.out.println("2. Dantri");
        System.out.println("-------------------------------");
        System.out.println("Vui lòng chọn:");
        int choice = input.nextInt();
        Reader reader;
        if (choice == 1) {
            reader = new VnexpressReader();
        } else {
            reader = new DantriReader();
        }
        
        while (true) {
            System.out.println("-------------------------------");
            System.out.println("1. Đọc tin trang chủ");
            System.out.println("2. Danh sách danh mục");
            System.out.println("3. Thoát");
            int text = input.nextInt();
            switch (text) {
                case 1:
                    boolean option = true;
                    while (option) {
                        switch (reader.getIndexArticles()) {
                            case 0:
                                option = false;
                                break;
                            default:
                                boolean siin = true;
                                while (siin) {
                                    switch (reader.getArticleDetail()) {
                                        case 0:
                                            siin = false;
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean tuan = true;
                    while (tuan) {
                        switch (reader.getListCategorys()) {
                            case 0:
                                tuan = false;
                                break;
                            default:
                                boolean ts = true;
                                while (ts) {
                                    switch (reader.getArticlesByCategory()) {
                                        case 0:
                                            ts = false;
                                            break;
                                        default:
                                            boolean siindz = true;
                                            while (siindz) {
                                                switch (reader.getArticleDetail()) {
                                                    case 0:
                                                        siindz = false;
                                                        break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                break;
                        }
                    }
                    break;
                default:
                    System.out.println("Vui lòng chọn một lựa chọn:");
                    break;
            }
            if (text == 3) {
                break;
            }
        }
    }
}
