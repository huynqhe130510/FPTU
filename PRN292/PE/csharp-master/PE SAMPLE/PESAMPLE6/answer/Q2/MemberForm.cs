using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q2
{
    public partial class MemberForm : Form
    {
        DataProvider dataProvider = new DataProvider();
        public string memberNo;
        public bool checkEdit = false;
        public MemberForm()
        {
            InitializeComponent();
        }

        public MemberForm(string memberNo, bool checkEdit)
        {
            this.memberNo = memberNo;
            this.checkEdit = checkEdit;
            InitializeComponent();
        }

        private void MemberForm_Load(object sender, EventArgs e)
        {
            dataProvider.COMBOBOX("select * from Region", "region_name", "region_no", cbbRegion);
            dataProvider.COMBOBOX("select * from Corporation", "corp_name", "corp_no", cbbCorporation);
            if (!this.checkEdit)
            {
                btnAdd.Enabled = false;
                DataRow dr = dataProvider.GET_OBJECT("SELECT member.lastname, member.firstname, member.expr_dt, corporation.corp_name, region.region_name FROM member FULL OUTER JOIN corporation ON member.corp_no = corporation.corp_no FULL OUTER JOIN region ON member.region_no = region.region_no where member_no = @param1", new object[] { this.memberNo });
                tbLastName.Text = dr[0].ToString();
                tbFirstName.Text = dr[1].ToString();
                dateTimePicker1.Value = Convert.ToDateTime(dr[2].ToString());
                cbbCorporation.SelectedText = dr[3].ToString();
                cbbRegion.SelectedText = dr[4].ToString();
            }
            else
            {
                btnEdit.Enabled = false;
            }

        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            string query = "UPDATE member SET lastname = @param1 , firstname = @param2 , expr_dt = @param3 , region_no = @param4 , corp_no = @parm5 WHERE member_no = @param6";
            cbbRegion.SelectedIndex = cbbRegion.SelectedIndex == -1 ? 1 : cbbRegion.SelectedIndex;
            cbbCorporation.SelectedIndex = cbbCorporation.SelectedIndex == -1 ? 9 : cbbCorporation.SelectedIndex;
            Console.WriteLine(cbbCorporation.SelectedIndex);
            dataProvider.ADD_UPDATE_DELETE(query, new object[] { tbLastName.Text, tbFirstName.Text, Convert.ToDateTime(dateTimePicker1.Value), cbbRegion.SelectedValue, cbbCorporation.SelectedValue, this.memberNo });
            Close();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            string query = "INSERT INTO member (lastname, firstname , middleinitial, street, city, state_prov, country, mail_code, phone_no, photograph, issue_dt, expr_dt, region_no, corp_no, prev_balance, curr_balance) VALUES ( @param1 , @param2 , '', '', '', '', '', '', '', NULL, (dateadd(year, (-1), getdate() + 1)), @param3 , @param4 , @param5 , NULL, NULL)";
            dataProvider.ADD_UPDATE_DELETE(query, new object[] { tbLastName.Text, tbFirstName.Text, Convert.ToDateTime(dateTimePicker1.Value), cbbRegion.SelectedValue, cbbCorporation.SelectedValue });
            Close();
        }
    }
}
