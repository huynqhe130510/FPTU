using System;
using System.Collections;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q3
{
    public partial class form1 : Form
    {
        DataProvider dataProvider = new DataProvider();

        public form1()
        {
            InitializeComponent();
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void form1_Load(object sender, EventArgs e)
        {
            dataProvider.LIST_BOX("select * from Project", "name", "id", lbProjects);
            dataProvider.LIST_BOX("select * from Employee", "name", "id", lbEmployees);

        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(tbPosition.Text.Trim()))
            {
                MessageBox.Show("Position cannot be blank", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (!checkDuplicate())
            {
                MessageBox.Show("This employee has been added to the project.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                dataProvider.ADD_UPDATE_DELETE("insert into ProjectMember values ( @param1 , @param2 , @param3 , @param4 , @param5 )",
                    new object[] { lbEmployees.SelectedValue, lbProjects.SelectedValue, tbPosition.Text, cbFulltime.Checked, Convert.ToDateTime(dateTimePicker1.Value) });
                MessageBox.Show("Data is saved!", "information", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }

        private bool checkDuplicate()
        {
            ArrayList listString = dataProvider.LIST_STRING("select employeeID from ProjectMember where projectID = @param1", new object[] { lbProjects.SelectedValue });
            foreach (string item in listString)
            {
                Console.WriteLine("item: " + item);
                Console.WriteLine("employ: " + lbEmployees.SelectedValue);
                if (string.Equals(item, lbEmployees.SelectedValue.ToString()))
                {
                    return false;
                }
            }
            return true;
        }
    }
}
