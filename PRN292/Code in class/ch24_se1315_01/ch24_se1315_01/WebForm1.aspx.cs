using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace ch24_se1315_01
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        int count;
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                count = 0;
                Label1.Text = (string) Session["My name"];
                Session["count"] = count;
                Calendar1.TodaysDate = DateTime.Now;
                Calendar1.SelectedDate = DateTime.Now;
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            count = int.Parse(Session["count"].ToString());
            count++;
            TextBox1.Text = count.ToString();
            Session["count"] = count;
        }

        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            Label1.Text = Calendar1.SelectedDate.ToString("dd/MM/yyyy");
        }
    }
}