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
    class OrderDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        static SqlConnection conn = new SqlConnection(strConn);
        public static void addOrder(int staffId, DateTime date)
        {
            string sql = "INSERT INTO [Order] ([StaffId],[Date]) VALUES (@staffId, @date)";
            conn.Open();
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.Parameters.AddWithValue("@staffId", staffId);
            cmd.Parameters.AddWithValue("@date", date);
            cmd.ExecuteNonQuery();
            conn.Close();
        }

        public static int getMaxOrderId()
        {
            int maxId = 0;
            string sql = "select MAX(id) as maxId from [Order]";
            DataTable dt = DAO.GetDataTable(sql);
            maxId = int.Parse(dt.Rows[0]["maxId"].ToString());
            return maxId;
        }
    }
}
