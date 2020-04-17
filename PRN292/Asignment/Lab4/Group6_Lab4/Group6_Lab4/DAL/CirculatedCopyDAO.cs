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
    public class CirculatedCopyDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
        public static bool Insert(CirculatedCopy cc)
        {
            SqlCommand cmd = new SqlCommand("insert into CirculatedCopy(copyNumber, borrowerNumber, borrowedDate, dueDate)" +
                    "values (@copyNumber, @borrowerNumber, @borrowedDate, @dueDate)");
            cmd.Parameters.AddWithValue("@copyNumber", cc.CopyNumber);
            cmd.Parameters.AddWithValue("@borrowerNumber", cc.BorrowerNumber);
            cmd.Parameters.AddWithValue("@borrowedDate", DateTime.ParseExact(cc.BorrowedDate, "dd/MM/yyyy", null));
            cmd.Parameters.AddWithValue("@dueDate", DateTime.ParseExact(cc.DueDate, "dd/MM/yyyy", null));
            cmd.Parameters.AddWithValue("@fineAmount", cc.FineAmount);
            return DAO.UpdateTable(cmd);
        }

        public static DataTable GetBorrowedCopies(int v)
        {
            string cmd = "select * from circulatedCopy where borrowerNumber = " + v;
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetBorrowedCopy(int v)
        {
            string cmd = "select * from circulatedCopy where returnedDate is null and borrowerNumber = " + v;
            return DAO.GetDataTable(cmd);
        }
        public static bool Update(CirculatedCopy cc)
        {
            SqlCommand cmd = new SqlCommand("update CirculatedCopy set returnedDate = @returnedDate, fineAmount = @fineAmount where id = @id");
            cmd.Parameters.AddWithValue("@returnedDate", cc.ReturnedDate);
            cmd.Parameters.AddWithValue("@fineAmount", cc.FineAmount);
            cmd.Parameters.AddWithValue("@id", cc.Id);
            return DAO.UpdateTable(cmd);
        }
    }
}