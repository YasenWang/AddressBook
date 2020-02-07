package cn.wangyusheng.addressbook.main.action;

import java.io.InputStream;

public class findContactsAction {
    private InputStream result;

    public String findContacts(){

        return "success";
    }

    public InputStream getResult() {
        return result;
    }

    public void setResult(InputStream result) {
        this.result = result;
    }
}
