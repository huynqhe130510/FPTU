using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace answer
{
    public partial class Home : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();

        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            GridViewRow gr = GridView1.SelectedRow;
            Response.Redirect("Edit.aspx?id=" + gr.Cells[0].Text + "&name=" + gr.Cells[1].Text);
        }
    }
}