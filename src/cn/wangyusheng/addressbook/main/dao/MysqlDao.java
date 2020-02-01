package cn.wangyusheng.addressbook.main.dao;

import cn.wangyusheng.addressbook.main.vo.Contact;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class MysqlDao {
    private Connection connection;
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
    private void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Contact[] read(){
        ArrayList<Contact> contacts = new ArrayList<>();

        Contact[] contacts_list = new Contact[contacts.size()];
        return contacts.toArray(contacts_list);
    }

    public Contact[] fuzzyRead(String argv[]){
        ArrayList<Contact> contacts = new ArrayList<>();

        Contact[] contacts_list = new Contact[contacts.size()];
        return contacts.toArray(contacts_list);
    }

    public boolean add(Contact contact){

        return false;
    }


}
