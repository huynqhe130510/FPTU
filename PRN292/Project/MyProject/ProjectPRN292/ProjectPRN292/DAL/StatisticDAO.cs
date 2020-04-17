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
    class StatisticDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        static SqlConnection conn = new SqlConnection(strConn);
        public static DataTable statistic(string from, string to)
        {
            string sql = "select p.Id as ProductId, p.Name as ProductName, p.Size, p.Price, o.Date, od.Quantity,s.Name as StaffName\n" +
                         "from OrderDetail od, Product p, [order] o, Staff s\n" +
                         "where od.ProductId = p.Id and o.Id = od.OrderId and s.Id = o.StaffId\n" +
                         "and o.Date >= '" + from + "' and o.Date <= '" + to + "'";
            return DAO.GetDataTable(sql);
        }
    }
}
