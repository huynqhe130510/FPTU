using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            DataTable dt1 = DAO.GetDataTable("select * from region");
            comboBox1.DataSource = dt1;
            comboBox1.DisplayMember = "region_name";
            comboBox1.ValueMember = "region_no";

            DataTable dt2 = DAO.GetDataTable("select * from corporation where region_no = " + comboBox1.SelectedValue);
            comboBox2.DataSource = dt2;
            comboBox2.DisplayMember = "corp_name";
            comboBox2.ValueMember = "corp_no";

            DataTable dt = DAO.GetDataTable("select lastname, m.phone_no, r.region_name, c.corp_name from member m, region r, corporation c where m.corp_no = c.corp_no and m.region_no = r.region_no");
            dataGridView1.DataSource = dt;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            comboBox2.ResetText();
            DataTable dt2 = DAO.GetDataTable("select * from corporation where region_no = " + comboBox1.SelectedValue);
            comboBox2.DataSource = dt2;
            comboBox2.DisplayMember = "corp_name";
            comboBox2.ValueMember = "corp_no";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("INSERT INTO [member] ([lastname],[firstname],[street],[city],[state_prov],[country],[mail_code],[phone_no],[issue_dt],[expr_dt],[region_no],[corp_no],[member_code])" +
                " VALUES (@lastName, '', '', '', '', '', '', @phoneNo, '', '', @region, @corp, '')");
            cmd.Parameters.AddWithValue("@lastName", textBox1.Text);
            cmd.Parameters.AddWithValue("@phoneNo", textBox2.Text);
            cmd.Parameters.AddWithValue("@region", comboBox1.SelectedValue);
            cmd.Parameters.AddWithValue("@corp", comboBox2.SelectedValue);
            DAO.UpdateTable(cmd);
            DataTable dt = DAO.GetDataTable("select lastname, m.phone_no, r.region_name, c.corp_name from member m, region r, corporation c where m.corp_no = c.corp_no and m.region_no = r.region_no");
            dataGridView1.DataSource = dt;
        }
    }
}
