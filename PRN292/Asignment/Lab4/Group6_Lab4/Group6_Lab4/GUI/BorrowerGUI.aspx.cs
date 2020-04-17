using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Group6_Lab4.DAL;
using Group6_Lab4.DTL;

namespace Group6_Lab4.GUI
{
    public partial class BorrowerGUI : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GridView1_DataBound(object sender, EventArgs e)
        {
            lblNoOfMember.Text = GridView1.Rows.Count.ToString();
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Session["borrowerNumber"] = GridView1.SelectedRow.Cells[1].Text;
            txtName.Text = GridView1.SelectedRow.Cells[2].Text;
            txtSex.Text = GridView1.SelectedRow.Cells[3].Text;
            txtAddress.Text = GridView1.SelectedRow.Cells[4].Text;
            txtTelephone.Text = GridView1.SelectedRow.Cells[5].Text;
            txtEmail.Text = GridView1.SelectedRow.Cells[6].Text;
        }

        private void displayButtons(int state)
        {
            switch (state)
            {
                // View
                case 1:

                    txtAddress.Enabled = false;
                    txtEmail.Enabled = false;
                    txtName.Enabled = false;
                    txtSex.Enabled = false;
                    txtTelephone.Enabled = false;

                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;

                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;

                // Adding or editing
                case 2:
                    txtAddress.Enabled = true;
                    txtEmail.Enabled = true;
                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtName.Focus();

                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;

                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;

                    break;

            }
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            Session["add"] = 1;
            displayButtons(2);
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow == null)
            {
                lblError.Text = "Error: No a borrower is selected!";
                return;
            }
            Session["add"] = 2;
            displayButtons(2);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            int add = (int)Session["add"];
            Borrower b = new Borrower();
            b.Name = txtName.Text;
            if (txtSex.Text.Equals("M") || txtSex.Text.Equals("F"))
                b.Sex = txtSex.Text;
            else
            {
                lblError.Text = "Sex must be M or F";
            }
            b.Address = txtAddress.Text;
            b.Telephone = txtTelephone.Text;
            b.Email = txtEmail.Text;

            if (add == 1)
            {
                b.BorrowerNumber = BorrowerDAO.GetBorrowNumberMax() + 1;
                BorrowerDAO.Insert(b);
            }
            else
            {
                b.BorrowerNumber = int.Parse(Session["borrowerNumber"].ToString());
                BorrowerDAO.Update(b);
            }
            ObjectDataSource1.Select();
            GridView1.DataBind();
        }
    }
}