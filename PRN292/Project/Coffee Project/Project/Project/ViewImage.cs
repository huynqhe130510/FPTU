using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Project
{
    public partial class ViewImage : Form
    {
        ListPro mainForm;
        Product curPro;
        string path = "";
        public ViewImage(ListPro m, Product curPro)
        {
            InitializeComponent();
            mainForm = m;
            this.curPro = curPro;
        }

        private void ViewImage_Load(object sender, EventArgs e)
        {
            string pathPicture = curPro.Picture.ToString();
            Image img = Image.FromFile(pathPicture);
            pictureBox.Image = img;
        }


    }
}
