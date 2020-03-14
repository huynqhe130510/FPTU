package Q3;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class UserDAO {
    
    public User getUserByUserName(String uname) {
        User u = null;
        try {
            Connection conn = new DBContext().getConnection();
            String query = "select * from Users where UserName = ?";
            PreparedStatement ps= conn.prepareStatement(query);
            ps.setString(1, uname);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String userName = rs.getString("UserName");
                String disp = rs.getString("DisplayName");
                String pas = rs.getString("password");
                String des = rs.getString("Description");
                u = new User(userName, disp, pas, des);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return u;
    }
    
    public void updateUser(String userName, String dis, String pas, String des) {
        try {
            Connection conn = new DBContext().getConnection();
            String query = "Update Users SET Displayname = ? , Password = ? , Description = ? WHERE UserName = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, dis);
            ps.setString(2, pas);
            ps.setString(3, des);
            ps.setString(4, userName);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
