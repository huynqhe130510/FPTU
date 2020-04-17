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
    public partial class Borrow : System.Web.UI.Page
    {
        Copy c;
        Reservation r;

        enum errorBorrow
        {
            OK,
            Connect,
            CopyNotExist,
            CopyReferenced,
            CopyBorrowed,
            CopyReserved
        };
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                displayButtons(1);
                lblDate.Text = DateTime.Now.ToString("dd/MM/yyyy");
                txtDueDate.Text = DateTime.Parse(lblDate.Text).AddDays(14).ToString("dd/MM/yyyy");
            }
            lblError.Text = "";
        }


        protected void btnCheckBorrower_Click(object sender, EventArgs e)
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

            if (GridView1.Rows.Count >= 5)
            {
                lblError.Text = "You borrowed 5 books, so you can't borrow any more!";
                txtBorrowerNumber.Focus();
                return;
            }

            displayButtons(2);

            r = null;
            c = null;
        }

        protected void btnCheckCondition_Click(object sender, EventArgs e)
        {
            int copyNumber;
            try
            {
                copyNumber = int.Parse(txtCopyNumber.Text);
            }
            catch
            {
                lblError.Text = "Copy number must be a integer!";
                txtCopyNumber.Focus();
                return;
            }

            errorBorrow error = checkCondition(int.Parse(txtBorrowerNumber.Text), int.Parse(txtCopyNumber.Text), out c, out r);
            string str = "";
            switch (error)
            {
                case errorBorrow.CopyNotExist:
                    str = "No this copy number, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.CopyReferenced:
                    str = "It is referenced, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.CopyBorrowed:
                    str = "It is borrwed, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.CopyReserved:
                    str = "It is reserved by other, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.Connect:
                    str = "Can't connect to Database, so you can't borrow!";
                    break;

            }


            if (str != "")
            {
                lblError.Text = str;
                return;
            }

            displayButtons(3);
        }

        private errorBorrow checkCondition(int borrowerNumber, int copyNumber, out Copy c, out Reservation r)
        {
            c = null;
            r = null;


            c = CopyDAO.GetCopy(copyNumber);
            if (c == null) return errorBorrow.CopyNotExist;
            if (c.Type == "R") return errorBorrow.CopyReferenced;
            if (c.Type == "B") return errorBorrow.CopyBorrowed;

            // Check if this book is reserved by others and you are not at the first of the reservation list
            int bookNumber = c.BookNumber;
            r = ReserveDAO.GetFirstReservation(bookNumber);
            if (r.Status != null && r.BorrowerNumber != borrowerNumber) return errorBorrow.CopyReserved;

            return errorBorrow.OK;

        }

        protected void btnBorrow_Click(object sender, EventArgs e)
        {
            try
            {
                DateTime.ParseExact(lblDate.Text, "dd/MM/yyyy", null);
            }
            catch
            {
                lblError.Text = "Format of date is not valid!";
                return;
            }

            DateTime borrowedDate = DateTime.ParseExact(lblDate.Text, "dd/MM/yyyy", null);
            DateTime dueDate = DateTime.ParseExact(txtDueDate.Text, "dd/MM/yyyy", null);
            CirculatedCopy cc = new CirculatedCopy(int.Parse(txtCopyNumber.Text), int.Parse(txtBorrowerNumber.Text),
                borrowedDate.ToString("dd/MM/yyyy"), dueDate.ToString("dd/MM/yyyy"));


            borrow(cc, c, r);

            View();
            displayButtons(1);
        }

        private void borrow(CirculatedCopy cc, Copy c, Reservation r)
        {
            // Insert borrow record
            if (cc == null) return;
            CirculatedCopyDAO.Insert(cc);

            // update type = 'B' at Copy
            c = CopyDAO.GetCopy(int.Parse(txtCopyNumber.Text));
            if (c == null) return;
            c.Type = "B";
            CopyDAO.Update(c);


            // update status = 'A' at Reservation
            r = ReserveDAO.GetFirstReservation(ReserveDAO.getBookNumberByCopyNumber(int.Parse(txtCopyNumber.Text)));
            if (r.Status == null) return;
            r.Status = "A";
            ReserveDAO.Update(r);
        }

        private void displayButtons(int state)
        {
            switch (state)
            {
                // View
                case 1:
                    txtCopyNumber.Enabled = false;
                    btnCheckCondition.Enabled = false;
                    Calendar1.Enabled = false;
                    txtDueDate.Enabled = false;
                    btnBorrow.Enabled = false;
                    break;

                // Adding or editing
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnCheckCondition.Enabled = false;

                    txtCopyNumber.Enabled = true;
                    btnCheckCondition.Enabled = true;
                    break;
                case 3:
                    Calendar1.Enabled = true;
                    btnBorrow.Enabled = true;
                    txtName.Enabled = false;
                    txtCopyNumber.Enabled = false;
                    btnCheckCondition.Enabled = false;
                    btnCheckMember.Enabled = false;
                    break;
            }

        }
        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            lblDate.Text = Calendar1.SelectedDate.ToString("dd/MM/yyyy");
        }

        private void View()
        {
            DataTable dt = CirculatedCopyDAO.GetBorrowedCopy(int.Parse(txtBorrowerNumber.Text));
            GridView1.DataSource = dt;
            GridView1.DataBind();

            lblNumber.Text = dt.Rows.Count.ToString();
        }
    }
}