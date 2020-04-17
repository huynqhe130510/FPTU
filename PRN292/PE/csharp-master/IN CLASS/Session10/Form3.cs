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
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void btnDisplay_Click(object sender, EventArgs e)
        {
            MessageBox.Show("HELLO FU students");
            txtName.Text = "First Application";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Student Name : " + txtName.Text);
        }

        private void txtName_TextChanged(object sender, EventArgs e)
        {
            lblName.Text = txtName.Text;
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }

        private void projectToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Menu project is open");
        }
    }
}
