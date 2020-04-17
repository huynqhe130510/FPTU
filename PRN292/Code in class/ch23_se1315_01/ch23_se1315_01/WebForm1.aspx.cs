using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace ch23_se1315_01
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
                SqlConnection conn = new SqlConnection(strConn);
                SqlCommand cmd = new SqlCommand("select * from Book ; select * from Copy", conn);
                SqlDataAdapter da = new SqlDataAdapter();
                da.SelectCommand = cmd;
                DataSet ds = new DataSet();
                da.Fill(ds);

                DataTable dt = ds.Tables[0];
                DataRow r = dt.NewRow();
                r[0] = -1;//bookNumber
                r[1] = "______All_______";//Title
                dt.Rows.Add(r);

                DataView dv = new DataView(dt);
                dv.Sort = "bookNumber";

                DropDownList1.DataSource = dv;
                DropDownList1.DataTextField = "Title";
                DropDownList1.DataValueField = "BookNumber";
                DropDownList1.DataBind();
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string strConn = ConfigurationManager.ConnectionStrings["LibraryConnectionString"].ConnectionString;
            SqlConnection conn = new SqlConnection(strConn);
            SqlCommand cmd = new SqlCommand("select copy.*, title from copy, book where copy.bookNumber = book.bookNumber", conn);
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataTable dt = new DataTable();
            da.Fill(dt);
            dt.Columns[0].ColumnName = "Number";

            DataView dv = new DataView(dt);
            string filter = "Title like '*" + TextBox1.Text + "*'";
            if (int.Parse(DropDownList1.SelectedValue) != -1)
                filter += "BookNumber = " + DropDownList1.SelectedValue;

            dv.RowFilter = filter;
            GridView1.DataSource = dv;
            GridView1.DataBind();
        }

        protected void GridView1_DataBound(object sender, EventArgs e)
        {
            Label1.Text = GridView1.Rows.Count.ToString();
        }

        protected void GridView1_RowDataBound(object sender, GridViewRowEventArgs e)
        {
            e.Row.Cells[1].Visible = false;
        }
    }
}