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
    public partial class ManagerDisplay : Form
    {
        int curEmployee;
        public ManagerDisplay()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;
        }
        public ManagerDisplay(int curEmployee)
        {
            InitializeComponent();
            this.curEmployee = curEmployee;
            WindowState = FormWindowState.Maximized;

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lbTime.Text = DateTime.Now.ToLongTimeString();
        }

        private void ManagerDisplay_Load(object sender, EventArgs e)
        {
            lbDate.Text = DateTime.Now.ToShortDateString();
            timer1.Start();
        }

        private void btStaffManager_Click(object sender, EventArgs e)
        {
            StaffManager sm = new StaffManager(curEmployee);
            sm.Show();
        }

        private void btProfile_Click(object sender, EventArgs e)
        {
            Profile pf = new Profile(curEmployee);
            pf.Show();
        }

        private void lbTime_Click(object sender, EventArgs e)
        {

        }

        private void btSale_Click(object sender, EventArgs e)
        {
            SaleForm sf = new SaleForm(curEmployee);
            sf.Show();
            this.Close();
        }

        private void btMenuManager_Click(object sender, EventArgs e)
        {
            ListPro f1 = new ListPro();
            f1.Show();

        }

        private void btLogout_Click(object sender, EventArgs e)
        {
            Login lg = new Login();
            lg.Show();
            this.Close();

        }

        private void btReport_Click(object sender, EventArgs e)
        {
            Form1 fm = new Form1();
            fm.Show();
        }
    }
}
