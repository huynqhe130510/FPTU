using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter21
{
    public partial class StudentManager : Form
    {

        public StudentManager()
        {
            InitializeComponent();
        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void addNewToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AddStudent frm = new AddStudent(); //Tạo ra một form con mới
            frm.MdiParent = this;
            frm.Size = this.Size;
            frm.Show();
        }

        private void listToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ListStudent frm = new ListStudent(); //Tạo ra một form con mới
            frm.MdiParent = this;
            frm.Size = this.Size;
            frm.Show();
        }
    }
}
