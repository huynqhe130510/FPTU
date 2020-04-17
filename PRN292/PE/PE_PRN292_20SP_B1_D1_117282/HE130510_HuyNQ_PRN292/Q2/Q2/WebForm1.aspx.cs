using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DataTable dt = DAO.GetDataTable("select distinct Country from DailyReport");
                DropDownList1.DataSource = dt;
                DropDownList1.DataTextField = "Country";
                DropDownList1.SelectedValue = "Belarus";
                DropDownList1.DataBind();
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            DataTable dt = DAO.GetDataTable("select distinct date  from DailyReport where DATE >= '" + Calendar1.SelectedDate + "' and DATE <= '" + Calendar2.SelectedDate + "'");
            foreach (DataRow dr in dt.Rows) 
            {
                Label lb = new Label();
                lb.Text = dr["date"].ToString();
                lb.DataBind();
            }
        }
    }
}