using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q3
{
    public partial class WebForm1 : System.Web.UI.Page
    {
       static string strConn = ConfigurationManager.ConnectionStrings["PRN292_SU17_1ConnectionString"].ConnectionString;
        SqlConnection conn = new SqlConnection(strConn);
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                SqlCommand cmd = new SqlCommand("select * from DummyMaster ; select * from DummyDetail", conn);
                SqlDataAdapter da = new SqlDataAdapter();
                da.SelectCommand = cmd;
                DataSet ds = new DataSet();
                da.Fill(ds);

                DataTable dt = ds.Tables[0];
                DataRow r = dt.NewRow();
                r[0] = -1;
                r[1] = "______All_______";
                dt.Rows.Add(r);

                DataView dv = new DataView(dt);
                dv.Sort = "master_id";

                DropDownList1.DataSource = dv;
                DropDownList1.DataTextField = "master_name";
                DropDownList1.DataValueField = "master_id";
                DropDownList1.DataBind();
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            SqlCommand cmd = new SqlCommand("select dd.*, dm.master_name from DummyDetail dd, DummyMaster dm " +
                "where dd.master_id = dm.master_id", conn);
            SqlDataAdapter da = new SqlDataAdapter();
            da.SelectCommand = cmd;
            DataTable dt = new DataTable();
            da.Fill(dt);
            dt.Columns[0].ColumnName = "ID";

            DataView dv = new DataView(dt);
            string filter = "detail_name like '*" + TextBox1.Text + "*'";
            if (int.Parse(DropDownList1.SelectedValue) != -1)
                filter += "and master_id = " + DropDownList1.SelectedValue;

            dv.RowFilter = filter;
            dv.Table.Columns[1].ColumnName = "Name";
            dv.Table.Columns.RemoveAt(2);
            dv.Table.Columns[2].ColumnName = "Master";
            GridView1.DataSource = dv;
            GridView1.DataBind();
        }
    }
}