using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace FullControl
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
            fullFunctionCombobox();

            dataProvider.CHECKED_LIST_BOX("select username from [User]", checkedListBoxUser);
            dataProvider.LIST_BOX("select * from [User]", "username", "password", listBoxUser);
        }

        private void fullFunctionCombobox()
        {
            dataProvider.COMBOBOX("select * from [User]", "username", "id", comboBoxUser);

        }


        private void comboBoxUser_SelectedIndexChanged(object sender, EventArgs e)
        {
            tbID.Text = comboBoxUser.SelectedValue.ToString();
            DataRow dr = dataProvider.GET_OBJECT(
                "select username, password, avatar_url, gmail, dob, gender from [User] where id = @param1",
                new object[] { comboBoxUser.SelectedValue.ToString() });
            tbUsername.Text = dr[0].ToString();
            tbPassword.Text = dr[1].ToString();
            tbAvatar.Text = dr[2].ToString();
            tbGmail.Text = dr[3].ToString();
            monthCalendar1.SetDate(Convert.ToDateTime(dr[4].ToString()));
            cbGender.Checked = Convert.ToBoolean(dr[5].ToString());
            rdbMan.Checked = Convert.ToBoolean(dr[5].ToString());
            rdbWoman.Checked = !Convert.ToBoolean(dr[5].ToString());
        }

        private void checkedListBoxUser_SelectedIndexChanged(object sender, EventArgs e)
        {
        }

        private void listBoxUser_SelectedIndexChanged(object sender, EventArgs e)
        {
        }

        private void label8_Click(object sender, EventArgs e)
        {

        }
    }
}
