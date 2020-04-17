using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
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
                DataTable dt1 = DAO.GetDataTable("select * from region");
                DropDownList1.DataSource = dt1;
                DropDownList1.DataValueField = "region_no";
                DropDownList1.DataTextField = "region_name";
                DropDownList1.DataBind();

                DataTable dt2 = DAO.GetDataTable("select * from corporation where region_no = " + DropDownList1.SelectedValue);
                DropDownList2.DataSource = dt2;
                DropDownList2.DataValueField = "corp_no";
                DropDownList2.DataTextField = "corp_name";
                DropDownList2.DataBind();
            }
        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dt2 = DAO.GetDataTable("select * from corporation where region_no = " + DropDownList1.SelectedValue);
            DropDownList2.DataSource = dt2;
            DropDownList2.DataValueField = "corp_no";
            DropDownList2.DataTextField = "corp_name";
            DropDownList2.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("insert into member([lastname] ,[firstname] ,[middleinitial],[street] ,[city] ,[state_prov],[country],[mail_code],[phone_no],[photograph] ,[issue_dt] ,[expr_dt],[region_no] ,[corp_no],[prev_balance],[curr_balance],[member_code]) " +
                "values(@lastname, @firstname, '', '', '', '', '', '', '', '', DATEADD(day, 1, GETDATE()), DATEADD(month, 6, DATEADD(day, 1, GETDATE())), @region_no, @corp_no, '', '', '')");
            cmd.Parameters.AddWithValue("@lastname", TextBox2.Text);
            cmd.Parameters.AddWithValue("@firstname", TextBox1.Text);
            cmd.Parameters.AddWithValue("@region_no", DropDownList1.SelectedValue);
            cmd.Parameters.AddWithValue("@corp_no", DropDownList2.SelectedValue);
            DAO.UpdateTable(cmd);
            Label5.Text = "Add Successful !";
        }
    }
}