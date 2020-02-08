package cn.wangyusheng.addressbook.main.action;

import cn.wangyusheng.addressbook.main.dao.MysqlDao;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;


public class DeleteContactAction implements ServletRequestAware {

    private HttpServletRequest request;

    public String deleteContact(){
        String delete_ID = request.getParameter("delete_ID");
        boolean result = new MysqlDao().delete(delete_ID);
        if (result){
            return "success";
        } else {
            return "error";
        }
    }

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request = httpServletRequest;
    }
}
