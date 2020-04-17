using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q2
{
    public partial class Home : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();
        protected void Page_Load(object sender, EventArgs e)
        {
            dataProvider.GRIDVIEW("SELECT member.lastname, member.phone_no, region.region_name, corporation.corp_name FROM member INNER JOIN corporation ON member.corp_no = corporation.corp_no INNER JOIN region ON member.region_no = region.region_no",
                GridView1);
            dataProvider.DROP_DOWN_LIST("select * from Region", "region_name", "region_no", ddlRegion);
            dataProvider.DROP_DOWN_LIST("select * from Corporation", "corp_name", "corp_no", ddlCor);
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            dataProvider.ADD_UPDATE_DELETE("INSERT INTO member(lastname, firstname, middleinitial, street, city, state_prov, country, mail_code, phone_no, photograph, issue_dt, expr_dt, region_no, corp_no, prev_balance, curr_balance) VALUES( @param1 , '', '', '', '', '', '', '', @param2 , NULL, (dateadd(year, (-1), getdate() + 1)), GETDATE(), @param3 , @param4 , NULL, NULL)", new object[] { tbLastName.Text, tbPhoneNo.Text, ddlRegion.SelectedValue, ddlCor.SelectedValue });
            dataProvider.GRIDVIEW("SELECT member.lastname, member.phone_no, region.region_name, corporation.corp_name FROM member INNER JOIN corporation ON member.corp_no = corporation.corp_no INNER JOIN region ON member.region_no = region.region_no",
                GridView1);
        }

        protected void GridView1_PageIndexChanged(object sender, EventArgs e)
        {
        }

        protected void GridView1_PageIndexChanging(object sender, GridViewPageEventArgs e)
        {
            GridView1.PageIndex = e.NewPageIndex;
            dataProvider.GRIDVIEW("SELECT member.lastname, member.phone_no, region.region_name, corporation.corp_name FROM member INNER JOIN corporation ON member.corp_no = corporation.corp_no INNER JOIN region ON member.region_no = region.region_no",
                GridView1);
        }
    }
}