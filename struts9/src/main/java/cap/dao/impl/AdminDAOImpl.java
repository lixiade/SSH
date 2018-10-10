package cap.dao.impl;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import cap.db.DBCon;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    private DBCon dbCon;
    @Override
    public List<Admin> findAdmin() {
        ArrayList<Admin> adminList=new ArrayList<>();

        try{
           dbCon=new DBCon();
           String sql="select * from Admin";
            ResultSet resultSet =dbCon.doQuery(sql,new Object[]{});
            while (resultSet.next()){
                Admin admins=new Admin();
                admins.setId(resultSet.getInt("id"));
                admins.setUsername(resultSet.getString("username"));
                admins.setPassword(resultSet.getString("password"));
                adminList.add(admins);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbCon.close();
        }
        return adminList;
    }

    @Override
    public Admin findByid(int id) {
        try{
            dbCon=new DBCon();
            String sql="select id from Admin";
            ResultSet resultSet=dbCon.doQuery(sql,new Object[]{id});
            while (resultSet.next()){

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            dbCon.close();
        }
        return null;
    }

    @Override
    public int deleteAdmin(int id) {
        return 0;
    }

    @Override
    public int addAdmin(Admin admin) {
        return 0;
    }

    @Override
    public int updateAdmin(Admin admin) {
        return 0;
    }
}
