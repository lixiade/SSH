package cap.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;
@Aspect
public class AdminAspectjLogger {

    public static final String AAP = "execution(* cap.dao.impl.*.*(..))";

    @Before(AAP)
    public void logBefore() {
        System.out.println("记录前:现在时间是:" + new Date().toString());
    }

    @Before(AAP)
    public void logAfter() {
        System.out.println("记录后:现在时间是:" + new Date().toString());
    }

    // spring中Around通知
    @Before(AAP)
    public Object logAround(ProceedingJoinPoint joinPoint) {
        // 方法执行前的代理处理
        System.out.println("记录开始:现在时间是:" + new Date().toString());
        Object[] args = joinPoint.getArgs();
        Object obj = null;
        try {
            obj = joinPoint.proceed(args);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        // 方法执行后的代理处理
        System.out.println("记录结束结束:现在时间是:" + new Date().toString());
        return obj;
    }
}
