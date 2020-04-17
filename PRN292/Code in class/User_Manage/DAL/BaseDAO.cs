using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace DAL
{
    public abstract class BaseDAO<T>
    {
        internal SqlConnection connection;
        public BaseDAO()
        {
            string connectionString = ConfigurationManager.ConnectionStrings["strConnection"].ToString();
            connection = new SqlConnection(connectionString);
        }

        public abstract List<T> GetAll();
        public abstract void Delete(int id);
    }
}
