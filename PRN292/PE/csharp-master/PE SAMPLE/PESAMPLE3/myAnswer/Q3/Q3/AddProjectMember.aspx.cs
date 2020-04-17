using Q3.DAL;
using Q3.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q3
{
    public partial class AddProjectMember : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DataTable dt = ProjectDAO.getProjects();
                DataTable dt1 = EmployeeDAO.getAllEmployee();

                DataView dv = new DataView(dt);
                DataView dv1 = new DataView(dt1);

                GridView1.DataSource = dv;
                DropDownList1.DataSource = dv1;

                DropDownList1.DataTextField = "name";
                DropDownList1.DataValueField = "id";

                DropDownList1.DataBind();
                GridView1.DataBind();
            }
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dt = ProjectMemberDAO.getProjectMemberByProjectId(int.Parse(GridView1.SelectedRow.Cells[1].Text));
            DataView dv = new DataView(dt);
            GridView gr = new GridView();
            gr.DataSource = dv;

            foreach (DataRow dr in dt.Rows)
            {
                ListItem li = new ListItem();
                li.Text = dr["eName"].ToString();
                li.Value = dr["eId"].ToString();
                DropDownList1.Items.Add(li);
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            ProjectMember pm = new ProjectMember();

            pm.ProjectId = int.Parse(TextBox1.Text);
            pm.EmployeeId = int.Parse(DropDownList1.SelectedValue);
            pm.Position = TextBox2.Text;

            bool isFullTime = false;
            if (CheckBox1.Checked)
            {
                isFullTime = true;
            }
            pm.IsFullTime = isFullTime;
            pm.Date = Calendar1.SelectedDate;

            ProjectMemberDAO.Add(pm);
        }
    }
}