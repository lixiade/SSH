package cap.test;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AdminDAOTest {
    private ApplicationContext applicationContext=null;
    @Before
    public void init(){
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testFindAdmins(){
        AdminDAO adminDAO = (AdminDAO) applicationContext.getBean("AdminDAO");
        List<Admin> adminList = adminDAO.findAdmins();
        for(Admin admin : adminList){
            System.out.println(admin.getId()+":"+admin.getUsername());

        }
    }
}
