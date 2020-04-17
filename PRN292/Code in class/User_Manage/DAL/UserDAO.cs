using Entity;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace DAL
{
    public class UserDAO : BaseDAO<User>
    {
        public override void Delete(int id)
        {
            string sql = "DELETE FROM [Users] WHERE id = @id";
            try
            {
                SqlCommand command = new SqlCommand(sql, connection);
                command.Parameters.Add(new SqlParameter("@id", id));
                connection.Open();
                command.ExecuteNonQuery();
                connection.Close();
            }
            catch (SqlException ex)
            {
                throw ex;
            }
            finally
            {
                if (connection.State != ConnectionState.Closed)
                    connection.Close();
            }
        }

        public override List<User> GetAll()
        {
            List<User> userList = new List<User>();
            try
            {
                string sql = "SELECT id, name, avatar, gender, dob FROM Users ";
                SqlCommand command = new SqlCommand(sql, connection);
                connection.Open();
                SqlDataReader reader = command.ExecuteReader();
                while (reader.Read())
                {
                    User u = new User();
                    u.id = Convert.ToInt32(reader["id"]);
                    u.name = reader["name"].ToString();
                    u.avatar = reader["avatar"].ToString();
                    u.gender = Convert.ToBoolean(reader["gender"]);
                    u.dob = Convert.ToDateTime(reader["dob"]);

                    userList.Add(u);
                }
            }
            catch (SqlException ex)
            {
                throw ex;
            }
            finally
            {
                if (connection.State != ConnectionState.Closed)
                    connection.Close();
            }
            return userList;
        }
    }
}
