/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Ngo Van Tuan
 */
public class ControllerEnterprise {
    ModelEnterprise mod = new ModelEnterprise();
    EntityEnterprise ee = new EntityEnterprise();
    public String getMenu() {
        System.out.println("1. Đăng ký doanh nghiệp");
        System.out.println("2. Danh sách các doanh nghiệp đã đăng ký");
        System.out.println("3. Tìm kiếm doanh nghiệp theo mã số thuế");
        System.out.println("4. Đóng chương trình");
        Scanner input = new Scanner(System.in);
        String nx = input.nextLine();
        return nx;
    }

    public EntityEnterprise add() throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Tên doanh nghiệp: ");
        String name = input.nextLine();
        System.out.println("Ngày thành lập (mm/dd/yyyy):");
        String createAt = input.nextLine();
        System.out.println("Mã số thuế:");
        int taxcode = input.nextInt();
        EntityEnterprise enterprise = new EntityEnterprise(name, createAt, taxcode);
        mod.addEnterprise(enterprise);
        return enterprise;
    }

    public String getEnterPrise() {
        System.out.println("1. Đang hoạt động");
        System.out.println("2. Đã dừng hoạt động");
        System.out.println("3. Cancel");
        Scanner input = new Scanner(System.in);
        String nx = input.nextLine();
        return nx;
    }
}
