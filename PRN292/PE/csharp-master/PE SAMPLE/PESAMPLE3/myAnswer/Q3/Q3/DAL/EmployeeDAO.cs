using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;

namespace Q3.DAL
{
    public class EmployeeDAO
    {
        public static DataTable getAllEmployee()
        {
            string cmd = "select * from employee";
            return DAO.GetDataTable(cmd);
        }
    }
}