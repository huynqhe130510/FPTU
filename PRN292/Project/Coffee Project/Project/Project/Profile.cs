using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data;

namespace Project
{
    public partial class Profile : Form
    {
        Employee emp;
        public Profile()
        {
            InitializeComponent();
            
        }

        public Profile(int curEmployee)
        {
            InitializeComponent();
            emp = Employee.getEmployeeByID(curEmployee);
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            
            timer1.Start();

            
            tbID.Text = emp.EmployeeID.ToString();
            tbName.Text = emp.Name.Trim();
            tbAddress.Text = emp.Address;
            tbBirthDate.Text = emp.BirthDate.ToShortDateString();
            string gender = emp.Gender;


            if (gender.Trim().Equals("Male"))
            {
                rbMale.Checked = true;
                rbFemale.Checked = false;
                rbFemale.Enabled = false;
            }
            else
            {
                rbFemale.Checked = true;
                rbMale.Checked = false;
                rbMale.Enabled = false;
            }
            tbSalary.Text = emp.Salary.ToString().Trim();
            tbPhone.Text = emp.Phone.ToString().Trim();
            dtpDateOfJoin.Value = emp.DateOfJoin;
            tbUsername.Text = emp.UserName.Trim();
            tbPassword.Text = emp.Password.Trim();
            tbRole.Text = emp.Role.Trim();
            Image img = Image.FromFile(emp.Avatar);
            pbAvatar.Image = img;
        }

        private void lbEID_Click(object sender, EventArgs e)
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

        public bool checkPhone(String s)
        {
            int value = 0;
            if (!checkString(s, "Phone"))
            {
                return false;
            }
            try
            {
                value = Convert.ToInt32(s);
                if (value <= 10)
                {
                    throw new IndexOutOfRangeException();
                }
            }
            catch (IndexOutOfRangeException e)
            {
                MessageBox.Show("Phone number must be bigger than or equal to 10!");
                return false;
            }
            catch (Exception)
            {
                MessageBox.Show("Phone number is a integer!");
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

        private void btSave_Click(object sender, EventArgs e)
        {
            if (btSave.Visible)
            {
                string name = "", address = "", password = "", role = "";
                int phone = 0;
                DateTime doj = dtpDateOfJoin.Value;
                int eid = Convert.ToInt32(tbID.Text);

                if (!checkString(tbName.Text, "Name"))
                {
                    tbName.Focus();
                }
                else
                {
                    name = tbName.Text.Trim();
                    if (!checkString(tbAddress.Text, "Address"))
                    {
                        tbAddress.Focus();
                    }
                    else
                    {
                        address = tbAddress.Text.Trim();
                        if (!checkPhone(tbPhone.Text))
                        {
                            tbPhone.Focus();
                        }
                        else
                        {
                            phone = Convert.ToInt32(tbPhone.Text);
                            if (!checkString(tbPassword.Text, "Password"))
                            {
                                tbPassword.Focus();
                            }
                            else
                            {
                                password = tbPassword.Text.Trim();
                            }

                        }
                    }
                }

                Employee.UpdateEmployee(eid, name, address, phone, doj, password);
                MessageBox.Show("Update successfull!");
            }

        }

        private void lbRole_Click(object sender, EventArgs e)
        {

        }

        private void bUpdateInfo_Click(object sender, EventArgs e)
        {
            tbName.ReadOnly = false;
            tbName.Focus();
            tbAddress.ReadOnly = false;
            tbPhone.ReadOnly = false;
            tbPassword.ReadOnly = false;
            btSave.Visible = true;
            btCancel.Visible = true;
        }

        private void btCancel_Click(object sender, EventArgs e)
        {
            tbName.Text = emp.Name.Trim();
            tbAddress.Text = emp.Address;
            tbPhone.Text = emp.Phone.ToString().Trim();
            tbPassword.Text = emp.Password.Trim();

            tbName.ReadOnly = true;
            tbAddress.ReadOnly = true;
            tbPhone.ReadOnly = true;
            tbPassword.ReadOnly = true;
            btSave.Visible = false;
            btCancel.Visible = false;

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lbDate.Text = DateTime.Now.ToShortDateString();
            lbTime.Text = DateTime.Now.ToLongTimeString();
        }

        private void btUpload_Click(object sender, EventArgs e)
        {
            int eid = Convert.ToInt32(tbID.Text);
            OpenFileDialog oFile = new OpenFileDialog();
            oFile.Filter = "jpg files (*.jpg)|*.jpg|All files (*.*)|*.*";
            oFile.Filter = "png files (*.png)|*.png|All files (*.*)|*.*";
            if (oFile.ShowDialog() == DialogResult.OK)
            {
                string path = oFile.FileName;
                Employee.UpdateAvatar(eid, path);
                Image img = Image.FromFile(path);
                pbAvatar.Image = img;
            }
        }

        private void btBack_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
