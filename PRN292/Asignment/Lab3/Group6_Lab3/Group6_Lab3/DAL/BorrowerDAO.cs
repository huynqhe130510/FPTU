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
    class BorrowerDAO
    {
        internal static Borrower GetBorrower(int borrowerNumber)
        {
            string strConn = "Data Source=localhost;Initial Catalog=Library;Integrated Security=True";
            Borrower borrower = new Borrower();
            using (SqlConnection myConnection = new SqlConnection(strConn))
            {
                string cmd = "select * from Borrower where borrowerNumber = @borrowerNumber";
                SqlCommand oCmd = new SqlCommand(cmd, myConnection);
                oCmd.Parameters.AddWithValue("@borrowerNumber", borrowerNumber);
                myConnection.Open();
                using (SqlDataReader oReader = oCmd.ExecuteReader())
                {
                    while (oReader.Read())
                    {
                        borrower.BorrowerNumber = (int)oReader["borrowerNumber"];
                        borrower.Name = oReader["name"].ToString();
                        borrower.Sex = oReader["sex"].ToString();
                        borrower.Address = oReader["address"].ToString();
                        borrower.Telephone = oReader["telephone"].ToString();
                        borrower.Email = oReader["email"].ToString();
                    }

                    myConnection.Close();
                }
            }
            return borrower;
        }
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Borrower";
            return DAO.GetDataTable(cmd);
        }

        public static int GetBorrowNumberMax()
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(borrowerNumber)", ""));
        }


        public static bool Insert(Borrower b)
        {
            SqlCommand cmd = new SqlCommand("insert into borrower (borrowerNumber, name, sex, address, telephone, email)" +
                    "values (@borrowerNumber, @name, @sex, @address, @telephone, @email)");
            cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
            cmd.Parameters.AddWithValue("@name", b.Name);
            cmd.Parameters.AddWithValue("@sex", b.Sex);
            cmd.Parameters.AddWithValue("@address", b.Address);
            cmd.Parameters.AddWithValue("@telephone", b.Telephone);
            cmd.Parameters.AddWithValue("@email", b.Email);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(Borrower b)
        {
            SqlCommand cmd = new SqlCommand("update Borrower set name=@name, sex = @sex, address = @address, telephone = @telephone, email = @email " +
                "where borrowerNumber=@borrowerNumber");
            cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
            cmd.Parameters.AddWithValue("@name", b.Name);
            cmd.Parameters.AddWithValue("@sex", b.Sex);
            cmd.Parameters.AddWithValue("@address", b.Address);
            cmd.Parameters.AddWithValue("@telephone", b.Telephone);
            cmd.Parameters.AddWithValue("@email", b.Email);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(int borrowerNumber)
        {
            SqlCommand cmd = new SqlCommand("delete Borrower where borrowerNumber=@borrowerNumber");
            cmd.Parameters.AddWithValue("@borrowerNumber", borrowerNumber);
            return DAO.UpdateTable(cmd);
        }
    }

}
