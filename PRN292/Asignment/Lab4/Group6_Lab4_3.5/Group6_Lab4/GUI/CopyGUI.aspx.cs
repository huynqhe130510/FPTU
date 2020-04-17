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
    public partial class CopyGUI : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack && Session["book"] != null)
            {
                GridViewRow vrow = (GridViewRow)Session["book"];
                txtBookNumber.Text = vrow.Cells[1].Text;
                txtTitle.Text = vrow.Cells[2].Text;
                displayButtons(1);
            }
        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // View
                case 1:

                    txtType.Enabled = false;
                    txtPrice.Enabled = false;

                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;

                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;

                // Adding or editing
                case 2:
                    txtType.Enabled = true;
                    txtPrice.Enabled = true;
                    txtType.Focus();

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

        protected void GridView1_DataBound(object sender, EventArgs e)
        {
            lblNoRows.Text = GridView1.Rows.Count.ToString();
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow == null)
            {
                lblError.Text = "Error: No a copy is selected!";
                return;
            }
            Session["add"] = 2;
            displayButtons(2);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            int add = (int)Session["add"];
            Copy c = new Copy();
            c.BookNumber = int.Parse(txtBookNumber.Text);
            c.SequenceNumber = CopyDAO.GetSequenceNumberMax(c.BookNumber) + 1;
            if (txtType.Text.Equals("A") || txtType.Text.Equals("B"))
                c.Type = txtType.Text[0].ToString();
            else
            {
                lblError.Text = "The type must be ‘A’ or ‘B’.";
            }
            if (txtPrice.Text == "") c.Price = 0;
            else if (int.Parse(txtPrice.Text) < 0 || int.Parse(txtPrice.Text) > 999999999)
            {
                lblError.Text = "The Price must be from 0 to 999.999.999.";
            }
            else
                c.Price = int.Parse(txtPrice.Text);
            if (add == 1)
            {
                c.CopyNumber = CopyDAO.GetCopyNumberMax() + 1;
                CopyDAO.Insert(c);
            }
            else
            {
                c.CopyNumber = (int)Session["copyNumber"];
                CopyDAO.Update(c);
            }
            ObjectDataSource1.Select();
            GridView1.DataBind();
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            Session["copyNumber"] = int.Parse(GridView1.SelectedRow.Cells[1].Text);
            txtType.Text = Server.HtmlDecode(GridView1.SelectedRow.Cells[4].Text);
            txtPrice.Text = Server.HtmlDecode(GridView1.SelectedRow.Cells[5].Text);
        }
    }
}