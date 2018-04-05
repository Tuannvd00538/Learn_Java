/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ngo Van Tuan
 */
public class ModelEnterprise {
    public void addEnterprise(EntityEnterprise enterprise) {
        java.util.Date siinDate = new java.util.Date(enterprise.getCreateAt());
        java.sql.Date sqlDate = new java.sql.Date(siinDate.getTime());
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            String sql = "insert into enterprises (name, createAt, taxcode) values (?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, enterprise.getName());
            ps.setDate(2, sqlDate);
            ps.setInt(3, enterprise.getTaxcode());
            ps.execute();
            if (true) {
                System.out.println("Thêm thành công!");
            } else {
                System.err.println("Oops! Có lỗi xảy ra.");
            }
        } catch (SQLException ex) {
            System.err.println("Oops! Có lỗi xảy ra.");
        }
    }
    
    public void getAction() {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM enterprises WHERE status = '1'");
            while (rs.next()) {
                System.out.println("Tên doanh nghiệp: " + rs.getString("name") + " - Mã số thuế: " + rs.getInt("taxcode") + " - Đang hoạt động");
                System.out.println("------------------------------------");
            }
            if (rs.wasNull()) {
                System.err.println("Không có doanh nghiệp nào đang hoạt động!");
            }
        } catch (SQLException ex) {
            System.err.println("Oops! Có lỗi xảy ra.");
        }
    }

    public void getNonAction() {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM enterprises WHERE status = '2'");
            while (rs.next()) {
                System.err.println("Tên doanh nghiệp: " + rs.getString("name") + " - Mã số thuế: " + rs.getInt("taxcode") + " - Đã dừng hoạt động");
                System.out.println("------------------------------------");
            }
            if (rs.wasNull()) {
                System.err.println("Không có doanh nghiệp nào dừng hoạt động!");
            }
        } catch (SQLException ex) {
            System.err.println("Oops! Có lỗi xảy ra.");
        }
    }

    public String find() {
        System.out.println("Nhập mã số thuế của doanh nghiệp cần tìm:");
        Scanner input = new Scanner(System.in);
        String taxcode = input.nextLine();
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/enterprise?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM enterprises WHERE taxcode = '" + taxcode + "' AND status = '1'");
            while (rs.next()) {
                System.out.println("Tên doanh nghiệp: " + rs.getString("name") + " - Mã số thuế: " + rs.getInt("taxcode"));
                System.out.println("------------------------------------");
            }
            if (rs.wasNull()) {
                System.err.println("Lỗi!\nCó thể bạn nhập sai mã số thuế hoặc doanh nghiệp này đã dừng hoạt động!");
            }
        } catch (SQLException ex) {
            System.err.println("Oops! Có lỗi xảy ra.");
        }
        return taxcode;
    }
}
