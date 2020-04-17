using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter19
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void btnDisplayName_Click(object sender, EventArgs e)
        {
            txtName.Text = "Hello Fu students";
            MessageBox.Show("Happy New Year");
            this.Close();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            MessageBox.Show("Hello winform");
            txtName.Text = "New application";
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void txtName_TextChanged(object sender, EventArgs e)
        {
            lblName.Text = txtName.Text;
        }
    }
}
