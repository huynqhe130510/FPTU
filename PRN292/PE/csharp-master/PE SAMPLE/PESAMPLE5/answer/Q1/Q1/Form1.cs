using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Q1
{
    public partial class Form1 : Form
    {
        DataProvider dataProvider = new DataProvider();
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dataProvider.DATA_GRID_VIEW("select member.lastname, member.phone_no, corporation.corp_name, region.region_name from member inner join corporation on member.corp_no = corporation.corp_no inner join region on member.region_no = region.region_no", dataGridView1);
            dataProvider.COMBOBOX("select * from corporation", "corp_name", "corp_no", cbbCorporation);
            dataProvider.COMBOBOX("select * from region", "region_name", "region_no", cbbRegion);
        }

        private void btn_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(tbLastName.Text.Trim()))
            {
                MessageBox.Show("Last Name required!!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (string.IsNullOrEmpty(tbPhoneNo.Text.Trim()))
            {
                MessageBox.Show("Phone No required!!!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                dataProvider.ADD_UPDATE_DELETE("INSERT INTO member (lastname, firstname, middleinitial, street, city, state_prov, country, mail_code, phone_no, photograph, issue_dt, expr_dt, region_no, corp_no, prev_balance, curr_balance) VALUES ( @param1 , '',  '', '', '', '', '', '', @param2 , NULL, (dateadd(year, (-1), getdate() + 1)), GETDATE(), @param3 , @param4 , NULL, NULL)", new object[] { tbLastName.Text, tbPhoneNo.Text, cbbRegion.SelectedValue, cbbCorporation.SelectedValue });
                MessageBox.Show("Data saved!!!", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }
        }
    }
}
