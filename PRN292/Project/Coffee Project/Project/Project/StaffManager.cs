using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Project
{
    public partial class StaffManager : Form
    {

        string path = "C:/Users/Nguyen Quang Anh/Desktop/PRN292/PROJECT/Project/Project/bin/Debug/Avatar/default.png";
        int curEmployee;

        public StaffManager()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;

        }

        public StaffManager(int curEmployee)
        {
            InitializeComponent();
            this.curEmployee = curEmployee;
            WindowState = FormWindowState.Maximized;

        }

        private void lbCurrentDate_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

        }

        public void loadEmployee()
        {
            int count = 1;
            Point p = new Point();
            p.X = 10;
            p.Y = 10;
            flpEmployee.Controls.Clear();
            List<Employee> listEmp = Employee.getAllEmployee();
            foreach (Employee em in listEmp)
            {
                if(em.EmployeeID != curEmployee)
                {
                    usEmployee use = new usEmployee(em, this);

                    use.Location = p;
                    if (count % 7 == 0)
                    {
                        p.X = 10;
                        p.Y += (use.Height + 10);
                    }
                    else
                    {
                        p.X += use.Width + 10;
                    }
                    use.BorderStyle = System.Windows.Forms.BorderStyle.FixedSingle;
                    flpEmployee.Controls.Add(use);
                    count++;
                }
            }
        }

        private void StaffManager_Load(object sender, EventArgs e)
        {
            // Fullscreen window form
            //this.TopMost = true;
            this.FormBorderStyle = FormBorderStyle.None;
            //this.WindowState = FormWindowState.Maximized;

            lbDate.Text = DateTime.Now.ToShortDateString();
            timer1.Start();
            loadEmployee();

            cbRole.SelectedIndex = 1;

        }

        private void tPAddStaff_Click(object sender, EventArgs e)
        {

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
                value = Convert.ToInt32(s.Trim());
                if (s.Length < 10)
                {
                    throw new IndexOutOfRangeException();
                }
            }
            catch (IndexOutOfRangeException)
            {
                MessageBox.Show("Length of phone number must be bigger than or equal to 10!");
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

        public bool isExistAccount(string us)
        {
            if (Employee.isExistUsername(us))
            {
                MessageBox.Show("Username already exists!");
                return true;
            }
            return false;
        }

        private void btAddNew_Click(object sender, EventArgs e)
        {
            string name = "", address = "", gender = "", username = "", password = "", role = "";
            int phone = 0;
            DateTime doj = DateTime.Now;
            DateTime bd;
            double salary = 0;


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
                    if (dtpBD.Value >= doj)
                    {
                        MessageBox.Show("BirthDate can not be larger than the current date!");
                    }
                    else
                    {
                        bd = dtpBD.Value;
                        if (rbMale.Checked)
                        {
                            gender = "Male";
                        }
                        else if (rbFemale.Checked)
                        {
                            gender = "Female";
                        }
                        else
                        {
                            MessageBox.Show("You must choose gender!");
                            return;
                        }
                        if (!checkDouble(tbSalary.Text))
                        {
                            tbSalary.Focus();
                        }
                        else
                        {
                            salary = Convert.ToDouble(tbSalary.Text.Trim());
                            if (!checkPhone(tbPhone.Text.Trim()))
                            {
                                tbPhone.Focus();
                            }
                            else
                            {
                                phone = Convert.ToInt32(tbPhone.Text.Trim());
                                if (tbPassword.Text.Trim() == "")
                                {
                                    password = "1";
                                }
                                else
                                {
                                    password = tbPassword.Text.Trim();
                                }
                                if (!checkString(tbUsername.Text, "Username"))
                                {
                                    tbUsername.Focus();
                                }
                                else
                                {
                                    if (isExistAccount(tbUsername.Text))
                                    {
                                        tbUsername.Focus();
                                    }
                                    else
                                    {
                                        username = tbUsername.Text.Trim();
                                        role = cbRole.SelectedItem.ToString();
                                        Employee.AddFullEmpolyee(name, address, bd, path, phone, salary, doj, gender, username, password, role);
                                        tbID.Text = DataAccess.getMaxEmployeeID().ToString();
                                        loadEmployee();
                                        MessageBox.Show("Add successfull!");
                                    }

                                }
                            }
                        }
                    }
                }
            }
        }

        private void tbSalary_TextChanged(object sender, EventArgs e)
        {

        }

        private void btUpload_Click(object sender, EventArgs e)
        {
            OpenFileDialog oFile = new OpenFileDialog();
            oFile.Filter = "jpg files (*.jpg)|*.jpg|All files (*.*)|*.*";
            oFile.Filter = "png files (*.png)|*.png|All files (*.*)|*.*";
            if (oFile.ShowDialog() == DialogResult.OK)
            {
                path = oFile.FileName;
                Image img = Image.FromFile(path);
                pbAvatar.Image = img;
            }
        }

        private void btReset_Click(object sender, EventArgs e)
        {
            tbID.Text = "";
            tbName.Text = "";
            tbAddress.Text = "";
            dtpBD.Value = DateTime.Now;
            tbPassword.Text = "";
            rbMale.Checked = false;
            rbFemale.Checked = false;
            tbSalary.Text = "";
            tbPhone.Text = "";
            tbUsername.Text = "";
            tbPassword.Text = "";
            cbRole.SelectedIndex = 1;

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            lbTime.Text = DateTime.Now.ToLongTimeString();
        }

        private void btBack_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void btExit_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }
    }
}
