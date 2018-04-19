/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package again.reflection;

import java.lang.reflect.Field;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import myannotation.AutoGenerate;
import myannotation.Entity;
import myannotation.MyId;

/**
 *
 * @author Ngo Van Tuan
 */
public class Model<T> {
    public static void main(String[] args) throws SQLException {
        Model model = new Model();
        Customer customer = new Customer("Siin");
        Student student = new Student("Ngo Van Tuan", "D00538");
        
        model.save(student);
    }
    
    public String fieldsValueBuilder(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder fieldsValueBuilder = new StringBuilder();
        fieldsValueBuilder.append("(");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);

                System.out.println(f.getName() + " - " + f.getType().getSimpleName());
                System.out.println(f.isAnnotationPresent(MyId.class));
                if (f.isAnnotationPresent(MyId.class) && f.isAnnotationPresent(AutoGenerate.class)) {
                    continue;
                }
                if (f.getType().getSimpleName().equals("String")) {
                    fieldsValueBuilder.append("'").append(f.get(obj)).append("'").append(",");
                } else if (f.getType().getSimpleName().equals("int")) {
                    fieldsValueBuilder.append(f.get(obj)).append(",");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        fieldsValueBuilder.deleteCharAt(fieldsValueBuilder.length() - 1);
        fieldsValueBuilder.append(")");
        return fieldsValueBuilder.toString();
    }
    
    public String fieldsNameBuilder(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        StringBuilder fieldsNameBuilder = new StringBuilder();
        fieldsNameBuilder.append("(");
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            if (f.isAnnotationPresent(MyId.class) && f.isAnnotationPresent(AutoGenerate.class)) {
                continue;
            }
            fieldsNameBuilder.append(f.getName()).append(",");
        }
        fieldsNameBuilder.deleteCharAt(fieldsNameBuilder.length() - 1);
        fieldsNameBuilder.append(")");
        return fieldsNameBuilder.toString();
    }
    
    public String tableName(Object obj) {
        Class clazz = obj.getClass();
        if (clazz.isAnnotationPresent(Entity.class)) {
            Entity entity = (Entity) clazz.getAnnotation(Entity.class);
            return entity.tableName();
        }
        return obj.getClass().getSimpleName().toLowerCase();
    }
    
    public ArrayList<T> getList() {
        return new ArrayList<>();
    }
    
    public void save(T obj) throws SQLException {
        Field[] fields = obj.getClass().getDeclaredFields();

        String tableName = tableName(obj);
        String fieldsName = fieldsNameBuilder(obj);
        String fieldsValue = fieldsValueBuilder(obj);
        
        Statement stt = DriverManager.getConnection("jdbc:mysql://localhost:3306/reflection", "root", "").createStatement();
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into ").append(tableName).append(" ").append(fieldsName).append(" values ").append(fieldsValue);
        System.out.println(sqlBuilder.toString());
        stt.execute(sqlBuilder.toString());
    }
}
