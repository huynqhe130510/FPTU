using ProjectPRN292.DTL;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DAL
{

    class UserDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        public User getUser(string username, string password)
        {
            User user = new User();
            string sql = "Select * from [user] where username = @username and password = @password";
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.Parameters.AddWithValue("@username", username);
            cmd.Parameters.AddWithValue("@password", password);
            conn.Open();
            SqlDataReader sdr = cmd.ExecuteReader();
            while (sdr.Read())
            {
                user.Id = int.Parse(sdr["Id"].ToString());
                user.Username = sdr["Username"].ToString();
                user.Password = sdr["Password"].ToString();
                user.StaffId = int.Parse(sdr["StaffId"].ToString());
                user.RoleId = int.Parse(sdr["RoleId"].ToString());
            }
            conn.Close();

            return user;
        }

        public static bool Insert(User u)
        {
            SqlCommand cmd = new SqlCommand("insert into [User](Username, Password, RoleId, StaffId)" +
                "values (@Username, @Password, @RoleId, @StaffId)");
            cmd.Parameters.AddWithValue("@UserName", u.Username);
            cmd.Parameters.AddWithValue("@Password", u.Password);
            cmd.Parameters.AddWithValue("@RoleId", u.RoleId);
            cmd.Parameters.AddWithValue("@StaffId", u.StaffId);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(User u)
        {
            SqlCommand cmd = new SqlCommand("Update [User] set username = @Username, password = @Password, RoleId = @RoleId where staffId = @Id");
            cmd.Parameters.AddWithValue("@Username", u.Username);
            cmd.Parameters.AddWithValue("@Password", u.Password);
            cmd.Parameters.AddWithValue("@RoleId", u.RoleId);
            cmd.Parameters.AddWithValue("@Id", u.StaffId);
            return DAO.UpdateTable(cmd);
        }

        public static bool Delete(int id)
        {
            SqlCommand cmd = new SqlCommand("delete [User] where StaffId = @id");
            cmd.Parameters.AddWithValue("@id", id);
            return DAO.UpdateTable(cmd);
        }
    }
}
