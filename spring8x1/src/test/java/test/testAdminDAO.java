package test;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class testAdminDAO {
    private ApplicationContext context;

    @Before
    public void init() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void testfindAdmins() {
        AdminDAO adminDAO = (AdminDAO) context.getBean("AdminDAO");
        List<Admin> findAdmins = adminDAO.findAdmins();
        for (Admin admin : findAdmins) {
            System.out.println(admin.getId() + ":" + admin.getUsername() + ":" + admin.getPassword());
        }
    }

    @Test
    public void testfindById() {
        AdminDAO adminDAO = (AdminDAO) context.getBean("AdminDAO");
        Admin admin = adminDAO.findById(3);
        System.out.println(admin.getId() + ":" + admin.getUsername() + ":" + admin.getPassword());
    }

    @Test
    public void testaddAdmins() {
        AdminDAO adminDAO = (AdminDAO) context.getBean("AdminDAO");
        Admin admin = new Admin("嗨", "嗨");
        int res = adminDAO.addAdmins(admin);
        assert res == 1;
    }

    @Test
    public void testupdateAdmins() {
        AdminDAO adminDAO = (AdminDAO) context.getBean("AdminDAO");
        Admin admin = new Admin(1, "cap", "cap");
        int res = adminDAO.updateAdmins(admin);
        assert res == 1;
    }

    @Test
    public void testdeleteAdmins() {
        AdminDAO adminDAO = (AdminDAO) context.getBean("AdminDAO");
        int res = adminDAO.deleteAdmins(11);
       // assert res == 1;
         if(res>0){
            System.out.println("成功！");
         }else{
           System.out.println("失败！");
         }


    }

}
