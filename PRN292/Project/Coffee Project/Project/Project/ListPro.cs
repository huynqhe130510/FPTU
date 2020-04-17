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

    public partial class ListPro : Form
    {
        string path = "";

        public string curCate;
        public ListPro()
        {
            InitializeComponent();
            WindowState = FormWindowState.Maximized;
        }

        private void Form1_Load(object sender, EventArgs e)
        {
            //load category name to combobox in add product form
            comboBoxCategory.DataSource = Product.getAllCateGoryName();

            dgvProduct.AutoGenerateColumns = false;
            dgvProduct.DataSource = Product.GetAllProduct();
            cbCategory.DataSource = Product.listCategory();

            dgvProduct.Columns.Add("PID", "ID");
            dgvProduct.Columns["PID"].DataPropertyName = "ID";

            dgvProduct.Columns.Add("PName", "Name");
            dgvProduct.Columns["PName"].DataPropertyName = "Name";

            dgvProduct.Columns.Add("PCate", "Category");
            dgvProduct.Columns["PCate"].DataPropertyName = "Category";

            dgvProduct.Columns.Add("PuPrice", "Price");
            dgvProduct.Columns["PuPrice"].DataPropertyName = "Price";
            
            dgvProduct.Columns.Add("PuSize", "Size");
            dgvProduct.Columns["PuSize"].DataPropertyName = "Size";

            dgvProduct.Columns.Add("PuDescription", "Description");
            dgvProduct.Columns["PuDescription"].DataPropertyName = "Description";

            DataGridViewButtonColumn img = new DataGridViewButtonColumn();
            img.Name = "Image";
            img.Text = "View";
            img.UseColumnTextForButtonValue = true;
            dgvProduct.Columns.Add(img);

            DataGridViewButtonColumn delCol = new DataGridViewButtonColumn();
            delCol.Name = "Delete Product";
            delCol.Text = "Delete";
            delCol.UseColumnTextForButtonValue = true;
            dgvProduct.Columns.Add(delCol);

            DataGridViewButtonColumn editCol = new DataGridViewButtonColumn();
            editCol.Name = "Edit Product";
            editCol.Text = "Edit";
            editCol.UseColumnTextForButtonValue = true;
            dgvProduct.Columns.Add(editCol);


            pictureBox1.Image = Image.FromFile("Product_Picture/default.jpg");

        }

        private void dgvProduct_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            List<Product> listP = (List<Product>)dgvProduct.DataSource;
            int proID = listP[e.RowIndex].ID;
            if (e.ColumnIndex == 6)
            {
                Product curPro = listP[e.RowIndex];
                ViewImage view = new ViewImage(this, curPro);
                view.Show();
            }
            if (e.ColumnIndex == 7)
            {
                DialogResult drs = MessageBox.Show("Do you want to delete this product?", "Confirm", MessageBoxButtons.YesNo);
                if (drs == DialogResult.Yes)
                {
                    Product.deleteProduct(proID);
                    MessageBox.Show("Product has been deleted");
                    //dgvProduct.DataSource = null;
                    //dgvProduct.DataSource = Product.GetAllProduct();
                    reload();
                }
            }
            if (e.ColumnIndex == 8)
            {
                Product curPro = listP[e.RowIndex];
                EditDialog editDiagLog = new EditDialog(this, curPro);
                editDiagLog.Show();
            }
        }
        public void myShowMessage(string mess)
        {
            MessageBox.Show(mess);
        }

        //reload form base on current category
        public void reload()
        {
            cbCategory.SelectedIndex = cbCategory.FindStringExact(curCate);
            dgvProduct.DataSource = null;
            dgvProduct.DataSource = Product.getProductByCateID(curCate);
        }

        private void cbCategory_SelectedIndexChanged(object sender, EventArgs e)
        {
            curCate = cbCategory.SelectedItem.ToString();
            dgvProduct.DataSource = null;
            dgvProduct.DataSource = Product.getProductByCateID(curCate);
        }

        // open an image
        OpenFileDialog ofd = new OpenFileDialog();
        private void OpenImageBtn_Click(object sender, EventArgs e)
        {
            ofd.Title = "Open image";
            ofd.InitialDirectory = @"C:\";
            ofd.Filter = "Image|*.jpg;*.jpeg;*.png;*.gif;*bmp";
            if(ofd.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.Image = Image.FromFile(ofd.FileName);
                path = ofd.FileName;
            }

        }

        private void AddProductBTN_Click(object sender, EventArgs e)
        {
            bool flag = true;
            if (!inputName(NameProductInput.Text)) { flag = false; }
            else if (!inputName(sizeProductInput.Text)) { flag = false; }
            else if (!inputPosDbl(PriceProductInput.Text)) { flag = false; }
            else if (!inputName(desInput.Text)) { flag = false; }
            if (flag == true)
            {
                string name = NameProductInput.Text;
                double price = Convert.ToDouble(PriceProductInput.Text);
                int cate = DataAccess.getCateIdByName(comboBoxCategory.SelectedItem.ToString());
                string size = sizeProductInput.Text;
                string description = desInput.Text;
                
                if (path == "") {
                    MessageBox.Show("You must import picture");
                }
                else
                {
                    Product.addProduct(name, cate, price, size, description, path);
                    MessageBox.Show("Add product complete");
                    // clear all of textbox
                    NameProductInput.Text = "";
                    PriceProductInput.Text = "";
                    sizeProductInput.Text = "";
                    desInput.Text = "";
                    path = "";
                }
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
                PriceProductInput.Focus();
            }
            catch (Exception e)
            {
                MessageBox.Show("Price must be a number");
                PriceProductInput.Focus();
            }
            return flag;
        }

        public bool inputName(string name)
        {
            bool flag = true;
            if (name.Length <= 0)
            {
                MessageBox.Show("Must not be empty");
                flag = false;
            }
            return flag;
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void btBack_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
