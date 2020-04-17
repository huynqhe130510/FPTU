using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q3A
{
    public partial class Hoe : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string query = "select * from Outcomes";
                dataProvider.DROP_DOWN_LIST(query, "ship", "ship", DropDownList1);
            }
            
        }

        protected void btnSearch_Click(object sender, EventArgs e)
        {
            if (!cbShip.Checked)
            {
                string query = "select * from Outcomes";
                dataProvider.GRIDVIEW(query, GridView1);
                DataTable dataTable = dataProvider.GET_LIST_OBJECT(query);
                lbOutCome.Text = dataTable.Rows.Count.ToString();
            } else
            {
                string query = "select * from Outcomes where Ship = @param1";
                dataProvider.GRIDVIEW(query, GridView1, new object[] { DropDownList1.SelectedValue });
                DataTable dataTable = dataProvider.GET_LIST_OBJECT(query, new object[] { DropDownList1.SelectedValue.ToString() });
                lbOutCome.Text = dataTable.Rows.Count.ToString();
            }
        }

        protected void DropDownList1_TextChanged(object sender, EventArgs e)
        {
        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            
        }
    }
}