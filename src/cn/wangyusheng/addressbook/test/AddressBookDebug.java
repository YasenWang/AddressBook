package cn.wangyusheng.addressbook.test;

import cn.wangyusheng.addressbook.main.action.ReadContactsAction;
import cn.wangyusheng.addressbook.main.dao.MysqlDao;
import cn.wangyusheng.addressbook.main.vo.Contact;

public class AddressBookDebug {

    public static void main(String[] args) {
        ReadContactsAction readContactsAction = new ReadContactsAction();
        readContactsAction.readContacts();
    }
}
