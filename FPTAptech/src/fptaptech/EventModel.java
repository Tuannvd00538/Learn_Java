/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fptaptech;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ngo Van Tuan
 */
public class EventModel {
    Event event = new Event();
    public void addEvent(Event event) {
        java.util.Date siinCreate = new java.util.Date(event.getCreateAt());
        java.util.Date siinEnd = new java.util.Date(event.getEndAt());
        java.sql.Date Create = new java.sql.Date(siinCreate.getTime());
        java.sql.Date End = new java.sql.Date(siinEnd.getTime());
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            String sql = "insert into events (name, createAt, endAt, category) values (?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, event.getName());
            ps.setDate(2, Create);
            ps.setDate(3, End);
            ps.setInt(4, event.getCategory());
            ps.execute();
            if (true) {
                System.out.println("Thêm thành công!");
            } else {
                System.err.println("Oops! Có lỗi xảy ra.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getList() {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM events WHERE status = '1'");
            while (rs.next()) {
                System.out.println("Mã sự kiện: " + rs.getInt("id") + " - Tên sự kiện: " + rs.getString("name") + 
                        " - Ngày bắt đầu: " + rs.getDate("createAt") + " - Ngày kết thúc: " + rs.getDate("endAt") + 
                        " - Loại sự kiện: " + event.getCategoryName(rs.getInt("category")));
                System.out.println("------------------------------------");
            }
            if (rs.wasNull()) {
                System.err.println("Không có sự kiện nào!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void findEvent(String code) {
        try {
            Connection cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/event?useUnicode=true"
                    + "&characterEncoding=UTF-8","root","");
            Statement stt = cnn.createStatement();
            ResultSet rs = stt.executeQuery("SELECT * FROM events WHERE id = '" + code + "' AND status = '1'");
            while (rs.next()) {
                System.out.println("Mã sự kiện: " + rs.getInt("id") + " - Tên sự kiện: " + rs.getString("name") + 
                        " - Ngày bắt đầu: " + rs.getDate("createAt") + " - Ngày kết thúc: " + rs.getDate("endAt") + 
                        " - Loại sự kiện: " + event.getCategoryName(rs.getInt("category")));
                System.out.println("------------------------------------");
            }
            if (rs.wasNull()) {
                System.err.println("Sự kiện không tồn tại hoặc đã bị xóa!");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
