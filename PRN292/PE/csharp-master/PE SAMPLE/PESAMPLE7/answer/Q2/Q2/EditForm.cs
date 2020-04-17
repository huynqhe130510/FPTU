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
    public partial class EditForm : Form
    {
        public string id { get; set; }
        DataProvider dataProvider = new DataProvider();

        public EditForm()
        {
            InitializeComponent();

        }

        public EditForm(string id)
        {
            this.id = id;
            InitializeComponent();
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            if (tbCorName.Text.Length < 10)
            {
                MessageBox.Show("CorporationName must have at least 10 characters.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (string.IsNullOrEmpty(tbStreet.Text.Trim()))
            {
                MessageBox.Show("Street must not be blank.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (dateTimePicker1.Value.DayOfYear - DateTime.Now.DayOfYear < 9)
            {
                MessageBox.Show("The ExpireDate must be at least current date 9 days.", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                dataProvider.ADD_UPDATE_DELETE("UPDATE corporation SET corp_name = @param1 , street = @param2 , expr_dt = @param3 WHERE corp_no = @param4",
                    new object[] { tbCorName.Text, tbStreet.Text, Convert.ToDateTime(dateTimePicker1.Value), this.id });
                MessageBox.Show("Edit sccessfull!!!", "Information", MessageBoxButtons.OK, MessageBoxIcon.Information);
                Close();
            }
        }

        private void EditForm_Load(object sender, EventArgs e)
        {
            DataRow dr = dataProvider.GET_OBJECT("select corp_name, street, expr_dt from corporation where corp_no = @param",
                new object[] { this.id });
            tbCorName.Text = dr[0].ToString();
            tbStreet.Text = dr[1].ToString();
            dateTimePicker1.Value = Convert.ToDateTime(dr[2].ToString());
        }
    }
}
