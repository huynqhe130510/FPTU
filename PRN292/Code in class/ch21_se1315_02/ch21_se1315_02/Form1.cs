using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ch21_se1315_02
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            for (int i = 1; i < 10; i++)
            {
                comboBox1.Items.Add("Item " + i);
                listBox1.Items.Add("Item " + i);
                checkedListBox1.Items.Add("Item " + i);
            }

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string s = "";
            s += "ComboBox : ";
            //s += comboBox1.SelectedItem.ToString();
            //s += comboBox1.Items[comboBox1.SelectedIndex].ToString();
            s += comboBox1.Text;

            s += "\nListBox : ";
            s += listBox1.Text;

            s += "\nCheckListBox : ";
            foreach (var item in checkedListBox1.CheckedItems)
            {
                s += "\n" + item.ToString();
            }
            MessageBox.Show(s);
        }
    }
}
