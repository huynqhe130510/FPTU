using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ProjectPRN292.DAL
{
    class OrderDetailDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        static SqlConnection conn = new SqlConnection(strConn);

        public static void addOrderDetail(int orderId, int productId, int quantity)
        {
            string sql = "INSERT INTO [OrderDetail] ([OrderId], [ProductId], [Quantity]) " +
                         "VALUES (@orderId, @productId, @quantity)";
            conn.Open();
            SqlCommand cmd = new SqlCommand(sql, conn);
            cmd.Parameters.AddWithValue("@orderId", orderId);
            cmd.Parameters.AddWithValue("@productId", productId);
            cmd.Parameters.AddWithValue("@quantity", quantity);
            cmd.ExecuteNonQuery();
            conn.Close();
        }
    }
}
