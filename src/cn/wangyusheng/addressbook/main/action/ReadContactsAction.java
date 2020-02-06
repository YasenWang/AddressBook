package cn.wangyusheng.addressbook.main.action;

import cn.wangyusheng.addressbook.main.dao.MysqlDao;
import cn.wangyusheng.addressbook.main.vo.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

public class ReadContactsAction {
    private InputStream result;

    public String readContacts() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Contact[] contacts = new MysqlDao().read();
        String buf = gson.toJson(contacts,Contact[].class);
        System.out.println(buf);
        result = new ByteArrayInputStream(buf.getBytes(StandardCharsets.UTF_8));
        return "success";
    }

    public InputStream getResult() {
        return result;
    }

    public void setResult(InputStream result) {
        this.result = result;
    }
}
