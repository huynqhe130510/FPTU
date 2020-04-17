using Group6_Lab3.DAL;
using Group6_Lab3.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Group6_Lab3.GUI
{
    public partial class MemberGUI : Form
    {
        DataView dv;
        Borrower b;

        public MemberGUI()
        {
            InitializeComponent();

            View();

            displayButtons(1);
        }

        // get borrowers and display
        private void View()
        {
            DataTable dt = BorrowerDAO.GetDataTable();
            dv = new DataView(dt);
            dataGridView1.DataSource = dv;
        }

        // filter the list by borrowerNumber
        private void btnFilter_Click(object sender, EventArgs e)
        {
            int borrowerNumber;
            try
            {
                borrowerNumber = int.Parse(txtBorrowNumber.Text);
            }
            catch
            {
                MessageBox.Show("Borrow number must be integer (empty for all borrowers)!");
                if (txtBorrowNumber.Text != "") return;
                else borrowerNumber = -1;
            }

            if (borrowerNumber > -1) dv.RowFilter = "borrowerNumber = " + borrowerNumber.ToString();

        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Add")
            {
                b = new Borrower(BorrowerDAO.GetBorrowNumberMax() + 1, "", "", "", "", "");
                displayBorrower();

                displayButtons(2);
            }
            else
            {
                b.Name = txtName.Text;
                b.Sex = txtSex.Text;
                b.Address = txtAddress.Text;
                b.Telephone = txtTelephone.Text;
                b.Email = txtEmail.Text;

                BorrowerDAO.Insert(b);

                // Add to DataTable
                DataTable dt = dv.Table;
                DataRow newRow = dt.NewRow();
                newRow["borrowerNumber"] = b.BorrowerNumber;
                newRow["name"] = b.Name;
                newRow["sex"] = b.Sex;
                newRow["address"] = b.Address;
                newRow["telephone"] = b.Telephone;
                newRow["email"] = b.Email;
                dt.Rows.Add(newRow);
                dv.RowFilter = "";

                displayButtons(1);
            }
        }

        private void displayButtons(int state)
        {
            switch (state)
            {
                // allow to filter/Add/Edit/Delete borrower
                case 1:
                    txtBorrowNumber.Enabled = true;
                    txtBorrowNumber.Focus();

                    txtName.Enabled = false;
                    txtSex.Enabled = false;
                    txtAddress.Enabled = false;
                    txtTelephone.Enabled = false;
                    txtEmail.Enabled = false;


                    btnFilter.Enabled = true;

                    btnAdd.Text = "Add";
                    btnAdd.Enabled = true;

                    btnEdit.Text = "Edit";
                    btnEdit.Enabled = true;

                    btnDelete.Enabled = true;
                    break;

                // Allow to add a borrower
                case 2:
                    txtBorrowNumber.Enabled = false;
                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtAddress.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtEmail.Enabled = true;
                    txtName.Focus();

                    btnAdd.Text = "Save";
                    btnAdd.Enabled = true;

                    btnFilter.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    break;

                // Allow to edit a borrower
                case 3:

                    txtBorrowNumber.Enabled = false;
                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtAddress.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtEmail.Enabled = true;
                    txtName.Focus();

                    btnEdit.Text = "Save";
                    btnEdit.Enabled = true;

                    btnFilter.Enabled = false;
                    btnAdd.Enabled = false;
                    btnDelete.Enabled = false;
                    break;

            }
        }

        private void displayBorrower()
        {
            txtBorrowNumber.Text = b.BorrowerNumber.ToString();
            txtName.Text = b.Name;
            txtAddress.Text = b.Address;
            txtSex.Text = b.Sex;
            txtTelephone.Text = b.Telephone;
            txtEmail.Text = b.Email;
        }


        private void btnEdit_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Edit")
            {
                if (!isSelected()) return;

                txtBorrowNumber.Text = dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value.ToString();

                txtName.Text = dataGridView1.SelectedRows[0].Cells["name"].Value.ToString();
                txtAddress.Text = dataGridView1.SelectedRows[0].Cells["address"].Value.ToString();
                txtSex.Text = dataGridView1.SelectedRows[0].Cells["sex"].Value.ToString();
                txtTelephone.Text = dataGridView1.SelectedRows[0].Cells["telephone"].Value.ToString();
                txtEmail.Text = dataGridView1.SelectedRows[0].Cells["email"].Value.ToString();

                displayButtons(3);

            }
            else
            {
                b = new Borrower(int.Parse(txtBorrowNumber.Text), txtName.Text, txtSex.Text, txtAddress.Text, txtTelephone.Text, txtEmail.Text);
                BorrowerDAO.Update(b);

                // Update in DataTable
                DataTable dt = dv.Table;
                DataRow[] result = dt.Select("borrowerNumber = " + b.BorrowerNumber);
                DataRow row = result[0];
                row["name"] = b.Name;
                row["sex"] = b.Sex;
                row["address"] = b.Address;
                row["telephone"] = b.Telephone;
                row["email"] = b.Email;
                dv.RowFilter = "";

                displayButtons(1);
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (!isSelected()) return;

            int borrowerNumber = (int)dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value;
            DialogResult dr = MessageBox.Show(String.Format("Do you want to delete this borrower number {0}?", borrowerNumber), "Confirm deteting", MessageBoxButtons.YesNo);
            if (dr == DialogResult.No) return;

            BorrowerDAO.Delete(borrowerNumber);

            // Delete in DataTable
            DataTable dt = dv.Table;
            DataRow[] result = dt.Select("borrowerNumber = " + borrowerNumber);
            result[0].Delete();


        }

        private bool isSelected()
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("You must select a borrower in the list of borrowers!");
                return false;
            }
            if (dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value == null)
            {
                MessageBox.Show("You must select a borrower in the list of borrowers!");
                return false;
            }
            return true;
        }
        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            txtBorrowNumber.Text = dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value.ToString();

            txtName.Text = dataGridView1.SelectedRows[0].Cells["name"].Value.ToString();
            txtAddress.Text = dataGridView1.SelectedRows[0].Cells["address"].Value.ToString();
            txtSex.Text = dataGridView1.SelectedRows[0].Cells["sex"].Value.ToString();
            txtTelephone.Text = dataGridView1.SelectedRows[0].Cells["telephone"].Value.ToString();
            txtEmail.Text = dataGridView1.SelectedRows[0].Cells["email"].Value.ToString();
        }
    }
}
