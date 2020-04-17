using ProjectPRN292.DAL;
using ProjectPRN292.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectPRN292.GUI
{
    public partial class StaffGUI : Form
    {
        DataView dv;
        Staff s;
        User u;
        string path;
        string errorPath = "image\\no_photo.jpg";
        public StaffGUI()
        {
            InitializeComponent();
            View();
            DataTable dt = StaffDAO.getRole();
            cbRole.DataSource = dt;
            cbRole.DisplayMember = "Name";
            cbRole.ValueMember = "Id";
            displayButtons(1);
        }

        private void View()
        {
            DataTable dt = StaffDAO.GetDataTable();
            dv = new DataView(dt);
            dataGridView1.DataSource = dv;
            dataGridView1.Columns["Image"].Visible = false;
            dataGridView1.Columns["Username"].Visible = false;
            dataGridView1.Columns["Password"].Visible = false;
            dataGridView1.Columns["RoleId"].Visible = false;
            dataGridView1.Columns["StaffId"].Visible = false;
        }


        private void displayButtons(int state)
        {
            switch (state)
            {
                // Show information
                case 1:
                    txtName.Enabled = false;
                    dateTimePicker1.Enabled = false;
                    txtAddress.Enabled = false;
                    txtPhone.Enabled = false;
                    txtGender.Enabled = false;
                    txtSalary.Enabled = false;
                    dateTimePicker2.Enabled = false;
                    txtUsername.Enabled = false;
                    txtPassword.Enabled = false;
                    cbRole.Enabled = false;


                    btnAdd.Enabled = true;
                    btnAdd.Text = "Add";

                    btnUpdate.Enabled = true;
                    btnUpdate.Text = "Update";

                    btnDelete.Enabled = true;
                    btnUpload.Visible = false;

                    break;

                // Allow to add staff
                case 2:
                    txtName.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    txtAddress.Enabled = true;
                    txtPhone.Enabled = true;
                    txtGender.Enabled = true;
                    txtSalary.Enabled = true;
                    dateTimePicker2.Enabled = true;
                    txtUsername.Enabled = true;
                    txtPassword.Enabled = true;
                    cbRole.Enabled = true;
                    txtName.Focus();

                    btnAdd.Enabled = true;
                    btnAdd.Text = "Save";

                    btnDelete.Visible = false;
                    btnUpdate.Visible = false;
                    btnUpdate.Enabled = false;
                    btnUpdate.Text = "Update";

                    btnDelete.Enabled = false;
                    btnUpload.Visible = true;

                    break;

                //Allow to update staff
                case 3:
                    txtName.Enabled = true;
                    dateTimePicker1.Enabled = true;
                    txtAddress.Enabled = true;
                    txtPhone.Enabled = true;
                    txtGender.Enabled = true;
                    txtSalary.Enabled = true;
                    dateTimePicker2.Enabled = true;
                    txtUsername.Enabled = true;
                    txtPassword.Enabled = true;
                    cbRole.Enabled = true;
                    txtName.Focus();

                    btnAdd.Enabled = false;
                    btnAdd.Text = "Add";

                    btnUpdate.Enabled = true;
                    btnUpdate.Text = "Save";

                    btnDelete.Enabled = false;
                    btnUpload.Visible = true;

                    break;
            }
        }

        private bool isSelected()
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("You must select a staff in the list of staff!");
                return false;
            }
            if (dataGridView1.SelectedRows[0].Cells["Id"].Value == null)
            {
                MessageBox.Show("You must select a staff in the list of staff!");
                return false;
            }
            return true;
        }

        private void displayStaff()
        {

            txtStaffId.Text = s.Id.ToString();
            txtName.Text = s.Name;
            txtGender.Text = s.Gender;
            dateTimePicker1.Value = DateTime.Parse(s.Dob.ToString());
            txtAddress.Text = s.Address;
            txtPhone.Text = s.PhoneNumber;
            dateTimePicker2.Value = DateTime.Parse(s.DateOJoin.ToString());
            txtSalary.Text = s.Salary.ToString();
            txtUsername.Text = u.Username;
            txtPassword.Text = u.Password;
            cbRole.SelectedValue = u.RoleId.ToString();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            pictureBox1.Image = null;
            if (btn.Text == "Add")
            {
                s = new Staff(StaffDAO.getIdMax() + 1, "", "", DateTime.Now, "", "", DateTime.Now, 0, "");
                u = new User(0, "", "", 0, 0);
                displayStaff();
                cbRole.SelectedValue = 0;
                displayButtons(2);
            }
            else
            {
                txtStaffId.Text = (StaffDAO.getIdMax() + 1).ToString();
                s = new Staff(int.Parse(txtStaffId.Text), txtName.Text, txtGender.Text, DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")),
                    txtAddress.Text, txtPhone.Text, DateTime.Parse(dateTimePicker2.Value.ToString("dd/MM/yyyy")), float.Parse(txtSalary.Text), path);
                StaffDAO.Insert(s);

                u = new User(0, txtUsername.Text, txtPassword.Text, int.Parse(cbRole.SelectedValue.ToString()), s.Id);
                UserDAO.Insert(u);


                View();

                displayButtons(1);
            }
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Update")
            {
                if (!isSelected()) return;
                displayButtons(3);
            }
            else
            {
                try
                {
                    if (path == null)
                    {
                        s = new Staff(int.Parse(dataGridView1.SelectedRows[0].Cells["Id"].Value.ToString()), txtName.Text, txtGender.Text,
                        DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")), txtAddress.Text, txtPhone.Text,
                        DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")), float.Parse(txtSalary.Text), dataGridView1.SelectedRows[0].Cells["Image"].Value.ToString());
                    }
                    else
                    {
                        s = new Staff(int.Parse(dataGridView1.SelectedRows[0].Cells["Id"].Value.ToString()), txtName.Text, txtGender.Text,
                        DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")), txtAddress.Text, txtPhone.Text,
                        DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")), float.Parse(txtSalary.Text), path);
                    }
                }
                catch
                {
                    s = new Staff(int.Parse(dataGridView1.SelectedRows[0].Cells["Id"].Value.ToString()), txtName.Text, txtGender.Text,
                       DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")), txtAddress.Text, txtPhone.Text,
                       DateTime.Parse(dateTimePicker1.Value.ToString("dd/MM/yyyy")), float.Parse(txtSalary.Text), errorPath);
                }


                StaffDAO.Update(s);
                u = new User(0, txtUsername.Text, txtPassword.Text, int.Parse(cbRole.SelectedValue.ToString()), int.Parse(dataGridView1.SelectedRows[0].Cells["Id"].Value.ToString()));
                UserDAO.Update(u);
                View();
                displayButtons(1);
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (!isSelected()) return;

            int id = (int)dataGridView1.SelectedRows[0].Cells["Id"].Value;
            int staffId = (int)dataGridView1.SelectedRows[0].Cells["StaffId"].Value;
            DialogResult dr = MessageBox.Show(String.Format("Do You Want to Delete this Staff {0}", id), "Confirm deteting", MessageBoxButtons.YesNo);
            if (dr == DialogResult.No) return;


            UserDAO.Delete(staffId);
            StaffDAO.Delete(id);

            DataTable dt = dv.Table;
            DataRow[] result = dt.Select("Id = " + id);
            result[0].Delete();
        }

        private void btnUpload_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Title = "Open image";
            ofd.InitialDirectory = @"C:\";
            ofd.Filter = "Image|*.jpg;*.jpeg;*.png;*.gif;*bmp";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.Image = Image.FromFile(ofd.FileName);
                path = ofd.FileName;
            }
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            btnUpload.Visible = false;
            txtStaffId.Text = dataGridView1.Rows[e.RowIndex].Cells["Id"].Value.ToString();
            txtName.Text = dataGridView1.Rows[e.RowIndex].Cells["name"].Value.ToString();
            txtGender.Text = dataGridView1.Rows[e.RowIndex].Cells["gender"].Value.ToString();
            dateTimePicker1.Value = DateTime.Parse(dataGridView1.Rows[e.RowIndex].Cells["Dob"].Value.ToString());
            txtAddress.Text = dataGridView1.Rows[e.RowIndex].Cells["Address"].Value.ToString();
            txtPhone.Text = dataGridView1.Rows[e.RowIndex].Cells["PhoneNumber"].Value.ToString();
            dateTimePicker2.Value = DateTime.Parse(dataGridView1.Rows[e.RowIndex].Cells["Date_of_join"].Value.ToString());
            txtSalary.Text = dataGridView1.Rows[e.RowIndex].Cells["Salary"].Value.ToString();
            txtUsername.Text = dataGridView1.Rows[e.RowIndex].Cells["Username"].Value.ToString();
            txtPassword.Text = dataGridView1.Rows[e.RowIndex].Cells["Password"].Value.ToString();
            cbRole.SelectedValue = dataGridView1.Rows[e.RowIndex].Cells["RoleId"].Value.ToString();
            string image = dataGridView1.Rows[e.RowIndex].Cells["Image"].Value.ToString();
            try
            {
                pictureBox1.Image = Image.FromFile(image);
            }
            catch
            {
                pictureBox1.Image = Image.FromFile(errorPath);
            }
        }
    }
}
