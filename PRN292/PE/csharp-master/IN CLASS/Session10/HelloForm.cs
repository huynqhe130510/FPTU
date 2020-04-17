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
    public partial class HelloForm : Form
    {
        public HelloForm()
        {
            InitializeComponent();
        }

        private void btnSubmit_Click(object sender, EventArgs e)
        {       
            MessageBox.Show("Button Submit clicked");
            txtName.Text = "Hello Fu students";
            lblName.Text = "Display name";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
