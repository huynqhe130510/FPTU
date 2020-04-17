using ProjectPRN292.DTL;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DAL
{
    class StaffDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        static SqlConnection conn = new SqlConnection(strConn);
        public static Staff getStaffById(int staffId)
        {
            Staff s = new Staff();
            string sql = "Select * from [Staff] where id = @id";
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.Parameters.AddWithValue("@id", staffId);
            conn.Open();
            SqlDataReader sdr = cmd.ExecuteReader();
            while (sdr.Read())
            {
                s.Id = int.Parse(sdr["Id"].ToString());
                s.Name = sdr["Name"].ToString();
            }
            conn.Close();
            return s;
        }

        public static DataTable GetDataTable()
        {
            string cmd = "select s.Id, s.Name, s.Gender, s.DoB, s.Address, s.PhoneNumber, s.Date_of_join, s.Salary, s.Image, u.Username, u.Password, u.RoleId, u.StaffId from [User] u, Staff s where u.StaffId = s.Id";
            return DAO.GetDataTable(cmd);
        }

        public static int getIdMax()
        {
            string sql = "select MAX(id) as maxId from Staff";
            DataTable dt = DAO.GetDataTable(sql);

            return int.Parse(dt.Rows[0]["maxId"].ToString());
        }

        public static bool Insert(Staff s)
        {
            SqlCommand cmd = new SqlCommand("Insert into Staff(Id, Name, Gender, DoB, Address, PhoneNumber, Date_of_join, Salary, Image)values (@Id, @Name, @Gender, @DoB, @Address, @Phonenumber, @Date_of_join, @Salary, @Image)");

            cmd.Parameters.AddWithValue("@Id", s.Id);
            cmd.Parameters.AddWithValue("@Name", s.Name);
            cmd.Parameters.AddWithValue("@Gender", s.Gender);
            cmd.Parameters.AddWithValue("@Dob", s.Dob);
            cmd.Parameters.AddWithValue("@Address", s.Address);
            cmd.Parameters.AddWithValue("@Phonenumber", s.PhoneNumber);
            cmd.Parameters.AddWithValue("@Date_of_join", s.DateOJoin);
            cmd.Parameters.AddWithValue("@Salary", s.Salary);
            cmd.Parameters.AddWithValue("@Image", s.Image);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(Staff s)
        {
            SqlCommand cmd = new SqlCommand("Update Staff set Name = @Name, Gender = @Gender ,DoB = @Dob ,Address = @Address ,Phonenumber = @Phonenumber ,Date_of_join = @Date_of_join ,Salary = @Salary ,Image = @Image where Id = @Id");


            cmd.Parameters.AddWithValue("@Name", s.Name);
            cmd.Parameters.AddWithValue("@Gender", s.Gender);
            cmd.Parameters.AddWithValue("@Dob", s.Dob);
            cmd.Parameters.AddWithValue("@Address", s.Address);
            cmd.Parameters.AddWithValue("@Phonenumber", s.PhoneNumber);
            cmd.Parameters.AddWithValue("@Date_of_join", s.DateOJoin);
            cmd.Parameters.AddWithValue("@Salary", s.Salary);
            cmd.Parameters.AddWithValue("@Image", s.Image);
            cmd.Parameters.AddWithValue("@Id", s.Id);

            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(int id)
        {
            SqlCommand cmd = new SqlCommand(" delete Staff where id = @id");
            cmd.Parameters.AddWithValue("@id", id);
            return DAO.UpdateTable(cmd);
        }

        public static DataTable getRole()
        {
            return DAO.GetDataTable("select * from role");
        }

    }
}
