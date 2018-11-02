package cap.dao.impl;

import cap.bean.Admin;
import cap.dao.AdminDAO;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository(value = "AdminDAO")

//@Transactional
//使用@Transactional 注解必须启用applicationContext.xml中的<tx:annotation-driven/>标签
public class AdminDAOImpl implements AdminDAO {


    private class MyRowMapper implements RowMapper<Admin> {
        @Override
        public Admin mapRow(ResultSet resultSet, int i) throws SQLException {
            Admin admin = new Admin();
            admin.setId(resultSet.getInt("id"));
            admin.setUsername(resultSet.getString("username"));
            admin.setPassword(resultSet.getString("password"));
            return admin;
        }
    }

    @Resource
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Admin> findAdmins() {
        String sql = "select * from admin";
        return namedParameterJdbcTemplate.query(sql, new MyRowMapper());
    }

    @Override
    public Admin findById(int id) {
        String sql = "select * from admin where id=:i";
        Map<String, Object> params = new HashMap<>();
        params.put("i", id);
        return namedParameterJdbcTemplate.queryForObject(sql, params, new MyRowMapper());
    }

    @Override
    public int updateAdmins(Admin admin) {
        String sql = "update admin set username=:u,password=:p where id=:id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", admin.getId());
        params.put("u", admin.getUsername());
        params.put("p", admin.getPassword());
        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public int deleteAdmins(int id) {
        String sql = "delete from admin where id=:i";
        Map<String, Object> params = new HashMap<>();
        params.put("i", id);
        return namedParameterJdbcTemplate.update(sql, params);
    }

    @Override
    public int addAdmins(Admin admin) {
      /*  String sql="insert into admin(username,password) values(:u,:p)";
        Map<String,Object>params=new HashMap<>();
        params.put("u",admin.getUsername());
        params.put("p",admin.getPassword());
        return namedParameterJdbcTemplate.update(sql,params);
*/
        String sql = "insert into admin(username,password) values(:username,:password)";
        SqlParameterSource sqlParameterSource = new BeanPropertySqlParameterSource(admin);
        int res = namedParameterJdbcTemplate.update(sql, sqlParameterSource);
        int result = 10 / 0;
        return res;

    }


}
