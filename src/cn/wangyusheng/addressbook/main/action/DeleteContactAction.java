package cn.wangyusheng.addressbook.main.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import java.io.IOException;

public class DeleteContactAction extends ActionSupport {

    public String deleteContact(){
        ServletActionContext.getResponse().setCharacterEncoding("utf-8");
        String ID = ServletActionContext.getRequest().getParameter("contact_ID");

        try {
            ServletActionContext.getResponse().getWriter().write("{a:1}");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }


}
