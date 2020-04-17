using ProjectPRN292.DAL;
using ProjectPRN292.DTL;
using System;
using System.Windows.Forms;

namespace ProjectPRN292.GUI
{
    public partial class LoginGUI : Form
    {
        public LoginGUI()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            string username = txtUsername.Text;
            string password = txtPassword.Text;

            UserDAO Udao = new UserDAO();
            User u = Udao.getUser(username, password);
            Staff s = StaffDAO.getStaffById(u.StaffId);

            if (u.Id != 0 && !username.Equals("") && !password.Equals(""))
            {
                this.Hide();
                MainGUI mainGUI = new MainGUI(u.Username, u.StaffId, s.Name, u.RoleId);
                mainGUI.ShowDialog();

                this.Close();
            }
            else
            {
                MessageBox.Show("Username or Password incorrect ! Please enter again !");
            }
        }
    }
}
