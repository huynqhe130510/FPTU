using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ch21_se1315_01
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Display_Click(object sender, EventArgs e)
        {
            string s = "";
            s += "\nPassWord: " + textBox1.Text;
            s += "\nMultiline : " + textBox2.Text;
            s += "\nUpper : " + textBox3.Text;
            s += "\nColor : ";
            if (radioButton1.Checked) s += radioButton1.Text;
            else if (radioButton2.Checked) s += radioButton2.Text;
            else if (radioButton3.Checked) s += radioButton3.Text;
            MessageBox.Show(s);
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            if (checkBox1.Checked)
            {
                checkBox1.Text = "Male";
            }
            else
            {
                checkBox1.Text = "Female";
            }
        }

        private void checkBox2_CheckStateChanged(object sender, EventArgs e)
        {
            if (checkBox2.CheckState == CheckState.Checked)
            {
                checkBox2.Text = "Female";
            }
            else if (checkBox2.CheckState == CheckState.Unchecked)
            {
                checkBox2.Text = "Male";
            }
            else
            {
                checkBox2.Text = "Other";
            }
        }
    }
}
