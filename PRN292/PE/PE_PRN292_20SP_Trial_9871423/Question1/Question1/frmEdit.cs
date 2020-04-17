using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Question1
{
    public partial class frmEdit : Form
    {
        int member_no;
        public frmEdit(int member_no)
        {
            InitializeComponent();
            string sql = "select member_no, firstname, lastname, issue_dt, expr_dt " +
                            "from member where member_no = " + member_no;
            DataTable dt = DAO.GetDataTable(sql);
            DataRow r = dt.Rows[0];
            textBox1.Text = r["FirstName"].ToString();
            textBox2.Text = r["Lastname"].ToString();
            dateTimePicker1.Value = (DateTime)r["issue_dt"];
            dateTimePicker2.Value = (DateTime)r["expr_dt"];
            this.member_no = member_no;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("Update Member set firstName = @f, lastName = @l, " +
                "issue_dt = @id, expr_dt = @ed WHERE member_no = @no");
            cmd.Parameters.AddWithValue("@f", textBox1.Text);
            cmd.Parameters.AddWithValue("@l", textBox2.Text);
            cmd.Parameters.AddWithValue("@id", dateTimePicker1.Value);
            cmd.Parameters.AddWithValue("@ed", dateTimePicker2.Value);
            cmd.Parameters.AddWithValue("@no", member_no);

            if (DAO.UpdateTable(cmd))
                MessageBox.Show("Edit member info is succesfull");


        }
    }
}
