using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q2_WF_Fuhub
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
            string query = ConfigurationManager.ConnectionStrings["sqlstudent"].ConnectionString.ToString();
            conn = new SqlConnection(query);
            conn.Open();
            display();
            //  txtID.DataBindings.Clear();
            txtID.DataBindings.Add("Text", dataGridView1.DataSource, "id");
            txtName.DataBindings.Add("Text", dataGridView1.DataSource, "name");
            txtAge.DataBindings.Add("Text", dataGridView1.DataSource, "age");
            txtClass.DataBindings.Add("Text", dataGridView1.DataSource, "class");
        }
        public void display()
        {
            string query = "SELECT * FROM Information";
            //SqlCommand cmd = new SqlCommand(query, conn);
           // SqlDataReader dr = cmd.ExecuteReader();
           // DataTable dt = new DataTable();
           // dt.Load(dr);
           // dataGridView1.DataSource = dt;

            SqlDataAdapter sda = new SqlDataAdapter(query, conn);
            DataTable dt = new DataTable();
            sda.Fill(dt);
            dataGridView1.DataSource = dt;
        }

        private void add_Click(object sender, EventArgs e)
        {
            string query = "insert into information Values(@id, @name, @age, @class)";
            SqlCommand cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddWithValue("id", txtID.Text);
            cmd.Parameters.AddWithValue("name", txtName.Text);
            cmd.Parameters.AddWithValue("age", txtAge.Text);
            cmd.Parameters.AddWithValue("class", txtClass.Text);
            cmd.ExecuteNonQuery();
            display();
        }

        private void edit_Click(object sender, EventArgs e)
        {
            string query = "update information set name = @name, age = @age, class = @class where id = @id";
            SqlCommand cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddWithValue("id", txtID.Text);
            cmd.Parameters.AddWithValue("name", txtName.Text);
            cmd.Parameters.AddWithValue("age", txtAge.Text);
            cmd.Parameters.AddWithValue("class", txtClass.Text);
            cmd.ExecuteNonQuery();
            display(); 
        }

        private void delete_Click(object sender, EventArgs e)
        {
            string query = "delete from information where id = @id";
            SqlCommand cmd = new SqlCommand(query, conn);
            cmd.Parameters.AddWithValue("id", txtID.Text);
            cmd.ExecuteNonQuery();
            display();
        }

        private void Form1_FormClosing(object sender, FormClosingEventArgs e)
        {
            conn.Close();
        }
    }
}
