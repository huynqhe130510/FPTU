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
            String sql = "select member.member_no, member.lastname, member.firstname, region.region_name from member, region " +
                         "where member.region_no = region.region_no";
            DataTable dt = DAO.GetDataTable(sql);
            dataGridView1.DataSource = dt;
            dt.Columns[0].ColumnName = "Member ID";
            dt.Columns[0].ColumnName = "Region Name";
            DataGridViewCheckBoxColumn dgvCmb = new DataGridViewCheckBoxColumn();
            dgvCmb.ValueType = typeof(bool);
            dgvCmb.Name = "Chk";
            dgvCmb.HeaderText = "Select";
            dataGridView1.Columns.Add(dgvCmb);
            dataGridView1.Columns["chk"].DisplayIndex = 0;

            DataGridViewButtonColumn button = new DataGridViewButtonColumn();
            button.Name = "button";
            button.HeaderText = "Edit";
            button.Text = "Edit";
            button.UseColumnTextForButtonValue = true;
            this.dataGridView1.Columns.Add(button);
            dataGridView1.Columns["button"].DisplayIndex = dataGridView1.Columns.Count - 1;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int n = 0;
            foreach (DataGridViewRow r in dataGridView1.Rows)
            {
                if(r.Cells[0].Value != null)
                {
                    if((bool)r.Cells[0].Value == true)
                    {
                        MessageBox.Show("Member_no = " + r.Cells[2].Value.ToString());
                        n++;
                    }
                }
            }
        }
    }
}
