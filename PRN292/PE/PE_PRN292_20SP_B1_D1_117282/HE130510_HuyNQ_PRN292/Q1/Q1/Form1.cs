using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            DataTable dt = DAO.GetDataTable("select distinct Nationality  from InfectedCases");
            listBox1.DataSource = dt;
            listBox1.DisplayMember = "Nationality";
            listBox1.ValueMember = "Nationality";
            listBox1.SelectedIndex = 5;

            radioButton3.Checked = true;
            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 20 and Age < 40 and Nationality = 'Viet Nam'");
            dataGridView1.DataSource = dt1;
        }

        private void radioButton1_CheckedChanged(object sender, EventArgs e)
        {
            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age < 10");
            dataGridView1.DataSource = dt1;
        }

        private void radioButton2_CheckedChanged(object sender, EventArgs e)
        {
            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 10 and Age < 20");
            dataGridView1.DataSource = dt1;
        }

        private void radioButton3_CheckedChanged(object sender, EventArgs e)
        {
            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 20 and Age < 40");
            dataGridView1.DataSource = dt1;
        }

        private void radioButton4_CheckedChanged(object sender, EventArgs e)
        {
            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 40 20 and Age < 65");
            dataGridView1.DataSource = dt1;
        }

        private void radioButton6_CheckedChanged(object sender, EventArgs e)
        {
            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 65");
            dataGridView1.DataSource = dt1;
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string s = " and Nationality = '" + listBox1.SelectedValue + "'";
            if (radioButton1.Checked == true)
            {
                DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age < 10" + s);
                dataGridView1.DataSource = dt1;
            }
            else { 
                if(radioButton2.Checked == true)
                {
                    DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 10 and Age < 20" + s);
                    dataGridView1.DataSource = dt1;
                }
                else
                {
                    if (radioButton3.Checked == true)
                    {
                        DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 20 and Age < 40" + s);
                        dataGridView1.DataSource = dt1;
                    }
                    else
                    {
                        if (radioButton4.Checked == true)
                        {
                            DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 40 20 and Age < 65" + s);
                            dataGridView1.DataSource = dt1;
                        }
                        else
                        {
                            if (radioButton6.Checked == true)
                            {
                                DataTable dt1 = DAO.GetDataTable("select * from InfectedCases where  Age >= 65" + s);
                                dataGridView1.DataSource = dt1;
                            }

                        }

                    }

                }
            }
        }
    }
}
