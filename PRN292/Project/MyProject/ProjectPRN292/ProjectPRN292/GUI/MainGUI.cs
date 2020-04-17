using ProjectPRN292.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectPRN292.GUI
{
    public partial class MainGUI : Form
    {
        string username;
        int staffId;
        string staffname;
        int roleId;
        public MainGUI()
        {
            InitializeComponent();
        }

        public MainGUI(string username, int staffId, string staffName, int roleId)
        {
            InitializeComponent();
            this.username = username;
            this.staffId = staffId;
            this.staffname = staffName;
            this.roleId = roleId;
            if(roleId == 2)
            {
                staffToolStripMenuItem.Enabled = false;
                productToolStripMenuItem.Enabled = false;
                statisticToolStripMenuItem.Enabled = false;
            }
            toolStripTextBox1.Text = "Welcome " + username;
        }

        private void embed(Panel panel, Form f)
        {
            panel.Controls.Clear();
            f.FormBorderStyle = FormBorderStyle.None;
            f.TopLevel = false;
            f.Show();

            panel.Controls.Add(f);

        }

        private void salesToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new SalesGUI(staffId, staffname));
        }

        private void staffToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new StaffGUI());
        }

        private void productToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new ProductGUI());
        }

        private void statisticToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new StatisticGUI());
        }

        private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Hide();
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.ShowDialog();
            this.Close();
        }
    }
}
