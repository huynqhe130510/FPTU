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

namespace WF_Student
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        SqlConnection conn;
        private void Form1_Load(object sender, EventArgs e)
        {
            string conString = ConfigurationManager.ConnectionStrings["QLStudent"].ConnectionString.ToString();
            conn = new SqlConnection(conString);
            conn.Open();
            Dislay();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            conn.Close();
        }
        public void Dislay()
        {
            string sqlSELECT = "SELECT * FROM Information";
            SqlCommand cmd = new SqlCommand(sqlSELECT, conn);
            SqlDataReader dr = cmd.ExecuteReader();
            DataTable dt = new DataTable();
            dt.Load(dr);
            dataGridView1.DataSource = dt;
            txtID.DataBindings.Clear();
            txtName.DataBindings.Clear();
            txtClass.DataBindings.Clear();
            txtAge.DataBindings.Clear();

            txtID.DataBindings.Add("Text", dataGridView1.DataSource, "id");
            txtName.DataBindings.Add("Text", dataGridView1.DataSource, "name");
            txtClass.DataBindings.Add("Text", dataGridView1.DataSource, "class");
            txtAge.DataBindings.Add("Text", dataGridView1.DataSource, "age");

        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string sqlINSERT = "insert into information VALUES (@id, @name, @age, @class)";
            SqlCommand cmd = new SqlCommand(sqlINSERT, conn);
            cmd.Parameters.AddWithValue("id", txtID.Text);
            cmd.Parameters.AddWithValue("name", txtName.Text);
            cmd.Parameters.AddWithValue("age", txtAge.Text);
            cmd.Parameters.AddWithValue("class", txtClass.Text);
            cmd.ExecuteNonQuery();
            Dislay();
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            string sqlEDIT = "update information set name = @name, age = @age, class = @class where id = @id";
            SqlCommand cmd = new SqlCommand(sqlEDIT, conn);
            cmd.Parameters.AddWithValue("id", txtID.Text);
            cmd.Parameters.AddWithValue("name", txtName.Text);
            cmd.Parameters.AddWithValue("age", txtAge.Text);
            cmd.Parameters.AddWithValue("class", txtClass.Text);
            cmd.ExecuteNonQuery();
            Dislay();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            string sqlDELETE = "delete from information where id = @id";
            SqlCommand cmd = new SqlCommand(sqlDELETE, conn);
            cmd.Parameters.AddWithValue("id", txtID.Text);
            cmd.ExecuteNonQuery();
            Dislay();
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            string sqlSEARCH = "select * from information where id = @id";
            SqlCommand cmd = new SqlCommand(sqlSEARCH, conn);
            cmd.Parameters.AddWithValue("id", txtSearch.Text);
            cmd.ExecuteNonQuery();
            SqlDataReader dr = cmd.ExecuteReader();
            DataTable dt = new DataTable();
            dt.Load(dr);
            dataGridView1.DataSource = dt;
        }
    }
}
