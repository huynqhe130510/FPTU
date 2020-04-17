using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

using System.Web.Configuration;
using System.Data.SqlClient;
using System.Data;

namespace Chapter_24
{


    public partial class frmBook : System.Web.UI.Page
    {
       
        string connStr = WebConfigurationManager.ConnectionStrings["TeacherConnection"].ConnectionString;
        protected void Page_Load(object sender, EventArgs e)
        {
            load_data();
        }

        private void load_data()

        {
            SqlConnection con = new SqlConnection(connStr);
            SqlDataAdapter da = new SqlDataAdapter("select * from tbl_book", con);
            DataTable tb = new DataTable();
            da.Fill(tb);
            GridView1.DataSource = tb;
            GridView1.DataBind();
          
        }
    }
}