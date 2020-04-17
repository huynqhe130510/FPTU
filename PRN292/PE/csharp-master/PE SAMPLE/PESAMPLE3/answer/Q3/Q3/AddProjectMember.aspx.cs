using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q3
{
    public partial class AddProjectMember : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();
        protected void Page_Load(object sender, EventArgs e)
        {
            dataProvider.GRIDVIEW("select * from Employee", GridView1);
            dataProvider.DROP_DOWN_LIST("select * from Employee", "name", "id", DropDownList1);
            GridView1.RowCommand += GridView1_RowCommand;

        }

        private void GridView1_RowCommand(object sender, GridViewCommandEventArgs e)
        {
            if (e.CommandName.Equals("Select"))
            {
                tbProjectName.Text = e.CommandArgument.ToString();
                DataRow dr = dataProvider.GET_OBJECT("select * from ProjectMember where projectID = @param1", new object[] { e.CommandArgument.ToString() });
                if (dr != null)
                {
                    DropDownList1.SelectedValue = dr[0].ToString();
                    tbPosition.Text = dr[2].ToString();
                    cbFullTime.Checked = Convert.ToBoolean(dr[3]);
                    Calendar1.SelectedDate = Convert.ToDateTime(dr[4]);
                }
                else
                {
                    DropDownList1.SelectedIndex = 0;
                    tbPosition.Text = "";
                    cbFullTime.Checked = false;
                    Calendar1.SelectedDates.Clear();
                }

            }
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            GridViewRow gr = GridView1.SelectedRow;
            tbProjectName.Text = gr.Cells[1].Text;

        }

        protected void GridView1_RowDeleting(object sender, GridViewDeleteEventArgs e)
        {

        }

        protected void GridView1_RowDeleted(object sender, GridViewDeletedEventArgs e)
        {
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            DataRow dr = dataProvider.GET_OBJECT("select * from ProjectMember where projectID = @param1", new object[] { tbProjectName.Text });
            if (dr == null)
            {
                dataProvider.ADD_UPDATE_DELETE(
                "insert into ProjectMember (employeeID, projectID, position, isFulltime, date) values ( @param1 , @param2 , @param3 , @param4 , @param5 )",
                new object[] { DropDownList1.SelectedValue, tbProjectName.Text, tbPosition.Text, cbFullTime.Checked, Calendar1.SelectedDate });
            }
            else
            {
                dataProvider.ADD_UPDATE_DELETE(
                    "update ProjectMember set employeeID = @param1 , position = @param2 , isFulltime = @param3 , date = @param4 where projectID = @param5",
                    new object[] { DropDownList1.SelectedValue, tbPosition.Text, cbFullTime.Checked, Calendar1.SelectedDate, tbProjectName.Text, });
            }
        }
    }
}