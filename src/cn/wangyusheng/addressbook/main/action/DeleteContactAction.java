package cn.wangyusheng.addressbook.main.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DeleteContactAction extends ActionSupport {

    private InputStream result;

    public String deleteContact(){

        HttpServletResponse rs = ServletActionContext.getResponse();
        rs.setCharacterEncoding("utf-8");
        String ID = ServletActionContext.getRequest().getParameter("contact_ID");
        try {
            result = new ByteArrayInputStream("{a:1}".getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public InputStream getResult() {
        return result;
    }

    public void setResult(InputStream result) {
        this.result = result;
    }
}
