using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q3
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DataTable dt = DAO.GetDataTable("select * from Outcomes order by ship");
                DropDownList1.DataSource = dt;
                DropDownList1.DataValueField = "battle";
                DropDownList1.DataTextField = "battle";
                DropDownList1.DataBind();
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if(CheckBox1.Checked == false)
            {
                DataTable dt = DAO.GetDataTable("select * from Outcomes");
                Label1.Text = dt.Rows.Count.ToString();
                GridView1.DataSource = dt;
                GridView1.DataBind();
            }
            else
            {
                DataTable dt = DAO.GetDataTable("select * from Outcomes where battle = '" + DropDownList1.SelectedValue.Trim() + "'");
                Label1.Text = dt.Rows.Count.ToString();
                GridView1.DataSource = dt;
                GridView1.DataBind();
            }
        }
    }
}