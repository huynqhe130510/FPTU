using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;

namespace Question2
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if(!IsPostBack)
            {
                DataTable dt, dt1;
                // points = 1
                dt = DAO.GetDataTable("select * from region");
                DropDownList1.DataSource = dt;
                DropDownList1.DataTextField = "region_name";
                DropDownList1.DataValueField = "region_no";
                DropDownList1.DataBind();
                DropDownList1.SelectedIndex = 0;

                // points = 0.5
                dt1 = DAO.GetDataTable("select * from corporation where region_no = " + DropDownList1.SelectedValue);
                DropDownList2.DataSource = dt1;
                DropDownList2.DataTextField = "corp_name";
                DropDownList2.DataValueField = "corp_no";
                DropDownList2.DataBind(); 

            }

        }

        protected void DropDownList1_SelectedIndexChanged(object sender, EventArgs e)
        {
            // points = 0.5
            DataTable dt;
            dt = DAO.GetDataTable("select * from corporation where region_no = " + DropDownList1.SelectedValue);
            DropDownList2.DataSource = dt;
            DropDownList2.DataBind();
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("insert into member (firstname, lastname, issue_dt, expr_dt, region_no, corp_no, " +
                                            "member_code, street, city, state_prov, country, mail_code) " +
                            "values(@fn, @ln, @id, @ed, @r, @c, @m, @street, @city, @state, @country, @mail) ");
            cmd.Parameters.AddWithValue("@fn", TextBox1.Text);
            cmd.Parameters.AddWithValue("@ln", TextBox2.Text);
            cmd.Parameters.AddWithValue("@id", DateTime.Now.AddDays(1));
            cmd.Parameters.AddWithValue("@ed", DateTime.Now.AddMonths(6));
            cmd.Parameters.AddWithValue("@r", int.Parse(DropDownList1.SelectedValue));
            cmd.Parameters.AddWithValue("@c", int.Parse(DropDownList2.SelectedValue));
            cmd.Parameters.AddWithValue("@m", "a");
            cmd.Parameters.AddWithValue("@street", "a");
            cmd.Parameters.AddWithValue("@city", "a");
            cmd.Parameters.AddWithValue("@state", "a");
            cmd.Parameters.AddWithValue("@country", "a");
            cmd.Parameters.AddWithValue("@mail", "a");
            if (DAO.UpdateTable(cmd))
                Label1.Text = "That member is added!";
            else
                Label1.Text = "Can not add that member is added!";

        }
    }
}