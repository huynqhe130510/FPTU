using Group6_Lab3.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Group6_Lab3.DAL
{
    class ReserveDAO
    {
        internal static Reservation GetFirstReservation(int bookNumber)
        {
            string strConn = "Data Source=localhost;Initial Catalog=Library;Integrated Security=True";
            Reservation reservation = new Reservation();
            using (SqlConnection myConnection = new SqlConnection(strConn))
            {
                string cmd = "select top 1 id, borrowerNumber, bookNumber, date, status from Reservation where bookNumber = @bookNumber";
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

        internal static Reservation GetReservation(int bookNumber)
        {
            string strConn = "Data Source=localhost;Initial Catalog=Library;Integrated Security=True";
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
            string cmd = "  select top 1.* from Reservation where borrowerNumber = " + borrowerNumber + " and [status] = 'R'";
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
    }
}
