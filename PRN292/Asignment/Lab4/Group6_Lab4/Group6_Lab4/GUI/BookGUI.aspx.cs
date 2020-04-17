using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using Group6_Lab4.DAL;
using Group6_Lab4.DTL;

namespace Group6_Lab4.GUI
{
    public partial class BookGUI : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void GridView1_DataBound(object sender, EventArgs e)
        {
            lblNumberOfBooks.Text = GridView1.Rows.Count.ToString();
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Session["bookNumber"] = GridView1.SelectedRow.Cells[1].Text;
            txtTitle.Text = GridView1.SelectedRow.Cells[2].Text;
            txtAuthors.Text = GridView1.SelectedRow.Cells[3].Text;
            txtPublisher.Text = GridView1.SelectedRow.Cells[4].Text;
        }

        private void displayButtons(int state)
        {
            switch (state)
            {
                // View
                case 1:

                    txtTitle.Enabled = false;
                    txtAuthors.Enabled = false;
                    txtPublisher.Enabled = false;

                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;

                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;

                // Adding or editing
                case 2:
                    txtTitle.Enabled = true;
                    txtAuthors.Enabled = true;
                    txtPublisher.Enabled = true;
                    txtTitle.Focus();

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

        protected void btnFilter_Click(object sender, EventArgs e)
        {
            if(txtSearchTitle.Text == "")
            {
                lblError.Text = "The title must not be empty";
            }
            ObjectDataSource1.FilterExpression = "title like '%" + txtSearchTitle.Text + "%'";
        }

        protected void btnCopies_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow == null)
            {
                lblError.Text = "Error: No a book is selected!";
                return;
            }
            else
            {
                Session["book"] = GridView1.SelectedRow;
                Response.Redirect("~/GUI/CopyGUI.aspx");
            }
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow == null)
            {
                lblError.Text = "Error: No a book is selected!";
                return;
            }
            Session["add"] = 2;
            displayButtons(2);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            int add = (int)Session["add"];
            Book b = new Book();
            b.Title = txtTitle.Text;
            b.Publisher = txtPublisher.Text;
            b.Authors = txtAuthors.Text;

            if (add == 1)
            {
                BookDAO.Insert(b.Title, b.Authors, b.Publisher);
            }
            else
            {
                b.BookNumber = int.Parse(Session["bookNumber"].ToString());
                BookDAO.Update(b.Title, b.Authors, b.Publisher, b.BookNumber);
            }
            ObjectDataSource1.Select();
            GridView1.DataBind();
        }
    }
}