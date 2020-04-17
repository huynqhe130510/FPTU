using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q4
{
    public partial class Home : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                dataProvider.DROP_DOWN_LIST("select * from Project", "name", "id", ddlProject);
                string query = "select Employee.name, ProjectMember.position, ProjectMember.isFulltime, ProjectMember.date from ProjectMember inner join Project on ProjectMember.projectID = Project.id inner join Employee on ProjectMember.employeeID = Employee.id where Project.id = @param1";
                dataProvider.GRIDVIEW(query, GridView1, new object[] { ddlProject.SelectedValue });
            }

        }

        protected void ddlProject_SelectedIndexChanged(object sender, EventArgs e)
        {
            string query = "select Employee.name, ProjectMember.position, ProjectMember.isFulltime, ProjectMember.date from ProjectMember inner join Project on ProjectMember.projectID = Project.id inner join Employee on ProjectMember.employeeID = Employee.id where Project.id = @param1";
            dataProvider.GRIDVIEW(query, GridView1, new object[] { ddlProject.SelectedValue });
        }
    }
}