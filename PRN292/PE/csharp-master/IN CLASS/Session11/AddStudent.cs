using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Chapter21
{
    public partial class AddStudent : Form
    {
        // Our list of student.
        private List<Student> arrStudents = new List<Student>();
        public AddStudent()
        {
            InitializeComponent();
        }

        private void btnAddNew_Click(object sender, EventArgs e)
        {
            arrStudents.Add(new Student(this.txtFullName.Text, int.Parse(this.txtAge.Text), this.txtClass.Text));
            MessageBox.Show(arrStudents[0].fullName);
            listStudent.Items.Add(arrStudents[0].fullName);
            listStudent.Show();
        }
        
    }
}
