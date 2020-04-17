using ProjectPRN292.DAL;
using ProjectPRN292.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ProjectPRN292.GUI
{
    public partial class SalesGUI : Form
    {
        List<OrderDetail> orderDetails;
        int staffId;
        string staffName;
        float total;

        public SalesGUI(int staffId, string staffName)
        {
            InitializeComponent();
            setupDataGridView();
            this.orderDetails = new List<OrderDetail>();
            this.staffId = staffId;
            this.staffName = staffName;
            DataTable dt = CategoryDAO.getAllCategories();
            comboBox1.Text = "Category";
            foreach (DataRow dr in dt.Rows)
            {
                comboBox1.Items.Add(dr["Name"].ToString());
            }
        }

        public void setupDataGridView()
        {
            dataGridView1.AutoGenerateColumns = false;
            dataGridView1.AllowUserToAddRows = false;
            dataGridView1.Columns.Add("pid", "ID");
            dataGridView1.Columns["pid"].Width = 40;
            dataGridView1.Columns["pid"].DataPropertyName = "ProductID";

            dataGridView1.Columns.Add("pName", "Name");
            dataGridView1.Columns["pName"].Width = 150;
            dataGridView1.Columns["pName"].DataPropertyName = "ProductName";

            dataGridView1.Columns.Add("pSize", "Size");
            dataGridView1.Columns["pSize"].Width = 40;
            dataGridView1.Columns["pSize"].DataPropertyName = "Size";

            dataGridView1.Columns.Add("price", "Price");
            dataGridView1.Columns["price"].Width = 70;
            dataGridView1.Columns["price"].DataPropertyName = "Price";

            dataGridView1.Columns.Add("pQuant", "Quantity");
            dataGridView1.Columns["pQuant"].Width = 70;
            dataGridView1.Columns["pQuant"].DataPropertyName = "Quantity";

            DataGridViewButtonColumn addCol = new DataGridViewButtonColumn();
            addCol.Name = "Add";
            addCol.Text = "+";
            addCol.Width = 29;
            addCol.DefaultCellStyle.BackColor = Color.Green;
            addCol.UseColumnTextForButtonValue = true;
            dataGridView1.Columns.Add(addCol);

            DataGridViewButtonColumn subCol = new DataGridViewButtonColumn();
            subCol.Name = "Sub";
            subCol.Text = "-";
            subCol.Width = 29;
            subCol.DefaultCellStyle.BackColor = Color.Yellow;
            subCol.UseColumnTextForButtonValue = true;
            dataGridView1.Columns.Add(subCol);

            dataGridView1.Columns.Add("cost", "Cost");
            dataGridView1.Columns["cost"].DataPropertyName = "Cost";

            DataGridViewButtonColumn delCol = new DataGridViewButtonColumn();
            delCol.Name = "Del";
            delCol.Text = "X";
            delCol.Width = 30;
            delCol.DefaultCellStyle.BackColor = Color.Red;
            delCol.UseColumnTextForButtonValue = true;
            dataGridView1.Columns.Add(delCol);
        }

        public void loadProductByCategoryName(string categoryName)
        {
            listView1.Items.Clear();
            DataTable dt = ProductDAO.getAllProductByCateName(categoryName);
            ImageList imgs = new ImageList();
            imgs.ImageSize = new Size(120, 120);
            listView1.TileSize = new Size(200, 130);

            foreach (DataRow dr in dt.Rows)
            {
                string img = dr["Image"].ToString();

                try
                {
                    imgs.Images.Add(Image.FromFile(img));
                }
                catch
                {
                    imgs.Images.Add(Image.FromFile("image\\error.jpg"));
                }

            }
            listView1.LargeImageList = imgs;
            int count = 0;
            foreach (DataRow dr in dt.Rows)
            {
                listView1.Items.Add(dr["Name"].ToString(), count);
                listView1.Items[count].SubItems.Add("Price: " + dr["Price"].ToString());
                listView1.Items[count].SubItems.Add("Size: " + dr["Size"].ToString());
                listView1.Items[count].SubItems.Add(dr["Id"].ToString());
                listView1.Items[count].SubItems.Add(dr["Price"].ToString());
                listView1.Items[count].SubItems.Add(dr["Size"].ToString());
                count++;
            }
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string isSelected = (string)comboBox1.SelectedItem;
            loadProductByCategoryName(isSelected);
        }

        public void calculateCost()
        {
            float sum = 0;
            foreach (OrderDetail o in orderDetails)
            {
                sum += o.Cost;
            }
            total = sum;
            lblTotalCost.Text = sum.ToString("c2").Remove(0, 1) + " VND";
        }

        public void addProductToList(OrderDetail orderDetail)
        {
            bool duplicate = false;
            foreach (OrderDetail o in orderDetails)
            {
                if (o.ProductId == orderDetail.ProductId)
                {
                    o.Quantity++;
                    o.Cost = o.Quantity * o.Price;
                    duplicate = true;
                }
            }
            if (!duplicate) orderDetails.Add(orderDetail);
            calculateCost();
        }

        private void listView1_MouseClick(object sender, MouseEventArgs e)
        {
            int productId = int.Parse(listView1.SelectedItems[0].SubItems[3].Text);
            float price = float.Parse(listView1.SelectedItems[0].SubItems[4].Text);
            string size = listView1.SelectedItems[0].SubItems[5].Text;
            string productname = listView1.SelectedItems[0].SubItems[0].Text;
            addProductToList(new OrderDetail(productId, productname, 1, size, price));
            dataGridView1.DataSource = null;
            dataGridView1.DataSource = orderDetails;
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.ColumnIndex == 5)
            {
                orderDetails[e.RowIndex].Quantity++;
                orderDetails[e.RowIndex].Cost = orderDetails[e.RowIndex].Quantity * orderDetails[e.RowIndex].Price;
                calculateCost();
                dataGridView1.DataSource = null;
                dataGridView1.DataSource = orderDetails;
            }

            if (e.ColumnIndex == 6)
            {
                try
                {
                    orderDetails[e.RowIndex].Quantity--;
                    orderDetails[e.RowIndex].Cost = orderDetails[e.RowIndex].Quantity * orderDetails[e.RowIndex].Price;
                    if (orderDetails[e.RowIndex].Quantity == 0)
                    {
                        orderDetails.Remove(orderDetails[e.RowIndex]);
                    }
                }
                catch (Exception)
                {
                    MessageBox.Show("Do not have product !");
                }
                calculateCost();
                dataGridView1.DataSource = null;
                dataGridView1.DataSource = orderDetails;
            }

            if (e.ColumnIndex == 8)
            {
                orderDetails.Remove(orderDetails[e.RowIndex]);
                calculateCost();
                dataGridView1.DataSource = null;
                dataGridView1.DataSource = orderDetails;
            }

        }

        private void btnCheckOut_Click(object sender, EventArgs e)
        {
            DateTime today = DateTime.Now;
            OrderDAO.addOrder(staffId, today);
            int oId = OrderDAO.getMaxOrderId();
            foreach (OrderDetail o in orderDetails)
            {
                OrderDetailDAO.addOrderDetail(oId, o.ProductId, o.Quantity);
            }
            if (orderDetails.Count <= 0)
            {
                MessageBox.Show("There is no order. You cannot checkout!");
            }
            else
            {
                BillDialog billDialog = new BillDialog(oId, orderDetails, staffName, total);
                billDialog.ShowDialog();
                orderDetails.RemoveRange(0, orderDetails.Count);
                dataGridView1.DataSource = null;
                dataGridView1.DataSource = orderDetails;
                lblTotalCost.Text = "0 VND";              
            }
        }
    }
}
