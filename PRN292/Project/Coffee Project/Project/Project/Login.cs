using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;


namespace Project
{
    public partial class Login : Form
    {
        public Login()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            tbName.Text = "";
            tbPass.Text = "";
        }

        private void button2_Click(object sender, EventArgs e)
        {
            string userName = tbName.Text;
            string pass = tbPass.Text;
            DataTable dt = DataAccess.getEmployee(userName, pass);
            if (dt.Rows.Count<=0) MessageBox.Show("Wrong name or password!");
            else
            {
                DataRow dr = dt.Rows[0];
                int employeeID = Convert.ToInt32(dr["EmployeeID"].ToString());
                if (dr["Role"].ToString().Trim().Equals("STAFF"))
                {
                    //hiện màn hình của staff
                    SaleForm saleForm = new SaleForm(employeeID);
                    saleForm.Show();
                    this.Visible = false;
                }
                else
                {
                    //hiện màn hình của manager
                    ManagerDisplay md = new ManagerDisplay(employeeID);
                    md.Show();
                    this.Visible = false;
                }
            }
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void Login_Load(object sender, EventArgs e)
        {
            timer1.Start();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label4.Text = DateTime.Now.ToLongTimeString();
            label5.Text = DateTime.Now.ToLongDateString();
        }
    }
}
