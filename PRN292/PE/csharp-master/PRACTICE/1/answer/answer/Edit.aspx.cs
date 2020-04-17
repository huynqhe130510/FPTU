using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace answer
{
    public partial class Edit : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                tbMasterId.Text = Request.QueryString["id"].ToString();
                tbMasterName.Text = Request.QueryString["name"].ToString();
            }
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            dataProvider.ADD_UPDATE_DELETE("update DummyMaster set master_name = @param1 where master_id = @param2", new object[] { tbMasterName.Text, tbMasterId.Text });
            Response.Redirect("Home.aspx");
        }
    }
}