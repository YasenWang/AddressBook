package cn.wangyusheng.addressbook.test;

import cn.wangyusheng.addressbook.main.dao.MysqlDao;
import cn.wangyusheng.addressbook.main.vo.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class AddressBookDebug {

    public static void main(String[] args) {

        String[] fuzzy_argv = {
                "0",
                "%王%"
        };
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Contact[] contacts = new MysqlDao().fuzzyRead(fuzzy_argv);
        String buf = gson.toJson(contacts);
        System.out.println(buf);
    }
}
