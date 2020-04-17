using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Configuration;
using System.Data.SqlClient;

namespace StudentManagement
{
    public partial class frmMain : Form
    {
        public static String connectionString = ConfigurationManager.ConnectionStrings["DBConnectionString"].ConnectionString;
        private int currentSelected;
        public SqlConnection connection = new SqlConnection(connectionString);
        public frmMain()
        {
            InitializeComponent();
        }

        private void load_Student()
        {
            connection.Open();
            SqlDataAdapter sda = new SqlDataAdapter("SELECT * FROM tbl_Student", connection);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            DGVStudent.DataSource = dt;
            connection.Close();
        }

        private void btnAddNew_Click(object sender, EventArgs e)
        {
            
        }

        private void frmMain_Load(object sender, EventArgs e)
        {
            load_Student();
        }

        private void DGVStudent_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {
            
        }

        private void DGVStudent_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            txtRollNumber.Text = DGVStudent.Rows[e.RowIndex].Cells["roll_number"].Value.ToString();
            txtFullName.Text = DGVStudent.Rows[e.RowIndex].Cells["full_name"].Value.ToString();
            txtClass.Text = DGVStudent.Rows[e.RowIndex].Cells["class"].Value.ToString();
            txtEmail.Text = DGVStudent.Rows[e.RowIndex].Cells["email"].Value.ToString();
            txtGender.Text = DGVStudent.Rows[e.RowIndex].Cells["gender"].Value.ToString();
            txtPhoneNumber.Text = DGVStudent.Rows[e.RowIndex].Cells["phone_number"].Value.ToString();
            currentSelected = int.Parse(DGVStudent.Rows[e.RowIndex].Cells["student_id"].Value.ToString());
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            connection.Open();
            SqlCommand cmd = new SqlCommand(@"UPDATE tbl_Student 
                                              SET roll_number=@rollNumber,full_name=@fullName, 
                                              class=@class,gender=@gender,email=@email,phone_number=@phoneNumber
                                              WHERE student_id = @id",connection);
            cmd.Parameters.Add("@rollNumber", SqlDbType.NVarChar).Value = txtRollNumber.Text;
            cmd.Parameters.Add("@fullName", SqlDbType.NVarChar).Value = txtFullName.Text;
            cmd.Parameters.Add("@class", SqlDbType.NVarChar).Value = txtClass.Text;
            cmd.Parameters.Add("@gender", SqlDbType.NVarChar).Value = txtGender.Text;
            cmd.Parameters.Add("@email", SqlDbType.NVarChar).Value = txtEmail.Text;
            cmd.Parameters.Add("@phoneNumber", SqlDbType.NVarChar).Value = txtPhoneNumber.Text;
            cmd.Parameters.Add("@id", SqlDbType.Int).Value = currentSelected;
            cmd.ExecuteNonQuery();
            connection.Close();
            load_Student();
        }
    }
}
