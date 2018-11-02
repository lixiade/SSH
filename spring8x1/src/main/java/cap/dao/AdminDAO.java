package cap.dao;

import cap.bean.Admin;

import java.util.List;

public interface AdminDAO {
    List<Admin> findAdmins();

    Admin findById(int id);

    int updateAdmins(Admin admin);

    int deleteAdmins(int id);

    int addAdmins(Admin admin);
}
