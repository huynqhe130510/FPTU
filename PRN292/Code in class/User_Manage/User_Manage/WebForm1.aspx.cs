using DAL;
using Entity;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace User_Manage
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        UserDAO user = new UserDAO();

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                
                grUser.AllowPaging = true;
                grUser.PageSize = 2;
                grUser.PageIndex = 1;
                grUser.DataSource = user.GetAll();
                grUser.DataBind();
            }
        }

        protected void grUser_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
          
        }

        protected void BtnDelete_Click(object sender, EventArgs e)
        {
            Button btnDelete = (Button)sender;
            GridViewRow row = (GridViewRow)btnDelete.NamingContainer;
            int id = Convert.ToInt32(grUser.DataKeys[row.RowIndex].Value);
            user.Delete(id);
            grUser.DataSource = user.GetAll();
            grUser.DataBind();
        }


       
    }
}