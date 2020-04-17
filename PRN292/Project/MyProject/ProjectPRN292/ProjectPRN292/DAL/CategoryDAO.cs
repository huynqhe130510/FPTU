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
    class CategoryDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["ProjectPRN292ConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        public static DataTable getAllCategories()
        {
            string sql = "SELECT * FROM Category";
            return DAO.GetDataTable(sql);
        }

        public static int getCategoryIdByName(string name)
        {
            string sql = "select id from Category where Name = '" + name + "'";
            DataTable dt = DAO.GetDataTable(sql);

            return int.Parse(dt.Rows[0]["id"].ToString());
        }

        public static int getCategoryNameById(int id)
        {
            string sql = "select name from Category where Id = '" + id + "'";
            DataTable dt = DAO.GetDataTable(sql);

            return int.Parse(dt.Rows[0]["name"].ToString());
        }

        public static DataTable getAllCateGory()
        {
            string sql = "SELECT * From Category";
            return DAO.GetDataTable(sql);
        }

        public static List<string> listCategory()
        {
            List<string> listName = new List<string>();
            listName.Add("All Category");
            DataTable dbt = getAllCateGory();
            foreach (DataRow dr in dbt.Rows)
            {
                string name = dr["Name"].ToString();
                listName.Add(name);
            }
            return listName;
        }

        public static List<string> getAllCateGoryName()
        {
            List<string> listName = listCategory();
            return listName;
        }
    }
}
