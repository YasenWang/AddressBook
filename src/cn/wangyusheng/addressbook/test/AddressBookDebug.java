package cn.wangyusheng.addressbook.test;

import cn.wangyusheng.addressbook.main.dao.MysqlDao;
import cn.wangyusheng.addressbook.main.vo.Contact;

public class AddressBookDebug {

    public static void main(String[] args) {
        MysqlDao mysqlDao = new MysqlDao();
        Contact[] c = mysqlDao.read();
        System.out.println(c[0].getName());
        System.out.println(c[1].getName());
    }
}
