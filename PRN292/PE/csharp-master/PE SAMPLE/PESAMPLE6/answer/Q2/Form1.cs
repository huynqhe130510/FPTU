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

        public void loadData()
        {
            dataGridView1.Columns.Clear();

            DataGridViewCheckBoxColumn checkBoxColumn = new DataGridViewCheckBoxColumn();
            checkBoxColumn.HeaderText = "Select";
            dataGridView1.Columns.Add(checkBoxColumn);

            dataProvider.DATA_GRID_VIEW("select member.member_no, member.lastname, member.firstname, region.region_name from member inner join region on member.region_no = region.region_no", dataGridView1);

            DataGridViewButtonColumn editColumn = new DataGridViewButtonColumn();
            editColumn.HeaderText = "Edit";
            editColumn.Name = "checkEdit";
            editColumn.Text = "Edit Member";
            editColumn.UseColumnTextForButtonValue = true;
            DataGridViewButtonColumn deleteColumn = new DataGridViewButtonColumn();
            deleteColumn.HeaderText = "Delete";
            deleteColumn.Name = "checkDelete";
            deleteColumn.Text = "Delete Member";
            deleteColumn.UseColumnTextForButtonValue = true;

            dataGridView1.Columns.Add(editColumn);
            dataGridView1.Columns.Add(deleteColumn);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            loadData();
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            dataGridView1.Rows[e.RowIndex].Selected = true;
            // check edit, delete
            if (string.Equals(dataGridView1.Columns[e.ColumnIndex].Name, "checkEdit"))
            {
                string memberNo = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                MemberForm memberForm = new MemberForm(memberNo, false);
                memberForm.FormClosed += MemberForm_FormClosed;
                memberForm.Show();

            }
            else if (string.Equals(dataGridView1.Columns[e.ColumnIndex].Name, "checkDelete"))
            {
                string idMember = dataGridView1.Rows[e.RowIndex].Cells[1].Value.ToString();
                // show message
                dataProvider.ADD_UPDATE_DELETE("DELETE FROM member WHERE member_no = @para1", new object[] { idMember });
                MessageBox.Show("Delete successful!!!", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                loadData();
            }
            else
            {
                DataGridViewRow dr = dataGridView1.Rows[e.RowIndex];
                tbFirstName.DataBindings.Clear();
                tbLastName.DataBindings.Clear();
                tbFirstName.DataBindings.Add("Text", dataGridView1.DataSource, "firstname");
                tbLastName.DataBindings.Add("Text", dataGridView1.DataSource, "lastname");
            }
        }

        private void MemberForm_FormClosed(object sender, FormClosedEventArgs e)
        {
            loadData();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            MemberForm memberForm = new MemberForm("member", true);
            memberForm.FormClosed += MemberForm_FormClosed;
            memberForm.Show();
        }

        private void btnDeleteAll_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Do you want to Edit?", "Confirm", MessageBoxButtons.YesNo);
            if (result == DialogResult.Yes)
            {
                int count = 0;
                for (int row = 0; row < dataGridView1.RowCount; row++)
                {
                    if (Convert.ToBoolean(dataGridView1.Rows[row].Cells[0].Value) == true)
                    {
                        count++;
                        dataProvider.ADD_UPDATE_DELETE("DELETE FROM member WHERE member_no = @param1", new object[] { dataGridView1.Rows[row].Cells[1].Value });
                    }
                }
                MessageBox.Show("Delete " + count + "member(s)");
                loadData();
            }
        }
    }
}
