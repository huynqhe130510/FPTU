using Group6_Lab3.GUI;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Group6_Lab3
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void embed(Panel panel, Form f)
        {
            panel.Controls.Clear();
            f.FormBorderStyle = FormBorderStyle.None;
            f.TopLevel = false;
            f.Show();

            panel.Controls.Add(f);

        }


        private void bookToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new BookGUI());
        }

        private void memberToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new MemberGUI());
        }

        private void borrowToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new BorrowGUI());
        }

        private void returnToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new ReturnGUI());
        }

        private void reverToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new ReserveGUI());
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            embed(toolStripContainer1.ContentPanel, new AboutGUI());
        }
    }
}
