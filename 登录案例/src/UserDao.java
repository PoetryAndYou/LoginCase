import org.junit.Before;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author rui
 * @create 2019-08-05 22:34
 */
public class UserDao {
    private JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());


    public User login(User user) {


        try {
            String sql = "select * from user  where username =? and password=?";
            User aLong = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),user.getUsername(),user.getPassword());
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();//记录日志
            return null;
        }

    }
}
