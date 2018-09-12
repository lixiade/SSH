package cap.util;

import cap.action.LoginAction;
import cap.bean.Admin;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.util.Map;

public class CheckLoginInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        System.out.print("开始拦截");
        Object o=actionInvocation.getAction();
        if(o instanceof LoginAction){
            System.out.print("登陆action不需要拦截");
            return actionInvocation.invoke();

        }
        Map<String,Object> session=actionInvocation.getInvocationContext().getSession();
        Admin admin=(Admin) session.get("admin");
        if (admin!=null){
            System.out.print("登陆成功。不需要拦截");
            return actionInvocation.invoke();
        }else {
            System.out.print("重新登陆");
            return Action.LOGIN;
        }
    }

}
