using ProjectPRN292.DAL;
using ProjectPRN292.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectPRN292.GUI
{
    public partial class ProductGUI : Form
    {
        public string curCate;
        Product p;
        string errorPath = "image\\no_photo.jpg";
        string path;
        public ProductGUI()
        {
            InitializeComponent();
            comboBox1.DataSource = CategoryDAO.getAllCateGoryName();

            dataGridView1.AutoGenerateColumns = false;

            curCate = comboBox1.SelectedItem.ToString();
            dataGridView1.DataSource = ProductDAO.getProductByCateName(curCate);
            dataGridView1.Columns["image"].Visible = false;
            dataGridView1.Columns["categoryId"].Visible = false;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            btnDelete.Visible = false;
            btnUpdate.Visible = false;
            btnUpload.Visible = true;
            btnSaveAdd.Visible = true;
            txtProductId.Text = (ProductDAO.selectMaxProId() + 1).ToString();
            txtName.Enabled = true;
            txtName.Clear();
            txtSize.Enabled = true;
            txtSize.Clear();
            txtPrice.Enabled = true;
            txtPrice.Clear();
            cbCategory.DataSource = CategoryDAO.getAllCateGoryName();
            cbCategory.Enabled = true;
            cbCategory.SelectedIndex = 0;
            pictureBox1.Image = null;
        }

        private bool isSelected()
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("You must select a product in the list of products!");
                return false;
            }
            if (dataGridView1.SelectedRows[0].Cells["Id"].Value == null)
            {
                MessageBox.Show("You must select a product in the list of products!");
                return false;
            }
            return true;
        }

        private void btnUpdate_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Update")
            {
                if (!isSelected()) return;
                btnUpdate.Text = "Save";
                btnUpload.Visible = true;
                txtName.Enabled = true;
                txtSize.Enabled = true;
                txtPrice.Enabled = true;
                cbCategory.Enabled = true;
            }
            else
            {
                try
                {
                    if (path != null)
                    {
                        p = new Product(int.Parse(txtProductId.Text), txtName.Text, CategoryDAO.getCategoryIdByName(cbCategory.Text), txtSize.Text, float.Parse(txtPrice.Text), path);
                    }
                    else
                    {
                        p = new Product(int.Parse(txtProductId.Text), txtName.Text, CategoryDAO.getCategoryIdByName(cbCategory.Text), txtSize.Text, float.Parse(txtPrice.Text), dataGridView1.SelectedRows[0].Cells["Image"].Value.ToString());
                    }
                }
                catch
                {
                    p = new Product(int.Parse(txtProductId.Text), txtName.Text, CategoryDAO.getCategoryIdByName(cbCategory.Text), txtSize.Text, float.Parse(txtPrice.Text), errorPath);
                }
                ProductDAO.Update(p);

                dataGridView1.DataSource = ProductDAO.getProductByCateName(curCate);

                btnUpdate.Text = "Update";
                btnUpload.Visible = false;
                txtName.Enabled = false;
                txtSize.Enabled = false;
                txtPrice.Enabled = false;
                cbCategory.Enabled = false;
            }
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            DialogResult drs = MessageBox.Show("Do you want to delete this product?", "Confirm", MessageBoxButtons.YesNo);
            if (drs == DialogResult.Yes)
            {
                ProductDAO.deleteProduct(int.Parse(txtProductId.Text));
                MessageBox.Show("Product has been deleted");

                comboBox1.SelectedIndex = comboBox1.FindStringExact(curCate);
                dataGridView1.DataSource = null;
                dataGridView1.DataSource = ProductDAO.getProductByCateName(curCate);
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            curCate = comboBox1.SelectedItem.ToString();
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = ProductDAO.getProductByCateName(curCate);
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            txtProductId.Text = dataGridView1.Rows[e.RowIndex].Cells["Id"].Value.ToString();
            txtName.Text = dataGridView1.Rows[e.RowIndex].Cells["Name"].Value.ToString();

            cbCategory.DataSource = CategoryDAO.getAllCateGoryName();
            cbCategory.SelectedIndex = int.Parse(dataGridView1.Rows[e.RowIndex].Cells["CategoryId"].Value.ToString());

            txtSize.Text = dataGridView1.Rows[e.RowIndex].Cells["Size"].Value.ToString();
            txtPrice.Text = dataGridView1.Rows[e.RowIndex].Cells["Price"].Value.ToString();

            string image = dataGridView1.Rows[e.RowIndex].Cells["image"].Value.ToString();
            try
            {
                pictureBox1.Image = Image.FromFile(image);
            }
            catch
            {
                pictureBox1.Image = Image.FromFile(errorPath);
            }
            btnSaveAdd.Visible = false;
        }

        private void btnSaveAdd_Click(object sender, EventArgs e)
        {
            if (cbCategory.SelectedValue.Equals("All Category"))
            {
                MessageBox.Show("Please choose a category !");
            }
            else
            {
                p = new Product(int.Parse(txtProductId.Text), txtName.Text, CategoryDAO.getCategoryIdByName(cbCategory.Text),
                    txtSize.Text, float.Parse(txtPrice.Text), path);
                ProductDAO.Insert(p);

                dataGridView1.DataSource = ProductDAO.getProductByCateName(curCate);
                btnSaveAdd.Visible = false;
                btnUpload.Visible = false;
                txtName.Enabled = false;
                txtSize.Enabled = false;
                txtPrice.Enabled = false;
                cbCategory.Enabled = false;
            }
        }

        private void btnUpload_Click(object sender, EventArgs e)
        {
            OpenFileDialog ofd = new OpenFileDialog();
            ofd.Title = "Open image";
            ofd.InitialDirectory = @"C:\";
            ofd.Filter = "Image|*.jpg;*.jpeg;*.png;*.gif;*bmp";
            if (ofd.ShowDialog() == DialogResult.OK)
            {
                pictureBox1.Image = Image.FromFile(ofd.FileName);
                path = ofd.FileName;
            }
        }
    }
}
