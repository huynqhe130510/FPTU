using System;
using System.Collections;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Q2A
{
    public partial class Form1 : Form
    {
        string connStr = System.Configuration.ConfigurationManager.ConnectionStrings["Database"].ConnectionString;
        DataProvider dataProvinder = new DataProvider();

        public Form1()
        {
            InitializeComponent();
        }


        private void cbbClass_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {
            dataProvinder.COMBOBOX("select class from Classes", cbbClass);
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            int launched;
            // check name empty
            if (string.IsNullOrEmpty(tbName.Text))
            {
                MessageBox.Show("Name required!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (!string.IsNullOrEmpty(tbName.Text))
            {
                ArrayList listName = dataProvinder.LIST_STRING("select name from Ships");
                // check name duplicate
                foreach (string name in listName)
                {
                    if (name.ToString().Trim().Equals(tbName.Text))
                        MessageBox.Show("Name duplicated!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                }
            }
            // check integer
            if (!int.TryParse(tbLaunched.Text, out launched))
            {
                MessageBox.Show("Integer required!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else if (launched < 1990 || launched > DateTime.Now.Year)
            {
                MessageBox.Show("Integer from 1900 to current year required!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            else
            {
                string query = "INSERT INTO Ships VALUES( @param1 , @param2 , @param3 )";
                dataProvinder.ADD_UPDATE_DELETE(query, new object[] { tbName.Text, cbbClass.Text, tbLaunched.Text });
                MessageBox.Show("A new ship is added!", "Inform", MessageBoxButtons.OK, MessageBoxIcon.Information);
            }

        }
    }
}
