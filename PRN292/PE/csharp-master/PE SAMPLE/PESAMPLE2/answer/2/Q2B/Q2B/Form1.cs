using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Q2B
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
            dataProvider.COMBOBOX("select class from classes order by class asc", cbbClass);
        }

        private void tbName_TextChanged(object sender, EventArgs e)
        {
            btnSave.Enabled = false;
            btnSearch.Enabled = true;
        }

        private void btnSearch_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrEmpty(tbName.Text))
            {
                MessageBox.Show("Name required!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return;
            }
            string query = "select * from Ships where name = @param1";
            DataTable dataTable = dataProvider.GET_LIST_OBJECT(query, new object[] { tbName.Text });
            if(dataTable.Rows.Count == 0)
            {
                MessageBox.Show("This ship is not existed!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            } else
            {
                DataRow item = dataTable.Rows[0];
                cbbClass.Text = item["class"].ToString();
                tbLaunched.Text = item["launched"].ToString();
                btnSave.Enabled = true;
            }
            
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            string query = "update Ships set name = @param1 , class = @param2 , launched = @param3 where name = @param4";
            dataProvider.ADD_UPDATE_DELETE(query, new object[] { tbName.Text, cbbClass.Text, tbLaunched.Text, tbName.Text });
        }
    }
}
