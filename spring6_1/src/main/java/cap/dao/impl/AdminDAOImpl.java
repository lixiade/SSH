package cap.dao.impl;

import cap.dao.AdminDAO;

public class AdminDAOImpl implements AdminDAO{
    @Override
    public String sayHi() {
        return "欢迎你学习spring技术";
    }
}
