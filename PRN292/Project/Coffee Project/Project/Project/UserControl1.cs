using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project
{
    public partial class usEmployee : UserControl
    {
        StaffManager sm;
        Employee emp;
        bool isDone;

        public usEmployee()
        {
            InitializeComponent();
        }

        public usEmployee(Employee emp, StaffManager sm)
        {
            InitializeComponent();
            this.emp = emp;
            this.sm = sm;
            isDone = true;
        }

        private void usEmployee_Load(object sender, EventArgs e)
        {
            Image img = Image.FromFile(emp.Avatar);
            pbAvatar.Image = img;

            tbID.Text = emp.EmployeeID.ToString();
            tbName.Text = emp.Name;
            tbPhone.Text = emp.Phone.ToString();
            cbRole.Visible = false;
            tbRole.Text = emp.Role;
            tbSalary.Text = emp.Salary.ToString();
        }

        private void lbPos_Click(object sender, EventArgs e)
        {

        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        public bool checkString(string s, string mes)
        {
            if (s.Trim() == "")
            {
                MessageBox.Show(mes + " is not empty!");
                return false;
            }
            return true;
        }

        public bool checkDouble(String s)
        {
            double value = 0;
            if (!checkString(s, "Salary"))
            {
                return false;
            }
            try
            {
                value = Convert.ToDouble(s);
                if (value < 0)
                {
                    throw new IndexOutOfRangeException();
                }
            }
            catch (IndexOutOfRangeException e)
            {
                MessageBox.Show("Salary is not smaller than 0!");
                return false;
            }
            catch (Exception)
            {
                MessageBox.Show("Salary is a number!");
                return false;
            }

            return true;
        }



        private void btUpdataInfo_Click(object sender, EventArgs e)
        {
            //update
            if (isDone)
            {
                tbRole.Visible = false;
                cbRole.Visible = true;
                cbRole.SelectedItem = emp.Role;
                tbSalary.ReadOnly = false;
                btUpdataInfo.Text = "Done";
                isDone = false;

            }
            else
            {
                if (MessageBox.Show("Do you want to update?", "cofirm", MessageBoxButtons.YesNo) == DialogResult.Yes)
                {
                    if (!checkDouble(tbSalary.Text.Trim()))
                    {
                        tbSalary.Focus();
                    }
                    else
                    {
                        int eid = emp.EmployeeID;
                        double salary = Convert.ToDouble(tbSalary.Text.Trim());
                        string role = cbRole.SelectedItem.ToString();
                        Employee.UpdateSalaryAndRole(eid, salary, role);

                    }
                }
                else
                {
                    tbRole.Visible = true;
                    cbRole.Visible = false;
                    tbSalary.ReadOnly = true;
                    btUpdataInfo.Text = "Update Info";
                }
                tbRole.Visible = true;
                cbRole.Visible = false;
                tbSalary.ReadOnly = true;
                btUpdataInfo.Text = "Update Info";
                isDone = true;

            }


        }

        private void btViewInfo_Click(object sender, EventArgs e)
        {
            Profile pf = new Profile(emp.EmployeeID);
            pf.Show();
        }

        private void btDelete_Click(object sender, EventArgs e)
        {
            if (MessageBox.Show("Do you want to delete this employee?", "cofirm", MessageBoxButtons.YesNo) == DialogResult.Yes)
            {
                Employee.DeleteEmployee(emp.EmployeeID);
                sm.loadEmployee();
            }
        }
    }
}
