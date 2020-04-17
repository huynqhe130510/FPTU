using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Q3.DAL
{
    public class ProjectDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["EmployeeDBConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        public static DataTable getProjects()
        {
            string cmd = "select * from project";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable getIdByName(string name)
        {
            string cmd = "select id from Project where name = '" + name + "'";
            return DAO.GetDataTable(cmd);
        }
    }
}