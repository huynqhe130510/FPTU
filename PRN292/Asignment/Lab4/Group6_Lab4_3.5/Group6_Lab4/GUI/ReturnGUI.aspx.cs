using Group6_Lab4.DAL;
using Group6_Lab4.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Globalization;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Group6_Lab4.GUI
{
    public partial class Return : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                displayButtons(1);
            }
        }

        protected void btnMember_Click(object sender, EventArgs e)
        {
            int borrowerNumber;
            try
            {
                borrowerNumber = int.Parse(txtBorrowerNumber.Text);
            }
            catch
            {
                lblError.Text = "Borrower number must be a integer!";
                txtBorrowerNumber.Focus();
                return;
            }
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            if (b == null)
            {
                lblError.Text = String.Format("Borrower number {0} does't exist!", borrowerNumber);
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;
            View();
            displayButtons(2);
        }

        private void View()
        {
            DataTable dt = CirculatedCopyDAO.GetBorrowedCopy(int.Parse(txtBorrowerNumber.Text));
            GridView1.DataSource = dt;
            GridView1.DataBind();
            lblNumOfBorCopies.Text = dt.Rows.Count.ToString();
        }

        private bool isSelected()
        {
            if (GridView1.Rows.Count == 0)
            {
                lblError.Text = "Don't have any book to return!";
                return false;
            }
            if (GridView1.Rows[0].Cells[1].Text == null)
            {
                lblError.Text = "You must select a book in the list to return!";
                return false;

            }

            return true;
        }

        protected void btnFine_Click(object sender, EventArgs e)
        {
            if (!isSelected()) return;
            double fine = 0;
            if (((int)((Calendar1.SelectedDate - Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text)).TotalDays)) < 0)
            {
                fine = 0;
            }
            else
            {
                fine += (int)((Calendar1.SelectedDate - Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text)).TotalDays);
            }

            txtFineAmount.Text = fine.ToString("C2");

            displayButtons(3);
        }

        private void displayButtons(int state)
        {
            switch (state)
            {
                // to enter member and check Member
                case 1:
                    txtBorrowerNumber.Enabled = true;
                    btnMember.Enabled = true;

                    GridView1.Enabled = false;
                    btnFine.Enabled = false;

                    btnReturn.Enabled = false;
                    break;
                // to Confirm fine
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    GridView1.Enabled = true;
                    btnFine.Enabled = true;

                    btnReturn.Enabled = false;

                    break;
                // to Return
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnFine.Enabled = false;
                    GridView1.Enabled = false;

                    btnReturn.Enabled = true;
                    break;

            }

        }

        protected void btnReturn_Click(object sender, EventArgs e)
        {
            double fine, fineTotal = 0;
            try
            {
                Calendar1.SelectedDate.ToString("dd/MM/yyyy");
            }
            catch
            {
                lblError.Text = "Format of date must be 'dd/MM/yyyy'!";
                return;
            }

            CirculatedCopy cc;

            
                fine = 0;
                if (DateTime.ParseExact(Calendar1.SelectedDate.ToString("dd/MM/yyyy"), "dd/MM/yyyy", null) > Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text))
                    fine = (int)(DateTime.Now.AddDays(20) - Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text)).TotalDays;

                fineTotal += fine;

                cc = new CirculatedCopy(int.Parse(GridView1.SelectedRow.Cells[2].Text), int.Parse(GridView1.SelectedRow.Cells[3].Text),
                    GridView1.SelectedRow.Cells[4].Text, GridView1.SelectedRow.Cells[5].Text);
                cc.Id = int.Parse(GridView1.SelectedRow.Cells[1].Text);
                cc.ReturnedDate = DateTime.ParseExact(Calendar1.SelectedDate.ToString("dd/MM/yyyy"), "dd/MM/yyyy", null);
                cc.FineAmount = fine;

                doReturn(cc);

            


            View();

            displayButtons(1);
        }

        private void doReturn(CirculatedCopy cc)
        {
            CirculatedCopyDAO.Update(cc);

            Copy c = CopyDAO.GetCopy(cc.CopyNumber);

            // update type = 'A' in copy
            c.Type = "A";
            CopyDAO.Update(c);

        }
    }
}