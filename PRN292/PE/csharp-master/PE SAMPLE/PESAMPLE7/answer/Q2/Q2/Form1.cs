using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q2
{
    public partial class Form1 : Form
    {
        DataProvider dataProvider = new DataProvider();
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            loadData();
        }

        public void loadData()
        {
            dataGridView1.Columns.Clear();

            dataProvider.DATA_GRID_VIEW("select corporation.corp_no, corporation.corp_name, corporation.expr_dt, region.region_name from corporation inner join region on corporation.region_no = region.region_no", dataGridView1);

            dataGridView1.Columns[0].HeaderText = "Corporation No";
            dataGridView1.Columns[1].HeaderText = "Corporation Name";
            dataGridView1.Columns[2].HeaderText = "ExprDate";
            dataGridView1.Columns[3].HeaderText = "Region Name";

            DataGridViewButtonColumn editColumn = new DataGridViewButtonColumn();
            editColumn.HeaderText = "Edit";
            editColumn.Name = "checkEdit";
            editColumn.Text = "Edit";
            editColumn.UseColumnTextForButtonValue = true;

            dataGridView1.Columns.Add(editColumn);
        }


        private void EditForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            loadData();
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (string.Equals(dataGridView1.Columns[e.ColumnIndex].Name, "checkEdit"))
            {
                string idCor = dataGridView1.Rows[e.RowIndex].Cells[0].Value.ToString();
                EditForm editForm = new EditForm(idCor);
                editForm.FormClosed += EditForm_FormClosed;
                editForm.Show();
            }
        }
    }
}
