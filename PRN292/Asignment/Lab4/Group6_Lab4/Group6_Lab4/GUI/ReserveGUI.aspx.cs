using Group6_Lab4.DAL;
using Group6_Lab4.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Group6_Lab4.GUI
{
    public partial class Reserve : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                displayButtons(1);
                Calendar1.TodaysDate = DateTime.Now;
                Calendar1.SelectedDate = DateTime.Now;
            }
        }

        protected void btnCheckmember_Click(object sender, EventArgs e)
        {
            DataTable dt = new DataTable();
            DataView dv = new DataView(dt);
            int borrowerNumber;
            try
            {
                borrowerNumber = int.Parse(txtBorrowerNumber.Text);
            }
            catch
            {
                lblError.Text = "Must be an integer!";
                return;
            }
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            if (b == null)
            {
                lblError.Text =  "Borrower doesnt exist!";
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;
            dt = ReserveDAO.GetReserve(int.Parse(txtBorrowerNumber.Text));
            dv = new DataView(dt);
            GridView1.DataSource = dv;
            GridView1.DataBind();
            lblNumber.Text = GridView1.Rows.Count.ToString();
            if (dt.Rows.Count != 0)
            {
                lblError.Text = "You reserved a book!So now you cant!";
     
            }
            else
            {
                lblError.Text = "You can reserve";
 
                displayButtons(2);
            }
        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // to enter member and check Member
                case 1:
                    txtBorrowerNumber.Enabled = true;
                    txtName.Enabled = false;
                    txtBookNumber.Enabled = false;
                    txtTitle.Enabled = false;

                    btnCheckMember.Enabled = true;
                    btnCheckCondition.Enabled = false;
                    btnReserve.Enabled = false;
                    GridView1.Enabled = false;
                    break;
                // to Confirm fine
                case 2:
                    txtBorrowerNumber.Enabled = true;
                    txtName.Enabled = false;
                    txtBookNumber.Enabled = true;
                    txtTitle.Enabled = false;

                    btnCheckMember.Enabled = true;
                    btnCheckCondition.Enabled = true;
                    btnReserve.Enabled = true;
                    GridView1.Enabled = true;
                    break;
                // to Return
                case 3:
                    break;
            }
        }

        protected void btnCheckCondition_Click(object sender, EventArgs e)
        {
            int bbookNumber;
            try
            {
                bbookNumber = int.Parse(txtBookNumber.Text);
            }
            catch
            {
                lblError.Text = "Must be an integer!";
                txtBookNumber.Focus();
                return;
            }

            int checkBookNumber = ReserveDAO.CheckbookNumber(bbookNumber);
            if (checkBookNumber == 0)
            {
               lblError.Text =  "Booknumber doesnt exist!";
                txtBookNumber.Focus();
                return;
            }

            String bookNumber = txtBookNumber.Text;
            int numberofavailableCopy = ReserveDAO.CheckNumberofCopy(bookNumber);
            if (numberofavailableCopy > 0)
            {
                lblError.Text = "Copies is availble!You dont need to reserve";
                return;
            }

            txtTitle.Text = BookDAO.getBookTitlebyId(bbookNumber);
            displayButtons(3);
           lblError.Text = "You can reserve!";
        }

        protected void btnReserve_Click(object sender, EventArgs e)
        {
            Reservation r = new Reservation();
            r.BorrowerNumber = int.Parse(txtBorrowerNumber.Text);
            r.BookNumber = int.Parse(txtBookNumber.Text);
            r.Date = Calendar1.SelectedDate;
            r.Status = "R";
            bool check = ReserveDAO.AddReservation(r);
            if (check)
            {
               lblError.Text = "Reserve successfully!";
                int borrowerNumber = int.Parse(txtBorrowerNumber.Text);
                DataTable dt = ReserveDAO.GetReserve(borrowerNumber);
                GridView1.DataSource = dt;
                GridView1.DataBind();
                lblNumber.Text = GridView1.Rows.Count.ToString();
            }
            else
            {
                lblError.Text = "Reserve not successfully!";
            }
            displayButtons(1);
        }
    }
}