using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q2A
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            DataTable dt = DAO.getClass();
            comboBox1.DataSource = dt;
            comboBox1.DisplayMember = "class";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            DataTable dt = DAO.getShips();
            //bool isNumber = int.TryParse(textBox2.Text, out int _);
            if (textBox1.Text != "")
            {
                try
                {
                    int launched = int.Parse(textBox2.Text);
                    if (int.Parse(textBox2.Text) >= 1900)
                    {
                        foreach (DataRow dr in dt.Rows)
                        {
                            if (dr["name"].ToString().Trim().Equals(textBox1.Text.Trim()))
                            {
                                MessageBox.Show("Duplicate ship name !", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                                break;
                            }
                        }
                        SqlCommand cmd = new SqlCommand("INSERT INTO Ships (name, class,launched)" +
                                    " VALUES(@name, @class, @launch)");
                        cmd.Parameters.AddWithValue("@name", textBox1.Text);
                        cmd.Parameters.AddWithValue("@class", comboBox1.Text);
                        cmd.Parameters.AddWithValue("@launch", launched);
                        DAO.UpdateTable(cmd);
                    }
                    else
                    {
                        MessageBox.Show("Must be > 1900!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                    }
                }
                catch
                {
                    MessageBox.Show("Must be digit!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            else
            {
                MessageBox.Show("Name required !", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }

        }
    }
}
