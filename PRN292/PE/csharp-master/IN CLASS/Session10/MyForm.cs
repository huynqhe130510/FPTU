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
    public partial class MyForm : Form
    {
        public MyForm()
        {
            InitializeComponent();
            // Handle the MouseMove event
            MouseMove += new MouseEventHandler(MyForm_MouseUp);
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
            MessageBox.Show("Textbox change");
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Button click");
        }
        public void MyForm_MouseUp(object sender, MouseEventArgs e)
        {
            // Which mouse button was clicked?
            if (e.Button == MouseButtons.Left)
                MessageBox.Show("Left click!");
            if (e.Button == MouseButtons.Right)
                MessageBox.Show("Right click!");
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("My StatusStripApp!");
        }

        private void MyForm_Load(object sender, EventArgs e)
        {

        }
    }
}
