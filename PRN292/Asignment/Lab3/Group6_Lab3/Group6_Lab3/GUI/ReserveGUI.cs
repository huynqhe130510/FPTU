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
    public partial class ReserveGUI : Form
    {
        Reservation r;
        public ReserveGUI()
        {
            InitializeComponent();
            txtDate.Text = DateTime.Now.ToString("dd/MM/yyyy");
            displayButtons(1);
        }

        private void btnMember_Click(object sender, EventArgs e)
        {
            int borrowerNumber;
            try
            {
                borrowerNumber = int.Parse(txtBorrowerNumber.Text);
            }
            catch
            {
                MessageBox.Show("Borrower number must be a integer!");
                txtBorrowerNumber.Focus();
                return;
            }
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            r = ReserveDAO.GetReservation(borrowerNumber);
            if (r == null)
            {
                MessageBox.Show(String.Format("Borrower number {0} does't exist!", borrowerNumber));
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;

            View();
            int count = dataGridView1.Rows.Count;
            if(count == 0)
            {
                displayButtons(2);
            }
            else
            {
                foreach (DataGridViewRow dr in dataGridView1.Rows)
                {
                    if (int.Parse(dr.Cells["borrowerNumber"].Value.ToString()) == borrowerNumber)
                    {
                        if (dr.Cells["status"].Value.ToString() == "R")
                        {
                            displayButtons(1);
                        }
                        else
                        {
                            displayButtons(2);
                        }

                    }
                }
            }
            
        }

        private void View()
        {
            DataTable dt = ReserveDAO.GetReserve(int.Parse(txtBorrowerNumber.Text));
            dataGridView1.DataSource = dt;
            lblNumberReservedBook.Text = dt.Rows.Count.ToString();
            this.dataGridView1.Columns["date"].DefaultCellStyle.Format = "dd/MM/yyyy";
        }

        private void btnCondition_Click(object sender, EventArgs e)
        {
            int bookNumber;
            try
            {
                bookNumber = int.Parse(txtBookNumber.Text);
            }
            catch
            {
                MessageBox.Show("Book number must be a integer!");
                txtBookNumber.Focus();
                return;
            }
            List<Copy> list = CopyDAO.GetCopyByBookNumber(bookNumber);
            int count = 0;
            for (int i = 0; i < list.Count; i++)
            {
                if(list[i].Type == "B")
                {
                    count++;
                }
            }
            if(count == list.Count)
            {
                displayButtons(3);
            }
            else
            {
                MessageBox.Show("You can not reserve this book !");
            }
        }

        private void displayButtons(int state)
        {
            switch (state)
            {
                case 1:
                    txtBorrowerNumber.Enabled = true;
                    txtName.Enabled = false;
                    txtBookNumber.Enabled = false;
                    txtDate.Enabled = false;

                    btnMember.Enabled = true;
                    btnCondition.Enabled = false;
                    btnReserve.Enabled = false;
                    break;
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    txtName.Enabled = false;
                    txtBookNumber.Enabled = true;
                    txtDate.Enabled = false;

                    btnMember.Enabled = false;
                    btnCondition.Enabled = true;
                    btnReserve.Enabled = false;
                    break;
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    txtName.Enabled = false;
                    txtBookNumber.Enabled = false;
                    txtDate.Enabled = true;

                    btnMember.Enabled = false;
                    btnCondition.Enabled = false;
                    btnReserve.Enabled = true;
                    break;
            }
        }

        private void btnReserve_Click(object sender, EventArgs e)
        {
            Reservation reservation = new Reservation();
            try
            {
                DateTime.ParseExact(txtDate.Text, "dd/MM/yyyy", null);
            }
            catch
            {
                MessageBox.Show("Format of date must be 'dd/MM/yyyy'!");
                return;
            }
            reservation.BorrowerNumber = int.Parse(txtBorrowerNumber.Text);
            reservation.BookNumber = int.Parse(txtBookNumber.Text);
            reservation.Date = DateTime.ParseExact(txtDate.Text, "dd/MM/yyyy", null);
            reservation.Status = "R";
            ReserveDAO.AddReservation(reservation);
            View();
            displayButtons(1);
        }
    }
}
