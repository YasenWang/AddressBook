package cn.wangyusheng.addressbook.main.action;

import cn.wangyusheng.addressbook.main.dao.MysqlDao;
import cn.wangyusheng.addressbook.main.vo.Contact;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class findContactsAction implements ServletRequestAware {
    private InputStream result;
    private HttpServletRequest request;

    public String findContacts(){
        String[] fuzzy_argv = {
                request.getParameter("col"),
                request.getParameter("keyword")
        };
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .create();
        Contact[] contacts = new MysqlDao().fuzzyRead(fuzzy_argv);
        String buf = gson.toJson(contacts);
        result = new ByteArrayInputStream(buf.getBytes(StandardCharsets.UTF_8));
        return "success";
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }

    public InputStream getResult() {
        return result;
    }

    public void setResult(InputStream result) {
        this.result = result;
    }
}
