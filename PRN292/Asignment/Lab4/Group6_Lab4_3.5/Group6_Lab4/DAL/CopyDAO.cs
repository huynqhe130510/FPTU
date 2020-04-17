using Group6_Lab4.DTL;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Group6_Lab4.DAL
{
    public class CopyDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Copy";
            return DAO.GetDataTable(cmd);
        }

        public static int GetCopyNumberMax()
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(copyNumber)", ""));
        }

        public static int GetSequenceNumberMax(int v)
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(sequenceNumber)", ""));
        }

        public static bool Insert(Copy c)
        {
            SqlCommand cmd = new SqlCommand("insert into copy(copyNumber, bookNumber, sequenceNumber, type, price)" +
                    "values (@copyNumber,@bookNumber, @sequenceNumber, @type, @price)");
            cmd.Parameters.AddWithValue("@copyNumber", c.CopyNumber);
            cmd.Parameters.AddWithValue("@type", c.Type);
            cmd.Parameters.AddWithValue("@bookNumber", c.BookNumber);
            cmd.Parameters.AddWithValue("@sequenceNumber", c.SequenceNumber);
            cmd.Parameters.AddWithValue("@price", c.Price);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(Copy c)
        {
            SqlCommand cmd = new SqlCommand("update Copy set bookNumber = @bookNumber, sequenceNumber = @sequenceNumber, type = @type, price = @price  where copyNumber=@copyNumber");
            cmd.Parameters.AddWithValue("@copyNumber", c.CopyNumber);
            cmd.Parameters.AddWithValue("@type", c.Type);
            cmd.Parameters.AddWithValue("@bookNumber", c.BookNumber);
            cmd.Parameters.AddWithValue("@sequenceNumber", c.SequenceNumber);
            cmd.Parameters.AddWithValue("@price", c.Price);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(int copyNumber)
        {
            SqlCommand cmd = new SqlCommand("delete Copy where copyNumber=@copyNumber");
            cmd.Parameters.AddWithValue("@copyNumber", copyNumber);
            return DAO.UpdateTable(cmd);
        }

        public static Copy GetCopy(int copyNumber)
        {
            Copy copy = new Copy();
            using (SqlConnection myConnection = new SqlConnection(strConn))
            {
                string cmd = "select * from Copy where copyNumber = @copyNumber";
                SqlCommand oCmd = new SqlCommand(cmd, myConnection);
                oCmd.Parameters.AddWithValue("@copyNumber", copyNumber);
                myConnection.Open();
                using (SqlDataReader oReader = oCmd.ExecuteReader())
                {
                    while (oReader.Read())
                    {
                        copy.CopyNumber = (int)oReader["copyNumber"];
                        copy.BookNumber = (int)oReader["bookNumber"];
                        copy.SequenceNumber = (int)oReader["sequenceNumber"];
                        copy.Type = oReader["type"].ToString();
                        copy.Price = (double)oReader["price"];
                    }

                    myConnection.Close();
                }
            }
            return copy;
        }

        public static DataTable getCopiesByBookNumber(int bookNumber)
        {
            String cmd = "select * from Copy where bookNumber = " + bookNumber;
            return DAO.GetDataTable(cmd);
        }

        public static List<Copy> GetCopyByBookNumber(int bookNumber)
        {
            List<Copy> list = new List<Copy>();

            using (SqlConnection myConnection = new SqlConnection(strConn))
            {
                string cmd = "select * from Copy where bookNumber = @bookNumber";
                SqlCommand oCmd = new SqlCommand(cmd, myConnection);
                oCmd.Parameters.AddWithValue("@bookNumber", bookNumber);
                myConnection.Open();
                using (SqlDataReader oReader = oCmd.ExecuteReader())
                {
                    while (oReader.Read())
                    {
                        Copy copy = new Copy();
                        copy.CopyNumber = (int)oReader["copyNumber"];
                        copy.BookNumber = (int)oReader["bookNumber"];
                        copy.SequenceNumber = (int)oReader["sequenceNumber"];
                        copy.Type = oReader["type"].ToString();
                        copy.Price = (double)oReader["price"];

                        list.Add(copy);
                    }

                    myConnection.Close();
                }
            }
            return list;
        }

    }
}