package cn.wangyusheng.addressbook.main.dao;

import cn.wangyusheng.addressbook.main.vo.Contact;

import java.sql.*;
import java.util.ArrayList;

public class MysqlDao {
    private Connection connection;
    private String user_name = "admin";
    public MysqlDao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
              "jdbc:mysql://127.0.0.1:3306/address_book?characterEncoding=UTF-8&serverTimezone=GMT%2B8",
                    "root","wys19980107"
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //获取数据信息之后，调用close方法，解除端口占用
    private void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact[] read(){
        ArrayList<Contact> contacts = new ArrayList<>();
        try {
                PreparedStatement ps = connection.prepareStatement(
                    "SELECT * from address_book."+user_name);
                ResultSet rs = ps.executeQuery();
                while (rs.next())
                {
                    Contact c_iterator = new Contact();

                    c_iterator.setID(rs.getInt(1));
                    c_iterator.setName(rs.getString(2));
                    c_iterator.setSex(rs.getString(3));
                    c_iterator.setPhone_number(rs.getString(4));
                    c_iterator.setAddress(rs.getString(5));
                    c_iterator.setBirthday(rs.getDate(6));

                    contacts.add(c_iterator);
                }
            Contact[] contacts_list = new Contact[contacts.size()];
            contacts.toArray(contacts_list);
            return contacts_list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Contact[] fuzzyRead(String argv[]){
        ArrayList<Contact> contacts = new ArrayList<>();
        String mysql_column;
        switch (argv[0]){
            case "0":mysql_column = "NAME_CHR";break;
            case "1":mysql_column = "ADDRESS_CHR";break;
            default:
                throw new IllegalStateException("Unexpected value: " + argv[1]);
        }
        argv[1] = "%"+argv[1]+"%";
        try {
            PreparedStatement ps = connection.prepareStatement(
              "SELECT * from address_book."+user_name
              + " WHERE " + mysql_column+ " like ?;");
            ps.setString(1,argv[1]);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Contact c_iterator = new Contact();

                c_iterator.setID(rs.getInt(1));
                c_iterator.setName(rs.getString(2));
                c_iterator.setSex(rs.getString(3));
                c_iterator.setPhone_number(rs.getString(4));
                c_iterator.setAddress(rs.getString(5));
                c_iterator.setBirthday(rs.getDate(6));

                contacts.add(c_iterator);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        Contact[] contacts_list = new Contact[contacts.size()];
        return contacts.toArray(contacts_list);
    }

    public boolean add(Contact contact){

        return false;
    }

    public boolean delete(String ID){
        int result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "delete from  address_book."+user_name
            +" where ID = ?");
            ps.setString(1,ID);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result>0;
    }


}
