using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Configuration;
using System.Data.SqlClient;

namespace SE1315_ComboBox
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            DataTable dt = DAO.GetDataTable("select * from Book");
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "Title";
            comboBox1.ValueMember = "BookNumber";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DataTable dt = DAO.GetDataTable("select * from Copy where bookNumber = " + comboBox1.SelectedValue);
            dataGridView1.DataSource = dt;
        }
    }
}
