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
    public partial class EditDialog : Form
    {
        ListPro mainForm;
        Product curPro;
        string path="";

        public EditDialog(ListPro m, Product curPro)
        {
            InitializeComponent();
            mainForm = m;
            this.curPro = curPro;
        }
        
        private void saveBtn_Click(object sender, EventArgs e)
        {
            bool flag = true;
            if (!inputName(pNameTxt.Text)) { flag = false; }
            else if (!inputPosDbl(PriceTxT.Text)) { flag = false; }
            if (flag == true)
            {
                int proID = curPro.ID;
                string name = pNameTxt.Text;
                int cateID = DataAccess.getCateIdByName(cbCategory.SelectedValue.ToString());
                double price = Convert.ToDouble(PriceTxT.Text);
                string size = SizeTxt.Text;
                string description = DescriptionTxT.Text;
                
                Product.updateProduct(proID, name, cateID, price,size,description,path);
               
                mainForm.reload();
                this.Close();
                mainForm.myShowMessage("Update Successfully");
                this.Dispose();
            }
        }

        public bool inputPosDbl(string s)
        {
            bool flag = false;
            double num;
            try
            {
                num = Convert.ToDouble(s);
                if (num < 0)
                {
                    throw new IndexOutOfRangeException();
                }
                else
                {
                    flag = true;
                }
            }
            catch (IndexOutOfRangeException eI)
            {
                MessageBox.Show("Price must be greater than 0");
                PriceTxT.Focus();
            }
            catch (Exception e)
            {
                MessageBox.Show("Price must be a number");
                PriceTxT.Focus();
            }
            return flag;
        }

        public bool inputName(string name)
        {
            bool flag = true;
            if (name.Length <= 0)
            {
                MessageBox.Show("Name must not be empty");
                flag = false;
            }
            return flag;
        }

        private void EditDialog_Load(object sender, EventArgs e)
        {
            pIDtxt.Text = curPro.ID.ToString();
            pNameTxt.Text = curPro.Name;
            PriceTxT.Text = curPro.Price.ToString();
            SizeTxt.Text = curPro.Size.ToString();
            DescriptionTxT.Text = curPro.Description;
            cbCategory.DataSource = Product.getAllCateGoryName();
            cbCategory.SelectedIndex = cbCategory.FindStringExact(curPro.Category);

            string pathPicture = curPro.Picture.ToString();
            Image img = Image.FromFile(pathPicture);
            Pictureb.Image = img;
        }
        
        private void button1_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Title = "Open image";
            ofd.InitialDirectory = @"C:\";
            ofd.Filter = "Image|*.jpg;*.jpeg;*.png;*.gif;*bmp";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                Pictureb.Image = Image.FromFile(ofd.FileName);
                path = ofd.FileName;
            }
        }
    }
}
