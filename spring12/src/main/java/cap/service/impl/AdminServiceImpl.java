package cap.service.impl;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.service.AdminService;

import java.util.List;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO;

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }

    @Override
    public List<Admin> findAdmins() {
        return adminDAO.findAdmins();
    }

    @Override
    public Admin findByid(int id) {
        return adminDAO.findByid(id);
    }

    @Override
    public int deleteAdmins(int id) {
        return adminDAO.deleteAdmins(id);
    }

    @Override
    public int updateAdmins(Admin admin) {
        return adminDAO.updateAdmins(admin);
    }

    @Override
    public int addAdmins(Admin admin) {
        return adminDAO.addAdmins(admin);
    }
}
