using Group6_Lab4.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace Group6_Lab4.DAL
{
    public class BookDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Book";
            return DAO.GetDataTable(cmd);
        }

        public static DataTable GetBookByTitle(string title)
        {
            String cmd = "";
            if (title == "")
            {
                cmd = "Select * from Book";
            }
            else
                cmd = "Select * from Book where title like '%" + title + "%'";
            return DAO.GetDataTable(cmd);
        }

        public static string getBookTitlebyId(int bookNumber)
        {
            string sql = "select title from Book where bookNumber = " + bookNumber;
            DataTable dt = DAO.GetDataTable(sql);

            return dt.Rows[0].Field<string>("title");
        }

        public static int GetBookNumberMax()
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(bookNumber)", ""));
        }


        public static bool Insert(string title, string authors, string publisher)
        {
            SqlCommand cmd = new SqlCommand("insert into book(title, authors, publisher)" +
                    "values (@title, @authors, @publisher)");
            cmd.Parameters.AddWithValue("@title", title);
            cmd.Parameters.AddWithValue("@authors", authors);
            cmd.Parameters.AddWithValue("@publisher", publisher);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(string title, string authors, string publisher, int bookNumber)
        {
            SqlCommand cmd = new SqlCommand("update Book set title=@title, authors = @authors, publisher = @publisher where bookNumber=@bookNumber");
            cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
            cmd.Parameters.AddWithValue("@title", title);
            cmd.Parameters.AddWithValue("@authors", authors);
            cmd.Parameters.AddWithValue("@publisher", publisher);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(int bookNumber)
        {
            SqlCommand cmd = new SqlCommand("delete Book where bookNumber=@bookNumber");
            cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
            return DAO.UpdateTable(cmd);
        }
    }
}