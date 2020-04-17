using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace Chapter22
{
    public partial class frmReserve : Form
    {
        string connStr = "Server= HaPN\\HAPN_SERVER; database = PRN292; integrated security = true;" ;

        public frmReserve()
        {
            InitializeComponent();
        }

        private void btnAddNew_Click(object sender, EventArgs e)
        {
            SqlConnection con = new SqlConnection(connStr);

            SqlCommand cmd = new SqlCommand("insert into register values('" 
                + txtMemberCode.Text + "', '" + txtName.Text + "','" + txtSex.Text + "', '" 
                + txtAddress.Text + "','" + txtTelephone.Text + "','" + txtEmail.Text + "')", con);

            con.Open();

            cmd.ExecuteNonQuery();

            con.Close();

            load_data();

        }

        private void frmRegister_Load(object sender, EventArgs e)
        {
            load_data();
        }

        private void load_data()

        {  
           SqlConnection con = new SqlConnection(connStr);
           SqlDataAdapter da = new SqlDataAdapter("select * from register", con);

            DataTable tb = new DataTable();
              da.Fill(tb);
            dataGridViewRegister.DataSource = tb;
            
            //databinding to textbox
            txtMemberCode.DataBindings.Clear();
            txtName.DataBindings.Clear();
            txtSex.DataBindings.Clear();
            txtAddress.DataBindings.Clear();
            txtTelephone.DataBindings.Clear();
            txtEmail.DataBindings.Clear();

            txtMemberCode.DataBindings.Add("Text", dataGridViewRegister.DataSource, "MemberCode");
            txtName.DataBindings.Add("Text", dataGridViewRegister.DataSource, "Name");
            txtSex.DataBindings.Add("Text", dataGridViewRegister.DataSource, "Sex");
            txtAddress.DataBindings.Add("Text", dataGridViewRegister.DataSource, "Address");
            txtTelephone.DataBindings.Add("Text", dataGridViewRegister.DataSource, "Telephone");
            txtEmail.DataBindings.Add("Text", dataGridViewRegister.DataSource, "Email");
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            DialogResult kq = MessageBox.Show("ban muon xoa khong ?","tieu de", MessageBoxButtons.YesNo);



            if (kq == System.Windows.Forms.DialogResult.Yes)

            {

                SqlConnection con = new SqlConnection(connStr);

                SqlCommand cmd = new SqlCommand("delete from register where membercode = '"+ txtMemberCode.Text +"'", con);

                con.Open();

                cmd.ExecuteNonQuery();

                con.Close();

                load_data();

            }
        }
    }
}
