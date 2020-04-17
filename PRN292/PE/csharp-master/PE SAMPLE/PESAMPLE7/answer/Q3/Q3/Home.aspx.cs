using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Q3
{
    public partial class Home : System.Web.UI.Page
    {
        DataProvider dataProvider = new DataProvider();
        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DataRow dr = dataProvider.GET_OBJECT("select * from CourseRegistration");
                tbStudentID.Text = dr[0].ToString();
                dataProvider.LIST_BOX("select Subject from CourseRegistration", "Subject", "Subject", ListBox1);
                dataProvider.DROP_DOWN_LIST("select Time from CourseRegistration", "Time", "Time", ddlTime);
            }
        }

        protected void btnSubmit_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(tbStudentName.Text.Trim()))
            {
                lbError.Text = "Name can not blank";
            }
            else
            {
                dataProvider.ADD_UPDATE_DELETE("INSERT INTO CourseRegistration (StudentID, StudentName, Sex, Subject, Time, Note) VALUES( @param1 , @param2 , @param3 , @param4 , @param5 , @param6 )",
                    new object[] { tbStudentID.Text, tbStudentName.Text, Convert.ToBoolean(rdbMale.Checked), ListBox1.Text, ddlTime.SelectedValue, tbNote.Text });
                lbResult.Text = "Added successful";
            }
        }

        protected void rdbMale_CheckedChanged(object sender, EventArgs e)
        {

        }

        protected void rdbFemale_CheckedChanged(object sender, EventArgs e)
        {

        }
    }
}