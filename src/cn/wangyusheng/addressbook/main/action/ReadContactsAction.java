package cn.wangyusheng.addressbook.main.action;

import java.io.InputStream;

public class ReadContactsAction {
    private InputStream result;

    public String readContacts() {

        return "success";
    }

    public InputStream getResult() {
        return result;
    }

    public void setResult(InputStream result) {
        this.result = result;
    }
}
