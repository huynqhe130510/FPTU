using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;
using System.Configuration;

namespace ch22_se1315_01
{
    public partial class Form1 : Form
    {
        public static string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("Select * from book", conn);
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataTable dt = new DataTable();
            da.Fill(dt);

            DataView dv = new DataView(dt);

            dataGridView1.DataSource = dv;

        }

        private void button2_Click(object sender, EventArgs e)
        {
            DataView dv = (DataView)dataGridView1.DataSource;
            dv.RowFilter = "title = '" + textBox1.Text + "'";
            dataGridView1.DataSource = dv;
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            txtTitle.Text = dataGridView1.Rows[e.RowIndex].Cells["Title"].Value.ToString();
            txtAuthor.Text = dataGridView1.Rows[e.RowIndex].Cells["Authors"].Value.ToString();
            txtPublisher.Text = dataGridView1.Rows[e.RowIndex].Cells["Publisher"].Value.ToString();
        }

        private void button3_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("Insert into book (title, authors, publisher) " +
                "values(@t, @a, @p)", conn);
            cmd.Parameters.AddWithValue("@t", txtTitle.Text);
            cmd.Parameters.AddWithValue("@a", txtAuthor.Text);
            cmd.Parameters.AddWithValue("@p", txtPublisher.Text);

            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
        }
    }
}
