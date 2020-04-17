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
    public class ReserveDAO
    {
        static string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
        public static Reservation GetFirstReservation(int bookNumber)
        {
            Reservation reservation = new Reservation();
            using (SqlConnection myConnection = new SqlConnection(strConn))
            {
                string cmd = "select top 1 id, borrowerNumber, bookNumber, date, status from Reservation where bookNumber = @bookNumber and [status] = 'R'";
                SqlCommand oCmd = new SqlCommand(cmd, myConnection);
                oCmd.Parameters.AddWithValue("@bookNumber", bookNumber);
                myConnection.Open();
                using (SqlDataReader oReader = oCmd.ExecuteReader())
                {
                    while (oReader.Read())
                    {
                        reservation.Id = (int)oReader["id"];
                        reservation.BorrowerNumber = (int)oReader["borrowerNumber"];
                        reservation.BookNumber = (int)oReader["bookNumber"];
                        reservation.Date = (DateTime)oReader["date"];
                        reservation.Status = oReader["status"].ToString();
                    }

                    myConnection.Close();
                }
            }
            return reservation;
        }

        public static Reservation GetReservation(int bookNumber)
        {
            Reservation reservation = new Reservation();
            using (SqlConnection myConnection = new SqlConnection(strConn))
            {
                string cmd = "select * from Reservation where bookNumber = @bookNumber";
                SqlCommand oCmd = new SqlCommand(cmd, myConnection);
                oCmd.Parameters.AddWithValue("@bookNumber", bookNumber);
                myConnection.Open();
                using (SqlDataReader oReader = oCmd.ExecuteReader())
                {
                    while (oReader.Read())
                    {
                        reservation.Id = (int)oReader["id"];
                        reservation.BorrowerNumber = (int)oReader["borrowerNumber"];
                        reservation.BookNumber = (int)oReader["bookNumber"];
                        reservation.Date = (DateTime)oReader["date"];
                        reservation.Status = oReader["status"].ToString();
                    }

                    myConnection.Close();
                }
            }
            return reservation;
        }

        internal static DataTable GetReserve(int borrowerNumber)
        {
            string cmd = "  select * from Reservation where borrowerNumber = " + borrowerNumber + " and [status] = 'R'";
            return DAO.GetDataTable(cmd);
        }

        internal static bool Update(Reservation r)
        {
            SqlCommand cmd = new SqlCommand("update Reservation set bookNumber = @bookNumber, date = @date, status = @status  where borrowerNumber = @borrowerNumber");
            cmd.Parameters.AddWithValue("@borrowerNumber", r.BorrowerNumber);
            cmd.Parameters.AddWithValue("@bookNumber", r.BookNumber);
            cmd.Parameters.AddWithValue("@date", r.Date);
            cmd.Parameters.AddWithValue("@status", r.Status);
            return DAO.UpdateTable(cmd);
        }

        internal static bool AddReservation(Reservation reservation)
        {
            SqlCommand cmd = new SqlCommand("insert into Reservation (borrowerNumber, bookNumber, date, status)" +
                    "values (@borrowerNumber, @bookNumber, @date , @status)");
            cmd.Parameters.AddWithValue("@borrowerNumber", reservation.BorrowerNumber);
            cmd.Parameters.AddWithValue("@bookNumber", reservation.BookNumber);
            cmd.Parameters.AddWithValue("@date", reservation.Date);
            cmd.Parameters.AddWithValue("@status", reservation.Status);
            return DAO.UpdateTable(cmd);
        }

        public static int CheckbookNumber(int bookNumber)
        {
            SqlConnection conn = new SqlConnection(strConn);
            SqlCommand cmd = new SqlCommand("SELECT * FROM Book WHERE bookNumber = @bookNumber", conn);
            cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt.Rows.Count;
        }

        public static int CheckNumberofCopy(string bookNumber)
        {
            SqlConnection conn = new SqlConnection(strConn);
            SqlCommand cmd = new SqlCommand("SELECT * FROM Copy WHERE bookNumber = @bookNumber and type = 'A'", conn);
            cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataTable dt = new DataTable();
            da.Fill(dt);
            return dt.Rows.Count;
        }

        internal static int getBookNumberByCopyNumber(int copyNumber)
        {
            string cmd = "select b.bookNumber from Book b, Copy c where b.bookNumber = c.bookNumber and c.copyNumber = " + copyNumber;
            int bookNumber = 0;
            foreach (DataRow dr in DAO.GetDataTable(cmd).Rows)
            {
                bookNumber = int.Parse(dr[0].ToString());
            }
            return bookNumber;
        }
    }
}