package cap.service.impl;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.dao.impl.AdminDAOImpl;
import cap.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO=new AdminDAOImpl();
    @Override
    public List<Admin> findAdmin() {
        return adminDAO.findAdmin();
    }

    @Override
    public Admin findByid(int id) {
        return adminDAO.findByid(id);
    }

    @Override
    public int deleteAdmin(int id) {
        return adminDAO.deleteAdmin(id);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDAO.addAdmin(admin);
    }

    @Override
    public int updateAdmin(Admin admin) {
        return adminDAO.updateAdmin(admin);
    }
}
