using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ch19_se1315_01
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            toolStripTextBox1.LostFocus += toolStripTextBox1_LostFocus;
        }

        private void toolStripTextBox1_LostFocus(object sender, EventArgs e)
        {
            ToolStripTextBox tbm = (ToolStripTextBox)sender;
            try
            {
                BackColor = Color.FromName(tbm.Text);
            }
            catch(Exception ex)
            {
                MessageBox.Show(ex.Message);
            }
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("you press OK");
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("you press exit");
            Application.Exit();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void redToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ToolStripMenuItem mi = (ToolStripMenuItem)sender;
            BackColor = Color.FromName(mi.Text);
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            toolStripStatusLabel2.Text = DateTime.Now.ToString("dd/MM/yyy hh:mm:ss");
            if(toolStripProgressBar1.Value <= toolStripProgressBar1.Maximum * 19/20)
            toolStripProgressBar1.Value += toolStripProgressBar1.Maximum / 20;

        }

        private void toolStripButton1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("You press Limit");
        }

        private void newToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 f = new Form2();
            f.MdiParent = this;
            f.Show();
        }

        private void horixontalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileHorizontal);
        }

        private void verticalToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.TileVertical);
        }

        private void cascadeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LayoutMdi(MdiLayout.Cascade);
        }
    }
}
